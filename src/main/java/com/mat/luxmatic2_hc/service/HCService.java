package com.mat.luxmatic2_hc.service;

import com.mat.luxmatic2_hc.dao.HCDAO;
import com.mat.luxmatic2_hc.model.Criteria;
import com.mat.luxmatic2_hc.model.SecurityLightVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HCService {

    @Autowired
    private HCDAO dao;

    private List<SecurityLightVO> list;

    public List<SecurityLightVO> getAllList(Criteria cri) {
        list = new ArrayList<>();

        setKeyword(cri);

        try {
            list = dao.getAllList(cri);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return list;
    }

    public List<SecurityLightVO> getTableList(Criteria cri) {
        list = new ArrayList<>();

        setKeyword(cri);

        try {
            list = dao.getTableList(cri);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return list;
    }

    public List<String> getDongInfo() {
        List<String> dongInfo = new ArrayList<>();
        try {
            dongInfo = dao.getDongInfo();
        } catch (Exception e) {
            log.error(e.toString());
        }
        return dongInfo;
    }

    public List<String> getDongSubInfo() {
        List<String> dongSubInfo = new ArrayList<>();
        try {
            dongSubInfo = dao.getDongSubInfo();
        } catch (Exception e) {
            log.error(e.toString());
        }
        return dongSubInfo;
    }

    public int getLampCount(Criteria cri) {
        int count = 0;

        setKeyword(cri);

        try {
            count = dao.getLampCount(cri);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return count;
    }

    public SecurityLightVO getLampInfo(String pole_num) {
        SecurityLightVO lamp = new SecurityLightVO();
        try {
            lamp = dao.getLampInfo(pole_num);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return lamp;
    }

    public void setKeyword(Criteria cri) {
        if(!cri.getCategory().equals("all")) {
            if(cri.getCategory().equals("dong"))    cri.setKeyword(cri.getGetKey()[0]);
            if(cri.getCategory().equals("dongSub")) cri.setKeyword(cri.getGetKey()[1]);
            if(cri.getCategory().equals("poleNum")) cri.setKeyword(cri.getGetKey()[2]);
        }
    }
}
