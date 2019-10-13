package com.practice.mall.user.service.impl;

import com.practice.mall.user.ao.PageAO;
import com.practice.mall.user.config.UserTransactional;
import com.practice.mall.user.enums.ResultCodeEnum;
import com.practice.mall.user.entity.Merchant;
import com.practice.mall.user.exception.ResultAssertException;
import com.practice.mall.user.repository.MerchantMapper;
import com.practice.mall.user.request.*;
import com.practice.mall.user.response.Response;
import com.practice.mall.user.response.MerchantODTO;
import com.practice.mall.user.response.PageODTO;
import com.practice.mall.user.service.MerchantService;
import com.practice.mall.user.util.PageUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantMapper merchantMapper;

    public MerchantServiceImpl(MerchantMapper merchantMapper) {
        this.merchantMapper = merchantMapper;
    }


    @UserTransactional
    @Override
    public Response register(MerchantRegisterRequest merchantRegisterRequest) {
        Merchant merchant = new Merchant();
        String merchantName = merchantRegisterRequest.getMerchantName();
        Merchant record=new Merchant();
        record.setMerchantName(merchantName);
        long existence = merchantMapper.selectMerchantExistence(record);
        if (existence > 0) {
            throw new ResultAssertException(ResultCodeEnum.REGISTER_MERCHANT_NAME_EXISTENCE.getCode(), "the merchant name '" + merchantName + "' already exists");
        }
        merchant.setMerchantName(merchantName);
        merchant.setPhoneNum(merchantRegisterRequest.getPhoneNum());

        int changed = merchantMapper.insert(merchant);
        if (changed < 1) {
            throw new ResultAssertException(ResultCodeEnum.GLOBAL_FAIL_UNKNOWN.getCode(), "should be inserted successful");
        }
        return new Response();
    }

    @Override
    public Response<PageODTO<MerchantODTO>> listByPaging(PageRequest<MerchantQueryRequest> pageRequest) {
        PageAO pageAO = PageUtil.convertToPageRqsAO(pageRequest);
        MerchantQueryRequest searchCondition = pageRequest.getSearchCondition();
        List<Merchant> merchants = merchantMapper.selectFuzzyByPage(pageAO, searchCondition);
        long count = merchantMapper.selectFuzzyCount(searchCondition);
        PageODTO<MerchantODTO> rspDTO = new PageODTO<>();
        rspDTO.setCount(count);

        List<MerchantODTO> collect = merchants.stream().map(merchant -> {
            MerchantODTO dto = new MerchantODTO();
            dto.setId(merchant.getId());
            dto.setMerchantName(merchant.getMerchantName());
            dto.setPhoneNum(merchant.getPhoneNum());
            return dto;
        }).collect(Collectors.toList());

        rspDTO.setItemList(collect);

        return new Response<>(rspDTO);
    }


}
