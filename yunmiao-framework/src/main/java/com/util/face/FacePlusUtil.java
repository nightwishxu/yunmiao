package com.util.face;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.http.HttpUtil;
import com.base.util.ImageUtil;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FacePlusUtil {
    private static final String API_KEY = "L3RghbNcd-J2tpVxE7D9J9hLHZPbOiME";
    private static final String API_SECRET= "pEUyYyKvDN5lCxLTKapyW9m7OiOUzxrb";

    private enum APIENUM{
        DETECT("https://api-cn.faceplusplus.com/facepp/v3/detect"),
        COMPARE("https://api-cn.faceplusplus.com/facepp/v3/compare"),
        OCR_ID_CARD("https://api-cn.faceplusplus.com/cardpp/v1/ocridcard")
        ;

        String api;
        APIENUM(String api){
            this.api = api;
        }

        public String getApi(){
            return api;
        }
    }
    /**
     * 人脸识别
     * @param head
     * @return
     */
    public static Rectangle detect(File head){
        Map<String,Object> map = new HashMap<>(3);
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);
        map.put("image_file",head);
        String result = HttpUtil.post(APIENUM.DETECT.getApi(),map);
        System.out.println(result);
        JSONObject json = JSONObject.parseObject(result);
        JSONArray faces = json.getJSONArray("faces");
        if (faces.size() == 0){
            return null;
        }
        JSONObject face = faces.getJSONObject(0);
        JSONObject rec = face.getJSONObject("face_rectangle");
        int width = rec.getInteger("width");
        int height = rec.getInteger("height");
        int top = rec.getInteger("top");
        int left = rec.getInteger("left");
        return new Rectangle(left,top,width,height);
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
    public static float compare(File one, File two){
        Map<String,Object> map = new HashMap<>(4);
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);
        map.put("image_file1",one);
        map.put("image_file2",two);
        String result = HttpUtil.post(APIENUM.COMPARE.getApi(),map);
        JSONObject json = JSONObject.parseObject(result);
        Float confidence = json.getFloat("confidence");
        if (confidence == null){
            return 0;
        }
        return confidence.floatValue();
    }

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
     * 身份证识别
     * @param idImg
     * @return
     */
    public static String ocrCard(File idImg){
        Map<String,Object> map = new HashMap<>(3);
        map.put("api_key",API_KEY);
        map.put("api_secret",API_SECRET);
        map.put("image_file",idImg);
        String result = HttpUtil.post(APIENUM.OCR_ID_CARD.getApi(),map);
        return result;
    }
}
