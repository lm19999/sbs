package com.systop.sbs.common.util;


import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class UploadImage {

    /***图片的上传路径*/
    public final static String UPLOAD_FILE = System.getProperty("user.dir") + "/src/main/resources/static/images/";
    /***图片的查看路径*/
    public final static String VIRTUAL_IMG_PATH = "/images";
    /***数据库存放路径,本地就是http://localhost:8080/*/
    public final static String IMG_PATH = "http://localhost:8080";

    public static String uploadImage(MultipartFile file, Integer width, Integer height) {

        String url = IMG_PATH + VIRTUAL_IMG_PATH;
        String filename = file.getOriginalFilename();
        //图片类型  jpg或者png
        String imgType = filename.substring(filename.lastIndexOf(".") + 1);
        //图片前缀
        String imgPrefix = getTimeString();
        //图片名称
        String uploadFileName = imgPrefix + "." + imgType;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd/HH");
        //图片路径 无图片名称
        String finalPath = UPLOAD_FILE + simpleDateFormat.format(new Date());
        File filepath = new File(finalPath);
        if (!filepath.exists()) {
            filepath.setWritable(true);
            filepath.mkdirs();
        }
        File targetfile = new File(finalPath, uploadFileName);
        String gPicture;
        try {
            //文件已经上传成功
            file.transferTo(targetfile);
            if (width != null && height != null) {
                Thumbnails.of(finalPath + "/" + uploadFileName).size(width, height).keepAspectRatio(false).toFile(finalPath + "/" + uploadFileName);
            }
            Thumbnails.of(finalPath + "/" + uploadFileName).scale(1f)
                    .outputQuality(0.6f).outputFormat("jpg").toFile(finalPath + "/" + imgPrefix + ".jpg");

            if ("png".equals(imgType)|| "PNG".equals(imgType)) {
                File file1 = new File(finalPath + "/" + uploadFileName);
                file1.delete();
            }
            gPicture = url + "/" + finalPath.substring(finalPath.indexOf("images") + 7) + "/" + imgPrefix + ".jpg";
        } catch (IOException e) {
            return null;
        }
        return gPicture;
    }

    /**
     * 判断文件大小
     *
     * @param len  文件长度
     * @param size 限制大小
     * @param unit 限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
//        long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }

    /**
     * @return 带年月日的前缀
     */
    public static String getTimeString() {
        String substring = UUID.randomUUID().toString().replace("-", "").substring(4, 14);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssS");
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime()) + substring;
    }

}