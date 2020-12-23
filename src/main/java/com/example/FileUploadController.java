package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping("/file")
    public String showUploadForm(){
//        String str=null;
//        System.out.println(str.length());
        return "file_form";
    }

    @RequestMapping(path = "/uploadImage",method = RequestMethod.POST)
    public String uploadImage(@RequestParam("profile") CommonsMultipartFile file, HttpSession session, Model model) throws FileNotFoundException {
        System.out.println("file size="+file.getSize());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        byte data[]=file.getBytes();

        //We have to save this file to server
        String path=session.getServletContext().getRealPath("/")+"WEB-INF" + File.separator+ "resources"+ File.separator +"image"+File.separator+ file.getOriginalFilename();
        System.out.println(path);

        try {
            FileOutputStream fos=new FileOutputStream(path);
            fos.write(data);
            fos.close();
            model.addAttribute("filename",file.getOriginalFilename());
            model.addAttribute("message","uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message","uploaded error");
        }

        System.out.println("file");
        return "fileSuccess";
    }
}
