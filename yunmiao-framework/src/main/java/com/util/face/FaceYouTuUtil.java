package com.util.face;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.util.ImageUtil;
import com.util.ocr.OcrIdInfo;
import com.youtu.Youtu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class FaceYouTuUtil {
    private static final String API = "http://api.youtu.qq.com/youtu/api/facecompare";
    private static final String APPID = "10105746";
    public static final String SECRET_ID = "AKID56xc5dMHJ9nOtC9Dzd9VfdT8brwowyGM";
    public static final String SECRET_KEY = "72lKivvjYHsIWYNzOabQM9k8KLAnEYgf";


    private static Youtu youtu;

    static {
        youtu = new Youtu(APPID,SECRET_ID,SECRET_KEY,Youtu.API_YOUTU_END_POINT);
    }

    /**
     * 人脸对比返回匹配度
     * @param one
     * @param two
     * @return
     */
    public static float compare(File one, File two){
        try {
            JSONObject jsonObject = youtu.FaceCompare(one.getAbsolutePath(),two.getAbsolutePath());
            Float confidence = jsonObject.getFloat("similarity");
            System.out.println(jsonObject.toString());
            return confidence == null?0:confidence.floatValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Rectangle detect(File img){
        try {
            JSONObject jsonObject = youtu.DetectFace(img.getAbsolutePath(),0);
            if (0 == jsonObject.getIntValue("errorcode")){
                JSONArray faceItems = jsonObject.getJSONArray("face");
                if (faceItems.size() > 0){
                    JSONObject face = faceItems.getJSONObject(0);
                    Rectangle rectangle = new Rectangle(face.getIntValue("x"),face.getIntValue("y"),face.getIntValue("width"),face.getIntValue("height"));
                    System.out.println(rectangle.toString());
                    return rectangle;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File detectOcr(File ocr){
        Rectangle rectangle = detect(ocr);
        if (rectangle != null){
            String path = ocr.getAbsolutePath();
            int dot = path.lastIndexOf(".");
            String newName = path.substring(0,dot)+"_head"+path.substring(dot);
            File head = new File(newName);
            ImageUtil.cut(ocr,head,rectangle);
            return head;
        }
        return null;
    }

    /**
     * 人脸对比返回匹配度
     * @param one
     * @param two
     * @return
     */
    public static float compareOcr(File one, File two){
        File head = detectOcr(one);
        if (head == null){
            return 0;
        }
        File towHead = detectOcr(two);
        if (towHead == null){
            return 0;
        }
        return compare(head,towHead);
    }

    /**
     *
     * @param idCard 身份证图片
     * @return
     */
    public static OcrIdInfo ocr(File idCard){
        return ocr(idCard,0);
    }

    /**
     *
     * @param idCard 身份证图片
     * @param type 身份证图片类型，0-正面(有照片的一面)，1-反面(国徽)
     * @return
     */
    public static OcrIdInfo ocr(File idCard, int type){
        try {
            JSONObject jsonObject = youtu.IdCardOcr(idCard.getAbsolutePath(), type);
            System.out.println(jsonObject.toJSONString());
            if (0 == jsonObject.getIntValue("errorcode")){
                OcrIdInfo info = new OcrIdInfo();
                info.setAddress(jsonObject.getString("address"));
                info.setAuthority(jsonObject.getString("authority"));
                info.setName(jsonObject.getString("name"));
                info.setSex(jsonObject.getString("sex"));
                info.setValid_date(jsonObject.getString("valid_date"));
                info.setNation(jsonObject.getString("nation"));
                info.setBackimage(jsonObject.getString("backimage"));
                info.setFrontimage(jsonObject.getString("frontimage"));
                info.setId(jsonObject.getString("id"));
                return info;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 银行卡OCR识别
     * @param idCard 银行卡图片地址
     * @return
     */
    public static String ocrBankCard(String idCard){
        try {
            JSONObject jsonObject = youtu.BankCardOcr(idCard);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] audio(String text){
        return audio(text,0,0);
    }

    /**
     *
     * @param text
     * @param type 0表示女声，1表示女声纯英文，2表示男声，6表示喜道公子
     * @param speed -2, -1, 0, 1, 2分别表示0.6倍速，0.8倍速，正常速度，1.2倍速，1.5倍速
     */
    public static byte[] audio(String text, int type, int speed){
        try {
            if (text == null || text.getBytes("utf-8").length > 300){
                return null;
            }
            JSONObject jsonObject = youtu.textToAudio(text,type,speed);
            if (0 == jsonObject.getIntValue("errorcode")){
                return jsonObject.getBytes("voice");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(ocr(new File("Z:\\paidang\\2017-11-2\\jpg\\166037f387f349788577f46be29fbd3e.JPG")));
//        System.out.println(FacePlusUtil.compare(new File("Z:\\paidang\\2017-11-2\\jpg\\ffba0be045e144c29a7f81e5532022ef.jpg"),new File("Z:\\paidang\\2017-11-2\\jpg\\aaa0672f8c104bdf96077235943c8c0c.jpg")));
//        System.out.println(compare(new File("Z:\\paidang\\2017-11-2\\jpg\\ffba0be045e144c29a7f81e5532022ef.jpg"),new File("Z:\\paidang\\2017-11-1\\jpg\\4b0ce61a8f7f4a479708288ddd87f909.jpg")));
        System.out.println(compareOcr(new File("Z:\\paidang\\2017-11-2\\jpg\\ffba0be045e144c29a7f81e5532022ef.jpg"),new File("Z:\\paidang\\2017-11-2\\jpg\\8d4e092e525745d69a93d4e1a53b6a81.jpg")));
    }
}
