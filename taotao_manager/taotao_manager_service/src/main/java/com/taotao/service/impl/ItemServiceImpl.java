package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.service.ItemService;
import com.taotao.common.pojo.EasyUiDataGraidResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUiDataGraidResult getItemList(Integer page, Integer rows) {
        //分页查询用pageHelper  要在dao层中引入依赖
        //1.分页查询
        PageHelper.startPage(page,rows);//仅跟着第一个查询才会被分页
        //查询所有
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);
        //构建分页的对象,里面包括了总记录数
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        long total = info.getTotal();
        //创建EasyUiDataGraidResult对象 用来封装属性(total,rows)
        EasyUiDataGraidResult result = new EasyUiDataGraidResult();
        result.setTotal(total);
        result.setRows(info.getList());
        return result;
    }
}
