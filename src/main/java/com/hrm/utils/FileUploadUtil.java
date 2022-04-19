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
public class FileUploadUtil {

    private static File xexcel;

    private static File cexcel;

    private static File kexcel;

    //上传校级表格
    public static Result fileUploadXexcel(@RequestParam("xexcel") MultipartFile excel,
                                    HttpSession session,String dirname,String fileName){
        /*
           准备把上传图片保存在upload目录下，还有子目录 upload/校/文件
        */
        // 1、创建图片要存放的文件夹路径
        String realPath = session.getServletContext().getRealPath("/upload");
        realPath += File.separator +dirname;

        Result result = new Result();

        File file = new File(realPath);
        if(!file.exists()){
            //创建带层级的目录 mkdir:只能创建一级目录
            file.mkdirs();
        }

        //2、将上传的excel转移到刚刚创建的路径
        xexcel =  new File(file,fileName);

        try {
            excel.transferTo(xexcel);
            result.setCode(0);
            result.setMessage(xexcel.getAbsolutePath());
        } catch (IOException ioException) {
            ioException.printStackTrace();
            result.setMessage("导入失败");
            result.setCode(1);
        }
        return result;
    }

    //上传处级表格
    public static Result fileUploadCexcel(@RequestParam("cexcel") MultipartFile excel,
                                    HttpSession session,String dirname,String fileName){
        /*
           准备把上传图片保存在upload目录下，还有子目录 upload/校/文件
        */
        // 1、创建图片要存放的文件夹路径
        String realPath = session.getServletContext().getRealPath("/upload");
        realPath += File.separator +dirname;

        Result result = new Result();

        File file = new File(realPath);
        if(!file.exists()){
            //创建带层级的目录 mkdir:只能创建一级目录
            file.mkdirs();
        }

        //2、将上传的excel转移到刚刚创建的路径
        cexcel =  new File(file,fileName);

        try {
            excel.transferTo(cexcel);
            result.setCode(0);
            result.setMessage(cexcel.getAbsolutePath());
        } catch (IOException ioException) {
            ioException.printStackTrace();
            result.setMessage("导入失败");
            result.setCode(1);
        }
        return result;
    }

    //上传科级表格
    public static Result fileUploadKexcel(@RequestParam("kexcel") MultipartFile excel,
                                          HttpSession session,String dirname,String fileName){
        /*
           准备把上传图片保存在upload目录下，还有子目录 upload/校/文件
        */
        // 1、创建图片要存放的文件夹路径
        String realPath = session.getServletContext().getRealPath("/upload");
        realPath += File.separator +dirname;

        Result result = new Result();

        File file = new File(realPath);
        if(!file.exists()){
            //创建带层级的目录 mkdir:只能创建一级目录
            file.mkdirs();
        }
        //2、将上传的excel转移到刚刚创建的路径
        kexcel =  new File(file,fileName);
        try {
            excel.transferTo(kexcel);
            result.setCode(0);
            result.setMessage(kexcel.getAbsolutePath());
        } catch (IOException ioException) {
            ioException.printStackTrace();
            result.setMessage("导入失败");
            result.setCode(1);
        }
        return result;
    }

    public static void delectXexcel(){
        xexcel.delete();
    }

    public static void delectCexcel(){
        cexcel.delete();
    }

    public static void  delectKexcel(){
        kexcel.delete();
    }

}
