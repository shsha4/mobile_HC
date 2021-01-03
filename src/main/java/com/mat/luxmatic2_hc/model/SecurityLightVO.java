package com.mat.luxmatic2_hc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter @Setter
public class SecurityLightVO {
    private int dong_id;
    private int dong_sub_id;
    private int management_num;
    private double latitude;
    private double longitude;
    private String install_street_address;
    private String telegraph_pole_num;
    private String pole_type;
    private int wattage;
    private String search_date;
    private String kepco_num;
    private String thumbnail_photo2;
    private String thumbnail_photo3;
    private String thumbnail_photo4;

    private String dongInfo;
    private String dongSubInfo;
}
