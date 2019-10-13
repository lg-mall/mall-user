package com.practice.mall.user.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantODTO implements Serializable {
    private Long id;

    private String merchantName;

    private String phoneNum;

}
