package com.api.view.pawnCate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 鉴定类型
 * @author vonkira
 *
 */
@ApiModel
public class AppPawnCate {
    @ApiModelProperty(value="分类id")
    private Integer id;
    @ApiModelProperty(value="编号")
    private Integer code;
    @ApiModelProperty(value="icon")
    private String icon;
    @ApiModelProperty(value="分类名称")
    private String name;
    @ApiModelProperty(value="鉴定类别")
    private String cateType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCateType() {
        return cateType;
    }

    public void setCateType(String cateType) {
        this.cateType = cateType;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
