package com.practice.mall.user.response.odto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantPageODTO implements Serializable {
    private Long id;

    private String merchantName;

    private String phoneNum;

}
