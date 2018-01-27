package com.taotao.service.impl;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper mapper;

    @Override
    public List<TreeNode> getItemCatListByParentId(Long parentId) {
        //1.注入mapper
        //2.创建example对象封装查询的条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //3.执行查询获取List<tbitemcat>
        List<TbItemCat> itemCats = mapper.selectByExample(example);
        //4.转成List<TreeNode> 给返回
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (TbItemCat itemCat : itemCats) {
            TreeNode node = new TreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent()?"closed":"open");
            nodes.add(node);
        }
        return nodes;
    }
}
