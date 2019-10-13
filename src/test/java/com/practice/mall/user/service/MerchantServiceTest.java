package com.practice.mall.user.service;

import com.practice.mall.user.MallUserApplicationTests;
import com.practice.mall.user.enums.ResultCodeEnum;
import com.practice.mall.user.response.Response;
import com.practice.mall.user.request.MerchantRegisterIDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MerchantServiceTest extends MallUserApplicationTests {

    @Autowired
    private MerchantService merchantService;

    @Test
    public void registerNormal() {
        MerchantRegisterIDTO dto = new MerchantRegisterIDTO();

        dto.setMerchantName("test-" + RandomStringUtils.randomAlphabetic(5));
        dto.setPhoneNum(RandomUtils.nextInt(10000, 100000) + "");

        Response response = merchantService.register(dto);
        Assertions.assertThat(response.getCode()).isEqualTo(ResultCodeEnum.GLOBAL_SUCCESS.getCode());

    }
    @Test
    public void registerAbnormal() {
        MerchantRegisterIDTO dto = new MerchantRegisterIDTO();

        dto.setMerchantName("test-john");
        dto.setPhoneNum("110");

        Response response = merchantService.register(dto);
        Assertions.assertThat(response.getCode()).isEqualTo(ResultCodeEnum.REGISTER_MERCHANT_NAME_EXISTENCE.getCode());

    }

    @Test
    public void listByPaging() {
    }
}