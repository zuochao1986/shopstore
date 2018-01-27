package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
import com.taotao.common.pojo.EasyUiDataGraidResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;
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

    @Override
    public TaotaoResult saveItem(TbItem tbItem, String desc) {
        //注入mapper
        //2.生成产品的唯一id
        long itemId = IDUtils.genItemId();
        //3.补全商品所有的
        tbItem.setId(itemId);
        tbItem.setStatus((byte)1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(tbItem.getCreated());
        //4.插入商品的基本信息表
        tbItemMapper.insertSelective(tbItem);
        //5.构建商品的描述
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(tbItem.getCreated());
        itemDesc.setUpdated(tbItem.getCreated());
        tbItemDescMapper.insertSelective(itemDesc);
        return  TaotaoResult.ok();

    }
}
