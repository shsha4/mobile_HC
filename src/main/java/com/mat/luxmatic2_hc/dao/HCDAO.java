package com.mat.luxmatic2_hc.dao;

import com.mat.luxmatic2_hc.model.Criteria;
import com.mat.luxmatic2_hc.model.SecurityLightVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HCDAO {
    List<SecurityLightVO> getAllList(Criteria cri);
    List<String> getDongInfo();
    List<String> getDongSubInfo();
    List<SecurityLightVO> getTableList(Criteria cri);
    int getLampCount(Criteria cri);
    SecurityLightVO getLampInfo(String pole_num);
}
