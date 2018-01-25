package com.taotao.service;

import com.taotao.common.pojo.EasyUiDataGraidResult;

public interface ItemService {
    /**
     * 分页查询列表
     */
    public EasyUiDataGraidResult getItemList(Integer page,Integer rows);
}
