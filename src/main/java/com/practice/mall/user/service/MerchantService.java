package com.practice.mall.user.service;

import com.practice.mall.user.request.*;
import com.practice.mall.user.response.Response;
import com.practice.mall.user.response.MerchantODTO;
import com.practice.mall.user.response.PageODTO;

public interface MerchantService {

    Response register(MerchantRegisterIDTO merchantRegisterIDTO);

    Response<PageODTO<MerchantODTO>> listByPaging(PageIDTO<MerchantQueryIDTO> pageIDTO);


}
