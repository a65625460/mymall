package com.dong.mymall.controller;

import com.dong.mymall.controller.ex.FileUploadContentTypeException;
import com.dong.mymall.controller.ex.FileUploadEmptyException;
import com.dong.mymall.controller.ex.FileUploadIOException;
import com.dong.mymall.controller.ex.FileUploadSizeOutOfBoundException;
import com.dong.mymall.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("${file.upload-size-max}")
    private long fileUploadMaxSize;
    @Value("${file.upload-content-type}")
    private List fileUploadContentType;

    @PostMapping("/user/avatar")
    public JsonResult<String> uploadUserAvatar(MultipartFile file, HttpServletRequest request) {
        // 判断上传的文件是否为空
        if (file.isEmpty()) {
            // 是：FileUploadEmptyException
            throw new FileUploadEmptyException("文件上传失败，上传文件为空！");
        }
        // 判断上传文件的类型是否不在指定类型中
        if (!fileUploadContentType.contains(file.getContentType())) {
            // 是：FileUploadContentTypeException
            throw new FileUploadContentTypeException("文件上传失败，上传的文件类型只能是" + fileUploadContentType + "!");
        }
        // 判断上传文件的大小是否不在指定范围内
        if (file.getSize() > fileUploadMaxSize) {
            // 是：FileUploadSizeOutOfBoundException
            throw new FileUploadSizeOutOfBoundException("上传文件失败，上传文件大小不能大于" + (fileUploadMaxSize / 1024 / 1024) + "MB!");
        }
        // 定义存放的文件名
        String fileName = "/" + System.currentTimeMillis() + System.nanoTime();
        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件最后一个.的下标位置
        int beginIndex = originalFilename.lastIndexOf(".");
        // 获取文件的后缀名
        String suffix = originalFilename.substring(beginIndex);
        // 定义存放的文件名全称
        String child = fileName + suffix;
        // 定义存放文件的目录名
        String parent = "/img/avatar";
        try {
            // 获取对应的存放目录的file对象
            File parentDir = ResourceUtils.getFile("classpath:static" + parent);
            // 生成存放文件的目标对象
            File dest = new File(parentDir, child);
            // 存入文件
            file.transferTo(dest);
        } catch (IOException e) {
            // 捕获异常后抛出自定义异常
            throw new FileUploadIOException("文件上传失败，文件上传时出现读写异常！请稍后再试！");
        }
        // 获取生成的文件的路径
        String avatar = parent + child;
        return JsonResult.getSuccessResult(avatar);
    }
}
