package com.mat.luxmatic2_hc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;

@NoArgsConstructor
@Getter @Setter @ToString
public class PageMaker {

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 5;

    private Criteria cri;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {
        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) + 1;
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

        if(endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        prev = startPage == 1 ? false : true;
        next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
    }

    public String makeSearch(int page){

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("category", cri.getCategory())
                .queryParam("keyword", encoding(((Criteria) cri).getKeyword()))
                .queryParam("getKey", cri.getGetKey())
                .build();
        return uriComponents.toUriString();
    }

    private String encoding(String keyword){
        if(keyword == null || keyword.trim().length() == 0)
            return "";

        try {
            return URLEncoder.encode(keyword, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
