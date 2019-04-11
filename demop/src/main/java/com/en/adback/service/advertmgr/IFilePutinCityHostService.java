package com.en.adback.service.advertmgr;

import java.util.List;
import java.util.Map;

//文件下发服务器策略
public interface IFilePutinCityHostService {

    //计算该天文件下发服务器策略
    public void calFilePutin(String theDate,List<Map<String,Object>> deList);

}
