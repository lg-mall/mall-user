package com.practice.mall.user.service;

import com.practice.mall.user.request.*;
import com.practice.mall.user.request.idto.MerchantQueryPageIDTO;
import com.practice.mall.user.response.Response;
import com.practice.mall.user.response.odto.MerchantPageODTO;
import com.practice.mall.user.response.PageResponse;

public interface MerchantService {

    Response register(MerchantRegisterRequest merchantRegisterRequest);

    Response<PageResponse<MerchantPageODTO>> listByPaging(PageRequest<MerchantQueryPageIDTO> pageRequest);


}
