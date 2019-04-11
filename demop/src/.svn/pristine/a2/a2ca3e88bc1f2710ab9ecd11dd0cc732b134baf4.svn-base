package com.en.adback.controller.analisys;


import com.en.adback.common.MessageModel;
import com.en.adback.service.analisys.IAdvertProveService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value="广告证明查询",tags={"广告证明查询webapi接口"})
@RestController
@CrossOrigin
@RequestMapping(value = "/api/playProve", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AdvertProveCtrl {


    @Autowired
    private IAdvertProveService proveService;

    @ApiOperation( value = "获取广告证明信息",notes = "获取广告证明信息api接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "advertName", value = "广告名称(wei唯一)", required = true, dataType = "AdReplaceInParams", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "查询开始时间(xxxx-xx-xx,与数据库palyDates中格式一致)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "查询截止时间(xxxx-xx-xx,与数据库palyDates中格式一致)", required = true, dataType = "String", paramType = "query"),
    })
    @ApiResponses({ @ApiResponse(code = 1, message = "操作成功"),
            @ApiResponse(code = 2, message = "服务器内部异常"),
            @ApiResponse(code =3, message = "权限不足"),
            @ApiResponse(code =4, message = "参数错误") })
    @RequestMapping(value = "/getPlayProveInfo", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<MessageModel> getAdvertPlayInfo(String advertName, String startDate, String endDate){


        Map<String, String> advertPlayInfo = proveService.getAdvertPlayInfo(advertName, startDate, endDate);


        MessageModel m = new MessageModel();
        m.setResultCode("1");
        m.setResultMsg("ok");
        m.setData(advertPlayInfo);
        return ResponseEntity.ok(m);
    }
}
