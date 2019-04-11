package com.en.adback.mapper.analisys;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface AdvertProveMapper {

    // 备用sql:
    // select a.advertPolicysId,a.playDates,a.devices
    // FROM ad.T_ADVERT_POLICYS a inner join ad.T_SUB_ADVERT_POLICYS b on a.advertPolicysId= b.advertPolicysId inner join ad.T_ADVERT_MEDIA c on b.advertId = c.advertId
    // where c.downloadFileName = '155321745926540875f74e8f04a82b546d4b67bf3dfa4.jpg'
    @Select(
                    " SELECT playDates as \"playDates\",devices  as \"devices\" " +
                    " FROM ad.t_advert_policys " +
                    " WHERE advertPolicysID=( " +
                    " SELECT advertPolicysId FROM ad.t_sub_advert_policys WHERE advertId = " +
                    " (SELECT advertId FROM ad.t_advert_media WHERE downloadFileName = '${advertName}' )) "
               )
    public Map<String,String> getAdvertPlayInfo(@Param("advertName") String advertName);
}
