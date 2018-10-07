package com.h5.action;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lee on 2018/2/2.
 *
 * 废弃
 */
public class OrgContractController extends H5BaseController{

    @RequestMapping("/toOrgContract/{id}")
    public String toPage(@PathVariable(value = "id") String id, ModelMap map){
        map.put("id",id);//典当或者续当id

        return BASE_PATH+"/orgContract";
    }

}
