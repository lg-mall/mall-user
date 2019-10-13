package com.practice.mall.user.request;

import lombok.Data;

@Data
public class MerchantRegisterIDTO {
    private Long id;

    private String merchantName;

    private String password;

    private String phoneNum;

}
