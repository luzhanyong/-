package com.hrm.document.handler;

import com.hrm.commons.benas.Document;
import com.hrm.commons.benas.User;
import com.hrm.document.service.DocumentService;
import com.hrm.utils.PageModel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentHandler {
    @Autowired
    private DocumentService documentService;

    @RequestMapping("/findDocument")
    public String findDocument(Document document, @RequestParam(defaultValue = "1") int pageIndex,String title, Model model){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);

        int recordCount = documentService.findDocumentCount(title);
        pageModel.setRecordCount(recordCount);
        List<Document> documents = documentService.findDocument(title,pageModel);
        model.addAttribute("documents",documents);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("title",title);

        return "/jsp/document/document.jsp";
    }

    @RequestMapping("/addDocument")
    public String addDocument(Document document, HttpSession session,Model model) throws IOException {
        //1.保存上传的文件的服务器
        String path = "E:/upload";
        //获取原始文件名称
        String filename = document.getFile().getOriginalFilename();
        //定义保存的文件就是将MultipartFile转换为File,保存到服务期对应地址。
        document.getFile().transferTo(new File(path,filename));

        //2.数据库中插入对应的数据,给Document的filename赋值
        document.setFilename(filename);
        //获取当前登录用户，也就是文档上传者，从session当中获取用户信息。
        User login_user = (User) session.getAttribute("login_user");
        document.setUser(login_user);
        //调用Service方法插入文档信息
        int rows = documentService.addDocument(document);
        if (rows >0){
            return "redirect:/document/findDocument";
        }else {
            model.addAttribute("fail","文件上传失败！！！");
            return "/jsp/fail.jsp";
        }
    }

    @RequestMapping("/modifyDocument")
    public String modifyDocument(Document document,int pageIndex ,Model model,String flag) throws IOException {
        if (flag != null){
            document = documentService.findDocumentById(document.getId());
            model.addAttribute("document",document);
            model.addAttribute("pageIndex",pageIndex);
            return "/jsp/document/showUpdateDocument.jsp";
        }else {
            //将修改后的文件添加到服务器
            String path = "E:/upload";
            //获取患失文件名称
            String filename =System.currentTimeMillis() + "---" + document.getFile().getOriginalFilename();
            document.getFile().transferTo(new File(path,filename));

            document.setFilename(filename);
            //修改书库中信息
            int rows = documentService.modifyDocument(document);
            if (rows > 0){
                return "redirect:/document/findDocument?pageIndex"+pageIndex;
            }else {
                model.addAttribute("fail","文件修改失败！！！");
                return "/jsp/fail.jsp";
            }
        }
    }

    @RequestMapping("/downLoad")
    public ResponseEntity<byte[]> downLoad(Integer id) throws IOException {
        String path = "E:/upload";
        Document targetDocument = documentService.findDocumentById(id);
        String filename = targetDocument.getFilename();

        //获取下载的目标文件
        File file = new File(path,filename);

        filename = new String(filename.getBytes("UTF-8"),"iso8859-1");//不是个使用与IE浏览器
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",filename);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }

    @RequestMapping("/removeDocument")
    public String removeDocument(Integer[] ids , Model model){
        String path = "E:/upload";
        int rows = 0;
        //查找要删除的文件目标
        for (Integer id : ids) {
            Document target = documentService.findDocumentById(id);
            File targetFile = new File(path,target.getFilename());
            //如果目标文档存在，从服务器删除文件。
            if (targetFile.exists()){
                targetFile.delete();
            }
            //删除文件对应的数据库信息
            int i = documentService.removeDocument(id);
            if (i > 0){
                rows++;
            }
        }
        if (rows == ids.length){
            return "redirect:/document/findDocument";
        }else {
            model.addAttribute("fail","文件删除失败！！！");
            return "/jsp/fail.jsp";
        }
    }

}
