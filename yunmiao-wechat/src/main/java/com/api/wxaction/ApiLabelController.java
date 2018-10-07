package com.api.wxaction;

import com.base.api.ApiBaseController;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.item.dao.model.Label;
import com.item.dao.model.LabelExample;
import com.item.daoEx.model.LabelEx;
import com.item.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value="/api/label", produces = {"application/json;charset=UTF-8"})
@Api(tags = "动态标签相关")
public class ApiLabelController  extends ApiBaseController {

    @Autowired
    private LabelService labelService;

    @ApiOperation(value = "标签列表", notes = "")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Object list(MobileInfo mobileInfo
                      ){

        LabelExample example=new LabelExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andTypeEqualTo(0);
        example.or().andTypeEqualTo(1).andUserIdEqualTo(mobileInfo.getUserid());
        return labelService.selectByExample(example);
    }

    @ApiOperation(value = "新增标签", notes = "")
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Integer add(MobileInfo mobileInfo,
                       @ApiParam(value = "标签名", required = true)String name
                       ){

        Label label=new Label();
        label.setCreateTime(new Date());
        label.setSort(1);
        label.setName(name);
        label.setStatus(1);
        label.setUserId(mobileInfo.getUserid());
        label.setType(1);
        return labelService.insert(label);
    }
}
