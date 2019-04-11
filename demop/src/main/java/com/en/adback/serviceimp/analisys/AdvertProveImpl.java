package com.en.adback.serviceimp.analisys;

import com.en.adback.mapper.analisys.AdvertProveMapper;
import com.en.adback.service.analisys.IAdvertProveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdvertProveImpl implements IAdvertProveService {
    @Autowired
    private AdvertProveMapper proveMapper;


    @Override
    public Map<String, String> getAdvertPlayInfo(String advertName, String startDate, String endDate) {
        Map<String, String> advertPlayInfo = proveMapper.getAdvertPlayInfo(advertName);

        if (StringUtils.isEmpty(advertPlayInfo)||StringUtils.isEmpty(advertPlayInfo.get("playDates"))){
             advertPlayInfo = new HashMap<>();
             advertPlayInfo.put("playDayNum", String.valueOf(0));
            advertPlayInfo.put("playDates","");
             advertPlayInfo.put("devices","");
        }else{
            String[] playDateArray = advertPlayInfo.get("playDates").split(",");
            List<String> playDateList = Arrays.stream(playDateArray).filter(date -> date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0).collect(Collectors.toList());
            advertPlayInfo.put("playDayNum", String.valueOf(playDateList.size()));
            advertPlayInfo.put("playDates",playDateList.stream().collect(Collectors.joining(",")));
        }
        return advertPlayInfo;
    }
}
