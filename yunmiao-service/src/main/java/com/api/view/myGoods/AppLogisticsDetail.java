package com.api.view.myGoods;

import com.paidang.dao.model.UserGoods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 物流信息详情
 * @author vonkira
 *
 */
@ApiModel
public class AppLogisticsDetail {

    @ApiModelProperty(value="宝贝id")
    private Integer id;
    @ApiModelProperty(value="宝贝名称")
    private String name;
    @ApiModelProperty(value="快递单号")
    private String postExpressCode;
    @ApiModelProperty(value="物流状态(0：在途1：揽件2：疑难3：签收4：退签或异常签收5：派件6：退回)---寄往平台")
    private Integer postState;
    @ApiModelProperty(value="物流状态(0：在途1：揽件2：疑难3：签收4：退签或异常签收5：派件6：退回)---平台取回")
    private Integer backState;
    @ApiModelProperty(value="图片")
    private String images;

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

    public String getPostExpressCode() {
        return postExpressCode;
    }

    public void setPostExpressCode(String postExpressCode) {
        this.postExpressCode = postExpressCode;
    }

    public Integer getPostState() {
        return postState;
    }

    public void setPostState(Integer postState) {
        this.postState = postState;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getBackState() {
        return backState;
    }

    public void setBackState(Integer backState) {
        this.backState = backState;
    }
}
