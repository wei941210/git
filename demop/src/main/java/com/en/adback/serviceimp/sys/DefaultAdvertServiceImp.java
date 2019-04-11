package com.en.adback.serviceimp.sys;

import com.en.adback.entity.sys.DefaultAdvert;
import com.en.adback.mapper.sys.DefaultAdvertMapper;
import com.en.adback.service.sys.IDefaultAdvertService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */
@Service
public class DefaultAdvertServiceImp implements IDefaultAdvertService {

    @Autowired
    private DefaultAdvertMapper mapper ;
    @Value("${advertfiles}")
    private String advertfiles;

    @Override
    public List<DefaultAdvert> getDefaultAdvertList() {
        return mapper.getDefaultAdvertList();
    }

    @Override
    public int insertDefaultAdvert(DefaultAdvert defaultAdvert) {

        try {
            defaultAdvert.setFileMD5(DigestUtils.md5Hex(new FileInputStream(advertfiles+"media"+ File.separator+defaultAdvert.getDefaultFileName())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapper.insertDefaultAdvert(defaultAdvert);
    }


}
