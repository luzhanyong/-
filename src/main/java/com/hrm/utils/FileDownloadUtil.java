package com.hrm.utils;

import com.hrm.commons.benas.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author 卢占勇
 * @desc
 * @date 2022/3/22
 */
public class FileDownloadUtil {

    private static File xexcel;

    private static File cexcel;

    private static File kexcel;


    //创建要下载的文件
    public static String fileCreate(HttpSession session,String dirname,String fileName){
        /*
           准备把上传图片保存在upload目录下，还有子目录 upload/校/文件
        */
        // 1、创建图片要存放的文件夹路径
        String realPath = session.getServletContext().getRealPath("/download");
        realPath += File.separator +dirname;

        Result result = new Result();

        File file = new File(realPath);
        if(!file.exists()){
            //创建带层级的目录 mkdir:只能创建一级目录
            file.mkdirs();
        }

        //2、将上传的excel转移到刚刚创建的路径
        xexcel =  new File(file,fileName);

        return realPath+File.separator+fileName;
    }

}
