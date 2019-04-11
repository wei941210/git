package com.en.adback.service.analisys;

import java.util.Map;

public interface IAdvertProveService {

    public Map<String, String> getAdvertPlayInfo(String advertName, String startDate, String endDate);
}
