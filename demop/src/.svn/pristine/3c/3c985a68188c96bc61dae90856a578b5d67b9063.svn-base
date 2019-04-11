package com.en.adback.mapper.analisys;

import com.en.adback.entity.PlayLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlayLogMapper {

    @Select("<script>" +
            "select to_char(TO_TIMESTAMP(to_char(playtime,'yyyy-MM-dd HH:mm:ss'), 'yyyy-MM-dd HH:mm:ss', 'GMT+8'), 'yyyy-MM-dd HH:mm:ss') as playTime," +
            " media.duration as duration, screen.policyName as policyName,cut.screenCutName as screen,cut.position as screenPosition, " +
            "advert.advertId as advertId,advert.advertName as advertName,b.screenName as screenName, rec.deviceId as deviceId  " +
            "from idcard.t_advert_play_rec rec " +
            "inner join ad.t_advert_media media on rec.fileName = media.downLoadFileName " +
            "inner join ad.t_advert advert on advert.advertId = media.advertId " +
            "inner join ad.t_sub_advert_policys subPolicys on subPolicys.advertId = advert.advertId " +
            "inner join ad.t_advert_policys policys on policys.advertPolicysId = subPolicys.advertPolicysId " +
            "inner join ad.t_play_policy_screen screen on screen.screenPolicyId = policys.screenPolicyId " +
            "inner join ad.t_screen_cut cut on cut.screenCutId = subPolicys.screenCutId " +
            "inner join ad.t_screen_form a on a.screenCutId = cut.screenCutId " +
            "inner join ad.t_screen b on b.screenId = a.screenId " +
            "where 1=1 " +
            "<if test='beginDate!=null and beginDate!=\"\" and endDate!=\"\" and endDate!=null '>" +
            "<![CDATA[ and TO_TIMESTAMP(to_char(playTime,'yyyy-MM-dd HH'), 'yyyy-MM-dd HH', 'GMT+8') between to_date('${beginDate}','yyyy-MM-dd')" +
                         " and to_date('${endDate}','yyyy-MM-dd')  ]]>" +
            "</if>" +
            "<if test='deviceId!=\"\"and deviceId!=null  '>" +
            " and rec.deviceId='${deviceId}' " +
            "</if>" +
            " order by TO_TIMESTAMP(to_char(rec.playTime,'yyyy-MM-dd HH'), 'yyyy-MM-dd HH', 'GMT+8') asc" +
            "</script>")
    public List<PlayLog> getPlayLlogList(Map<String,Object> map);
//    to_char(TO_TIMESTAMP(to_char(playtime,'yyyy-MM-dd HH'), 'yyyy-MM-dd HH', 'GMT+8'), 'yyyy-MM-dd')
}
