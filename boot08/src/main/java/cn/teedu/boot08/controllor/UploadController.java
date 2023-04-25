package cn.teedu.boot08.controllor;

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
    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        String fileName = picFile.getOriginalFilename();
        System.out.println(fileName);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName= UUID.randomUUID()+suffix;
        System.out.println(fileName);
        String dirPath = "E:/JSD_2302_03/boot08/src/main/resources/static/images/";
//      准备一个日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
//      得到当前系统时间的日期字符串
        String datePath = sdf.format(new Date());
        File dir = new File(dirPath + datePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        picFile.transferTo(new File(dirPath+datePath+fileName));
        return datePath+fileName;
    }
    @RequestMapping("/remove")
    public void remove(String url){
        System.out.println("url="+url);
        File f = new File("E:/JSD_2302_03/boot08/src/main/resources/static/images/"+url);
        f.delete();
    }
}
