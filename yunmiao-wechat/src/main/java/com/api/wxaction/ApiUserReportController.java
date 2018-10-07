package com.api.wxaction;

import com.base.api.ApiBaseController;
import com.base.api.annotation.ApiMethod;
import com.base.lang.Dict;
import com.base.util.JSONUtils;
import com.item.dao.model.SysDict;
import com.item.dao.model.SysDictExample;
import com.item.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/userReport", produces = {"application/json;charset=UTF-8"})
@Api(tags = "举报相关")
public class ApiUserReportController extends ApiBaseController {

    @Autowired
    private SysDictService sysDictService;


    @ApiOperation(value = "举报信息", notes = "")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = false)
    public Object list(){

        SysDictExample example=new SysDictExample();
        example.createCriteria().andTypeEqualTo("report");
        List<SysDict>  list=sysDictService.selectByExample(example);
        if (list!=null && list.size()>0){
            return (List<String>)JSONUtils.deserialize(list.get(0).getValue(),List.class);
        }
        return null;
    }


}
