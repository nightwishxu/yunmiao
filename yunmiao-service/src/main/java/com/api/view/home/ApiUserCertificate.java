package com.api.view.home;

import io.swagger.annotations.ApiModel;

/**
 * 用户证书
 * @author vonkira
 *
 */
@ApiModel
public class ApiUserCertificate {

    //id
    private Integer id;
    //藏品名称
    private String name;
    //编号
    private String code;
    //藏品尺寸（长宽高）
    private String size;
    //藏品尺寸--长
    private String length;
    //藏品尺寸--宽
    private String width;
    //藏品尺寸--高
    private String height;
    //藏品重量
    private String weight;
    //材质
    private String material;
    //图片封面
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
