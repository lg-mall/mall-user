package com.practice.mall.user.controller;

import com.practice.mall.user.response.Response;
import com.practice.mall.user.request.MerchantQueryIDTO;
import com.practice.mall.user.request.MerchantRegisterIDTO;
import com.practice.mall.user.request.PageIDTO;
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
    Response save(MerchantRegisterIDTO merchantRegisterIDTO) {
        return merchantService.register(merchantRegisterIDTO);
    }

    @GetMapping("/list")
    Response<PageODTO<MerchantODTO>> listByPaging(PageIDTO<MerchantQueryIDTO> pageIDTO) {

        return merchantService.listByPaging(pageIDTO);
    }


}
