package com.erp.web4j.controller;

import com.erp.web4j.bean.DeleteMsg;
import com.erp.web4j.bean.PicMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by ZhangYao
 * Date 2019/4/6 Time 0:31
 */
@Controller
@RequestMapping("pic")
public class PictureController {
    @RequestMapping("upload")
    @ResponseBody
    public PicMsg uploadPicture(String dir, MultipartFile uploadFile, HttpServletRequest request){
        final String DIRS = "/pic/";
        PicMsg picMsg = new PicMsg();
        if (uploadFile == null){
            return picMsg;
        }
        String realPath = request.getServletContext().getRealPath("");
        String originalFilename = uploadFile.getOriginalFilename();
        String filename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File file = new File(realPath+DIRS);
        if (!file.exists()){
            file.mkdir();
        }
        String relativePath = DIRS+filename;
        realPath = realPath + relativePath;
        try {
            File file1 = new File(realPath);
            uploadFile.transferTo(file1);
            picMsg.setError(0);
            picMsg.setUrl("\\pic\\"+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picMsg;
    }

    @RequestMapping("delete")
    @ResponseBody
    public DeleteMsg deletePicture(@RequestParam("picName")String picName, HttpServletRequest request){
        DeleteMsg deleteMsg = new DeleteMsg();
        final String DIRS = "/pic/";
        String realPath = request.getServletContext().getRealPath(picName);
        File file = new File(realPath);
        if (file.exists()){
            boolean delete = file.delete();
            deleteMsg.setData("success");
        }
        return deleteMsg;
    }
}
