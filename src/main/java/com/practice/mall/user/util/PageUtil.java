package com.practice.mall.user.util;

import com.practice.mall.user.ao.PageAO;
import com.practice.mall.user.constants.MallUserConstant;
import com.practice.mall.user.request.PageRequest;

public class PageUtil {
    private PageUtil() {
    }

    public static PageAO convertToPageRqsAO(PageRequest pageRequest) {
        PageAO pageAO = new PageAO();
        int currentPage = pageRequest.getCurrentPage();
        int pageSize = pageRequest.getPageSize();

        pageSize = pageSize > 0 ? pageSize : MallUserConstant.DEFAULT_PAGE_SIZE;

        int startRow = currentPage < 2 ? 1 : (currentPage - 1) * pageSize + 1;
        pageAO.setStartRow(startRow);
        pageAO.setSize(pageSize);
        return pageAO;

    }
}
