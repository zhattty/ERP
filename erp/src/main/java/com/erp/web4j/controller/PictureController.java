package com.erp.web4j.controller;

import com.erp.web4j.bean.PicMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZhangYao
 * Date 2019/4/6 Time 0:31
 */
@Controller
@RequestMapping("pic")
public class PictureController {
    @RequestMapping("upload")
    @ResponseBody
    public PicMsg uploadPicture(String dir, MultipartFile uploadFile){

    }
}
