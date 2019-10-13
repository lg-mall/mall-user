package com.practice.mall.user.controller;

import com.practice.mall.user.response.Response;
import com.practice.mall.user.request.MerchantQueryRequest;
import com.practice.mall.user.request.MerchantRegisterRequest;
import com.practice.mall.user.request.PageRequest;
import com.practice.mall.user.response.MerchantODTO;
import com.practice.mall.user.response.PageODTO;
import com.practice.mall.user.service.MerchantService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/merchant")
@RestController
public class MerchantController {
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/register")
    Response save(MerchantRegisterRequest merchantRegisterRequest) {
        return merchantService.register(merchantRegisterRequest);
    }

    @GetMapping("/list")
    Response<PageODTO<MerchantODTO>> listByPaging(PageRequest<MerchantQueryRequest> pageRequest) {

        return merchantService.listByPaging(pageRequest);
    }


}
