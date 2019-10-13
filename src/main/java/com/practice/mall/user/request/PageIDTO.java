package com.practice.mall.user.request;

import lombok.Data;

@Data
public class PageIDTO<T> {
    private int currentPage;

    private int pageSize;

    private T searchCondition;

}
