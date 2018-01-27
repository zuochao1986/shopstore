package com.taotao.controller;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatController {
    @Autowired//注入服务
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //1.引入服务springmvc.xml
        //2.注入服务
        //3.调用服务
        List<TreeNode> list = itemCatService.getItemCatListByParentId(parentId);
        return  list;
    }
}
