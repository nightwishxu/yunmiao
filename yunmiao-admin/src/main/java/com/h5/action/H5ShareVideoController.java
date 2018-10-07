package com.h5.action;

import com.paidang.dao.model.CertificateLogExample;
import com.paidang.dao.model.VideoOnline;
import com.paidang.dao.model.VideoOnlineExample;
import com.paidang.service.VideoOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/m/video")
@Controller
public class H5ShareVideoController extends H5BaseController{
    @Autowired
    private VideoOnlineService videoOnlineService;

    /**
     * H5分享视频
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/getShareVideo")
    public String toPage(Integer id, ModelMap map){
        if (null == id){
            return "common/404";
        }
        VideoOnline videoOnline = videoOnlineService.selectByPrimaryKey(id);
        if(null == videoOnline){
            return "common/404";
        }

        map.put("videoOnline",videoOnline);
        return BASE_PATH+"/share";
    }
}
