package com.en.adback.controller.advertmgr;


import com.alibaba.fastjson.JSON;
import com.en.adback.common.HttpUtil;
import com.en.adback.common.MessageModel;
import com.en.adback.entity.dic.Blank;
import com.en.adback.service.advertmgr.IDevicePolicyService;
import com.en.adback.service.advertmgr.IFilePutinCityHostService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

// @Api(value="广告策略计算",tags={"广告策略计算webapi接口"})
@RestController
@CrossOrigin
@RequestMapping(value = "/api/policy", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class AdvertPolicysCalOrderCtrl {
     @Autowired
     private IDevicePolicyService psvr;
     @Autowired
     private IFilePutinCityHostService fsvr;
    //计算设备策略
     @GetMapping(value="/calp")
    public MessageModel calPolicy(String theDate){
        MessageModel m= new MessageModel();
        System.out.print("ok1");
        String wrongmsg="ok";
           List<Map<String,Object>> delist=this.deList();
           if (delist==null || delist.size()==0)
           {
               System.out.print("ok2");
               m.setResultCode("0");
               m.setResultMsg("获取不到设备");
           }else {
               psvr.calDayPolicy(theDate,delist);
               System.out.print("ok2");
               m.setResultCode("1");
               m.setResultMsg(wrongmsg);
           }



        return m;
    }

     //计算每日下发文件
     @GetMapping(value="/calh")
    public MessageModel calHostDownload(String theDate){
        MessageModel m= new MessageModel();

         List<Map<String,Object>> delist=this.deList();
         if (delist==null || delist.size()==0)
         {
             System.out.print("ok2");
             m.setResultCode("0");
             m.setResultMsg("获取不到设备");
         }else {
             fsvr.calFilePutin(theDate,delist);
             m.setResultCode("1");
             m.setResultMsg("ok");
         }
        return m;
    }

    @GetMapping(value="/test")
    public MessageModel test() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        Date newTime = calendar.getTime();
        String theDate = df.format(newTime);
        //计算每日下发文件
        fsvr.calFilePutin(theDate,deList());
        // 计算播放策略
        psvr.calDayPolicy(theDate,deList());
        return null;
    }


    @GetMapping(value="/test1")
    public String test1() {
         Blank b = new Blank();
         b.setBlankId("001");
         b.setBlankName("safdew");
        Optional<Blank> blank=Optional.of(b);

        return null;
    }



    @Value("${idcardurl}")
    private String idcardurl;
    // 取设备
    public  List<Map<String, Object>> deList(){
        HttpUtil httpUtil = new HttpUtil();
        List<Map<String, Object>> dlist=null;
        try {
            String result = httpUtil.sendGetRequest(idcardurl + "/api/device/allUsefulDevices", null);
            Map<String, Object> remapper = JSON.parseObject(result, Map.class);
            dlist = (List<Map<String, Object>>) ((Map<String, Object>) remapper.get("data")).get("list");
        }catch (IOException ex){
            return null;
        }
        return dlist;
    }
}
