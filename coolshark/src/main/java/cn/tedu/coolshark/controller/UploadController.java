package cn.tedu.coolshark.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {
//  @Value("${XXX}"): 将配置文件中的XXX的值注入到当前属性中
    @Value("${imagesPath}")
    private String dirPath;

    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        String fileName = picFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffix;
        SimpleDateFormat f = new SimpleDateFormat("/yyyy/MM/dd/");
        String datePath = f.format(new Date());
        File dirFile = new File(dirPath + datePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        picFile.transferTo(new File(dirPath + datePath + fileName));
        return datePath + fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url) {
        new File(dirPath + url).delete();
    }
}
