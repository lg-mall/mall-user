package com.practice.mall.user.controller;

import com.practice.mall.user.response.Response;
import com.practice.mall.user.request.idto.MerchantQueryPageIDTO;
import com.practice.mall.user.request.MerchantRegisterRequest;
import com.practice.mall.user.request.PageRequest;
import com.practice.mall.user.response.odto.MerchantPageODTO;
import com.practice.mall.user.response.PageStructure;
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
    Response<PageStructure<MerchantPageODTO>> listByPaging(PageRequest<MerchantQueryPageIDTO> pageRequest) {

        return merchantService.listByPaging(pageRequest);
    }


}
