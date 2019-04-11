package com.en.adback.entity.adreplace;

import com.en.adback.entity.UserAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@ApiModel
public class AdReplaceInParams extends UserAction {

    @ApiModelProperty(value = "源广告唯一ID,前端传入,必须.",required = true)
    private  String sourceAdvertPolicyId;
    @ApiModelProperty(value = "新广告唯一ID,前端传入,必须.",required = true)
    private String advertPolicyId;
    @ApiModelProperty(value = "要替换的设备,字符串，用,分割.前端传入,必须.",required = true)
    private String devices;
    @ApiModelProperty(value = "要替换的广告信息集合,前端传入必须.",required = true)
    private List<AdvertInfo> adverts;


       @Data
       @NoArgsConstructor
        public static class AdvertInfo {
           @ApiModelProperty(value = "切屏编号.前端传入,必须.",required = true)
           private String  screenCutId;   // 切屏编号
           @ApiModelProperty(value = "新广告ID.前端传入,必须.",required = true)
           private  String advertId;   // 新广告编号
           @ApiModelProperty(value = "广告文件名称,后台查询赋值",required = false)
           private   String advertName; //广告文件名称
           @ApiModelProperty("被替换广告ID,后台查询赋值")
           private  String  srcAdvertId;  //被替换的广告Id
           @ApiModelProperty("被替换广告名称,后台查询赋值")
           private  String  srcAdvertName;  //被替换的广告名称
       }
}
