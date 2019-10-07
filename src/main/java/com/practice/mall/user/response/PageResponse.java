package com.practice.mall.user.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResponse<T> implements Serializable {

    private long count;

    private List<T> itemList;

}
