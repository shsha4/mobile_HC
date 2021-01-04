package com.mat.luxmatic2_hc.controller;

import com.google.gson.Gson;
import com.mat.luxmatic2_hc.model.Criteria;
import com.mat.luxmatic2_hc.model.PageMaker;
import com.mat.luxmatic2_hc.model.SecurityLightVO;
import com.mat.luxmatic2_hc.service.HCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private HCService service;

    private Gson gson = new Gson();

    @GetMapping("mapList")
    public String listPage(Model model, @ModelAttribute("Criteria") Criteria cri) {

        if(cri.getCategory() == null) {
            cri = new Criteria();
            cri.setCategory("all");
        }

        List<SecurityLightVO> list = service.getAllList(cri);
        List<String> dongInfo = service.getDongInfo();
        List<String> dongSubInfo = service.getDongSubInfo();
        model.addAttribute("lampList", list);
        model.addAttribute("dongInfo", dongInfo);
        model.addAttribute("dongSubInfo", dongSubInfo);
        model.addAttribute("cri", cri);

        return "thymeleaf/mapList";
    }

    @GetMapping("tableList")
    public String tListPage(Model model, @ModelAttribute("Criteria") Criteria cri) {

        if(cri.getCategory() == null) {
            cri.setCategory("all");
        }

        PageMaker pm = new PageMaker();
        pm.setCri(cri);
        pm.setTotalCount(service.getLampCount(cri));
        List<SecurityLightVO> list = service.getTableList(cri);
        List<String> dongInfo = service.getDongInfo();
        List<String> dongSubInfo = service.getDongSubInfo();

        model.addAttribute("lampList", list);
        model.addAttribute("pm", pm);
        model.addAttribute("dongInfo", dongInfo);
        model.addAttribute("dongSubInfo", dongSubInfo);

        return "thymeleaf/tableList";
    }

    @GetMapping("detailLamp/{pole_num}")
    public String detailPage(@PathVariable String pole_num, Model model) {
        SecurityLightVO lamp = service.getLampInfo(pole_num);
        model.addAttribute("lamp", lamp);
        return "thymeleaf/detailLamp";
    }
}
