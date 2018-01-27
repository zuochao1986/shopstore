package com.taotao.service;

import com.taotao.common.pojo.EasyUiDataGraidResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    /**
     * 分页查询列表
     */
    public EasyUiDataGraidResult getItemList(Integer page,Integer rows);

    public TaotaoResult saveItem(TbItem tbItem,String desc);
}
