package com.practice.mall.user.request;

import lombok.Data;

@Data
public class MerchantQueryRequest {
    private Long id;

    private String merchantName;

    private String phoneNum;

}
