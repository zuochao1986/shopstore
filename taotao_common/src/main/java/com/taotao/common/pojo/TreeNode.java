package com.taotao.common.pojo;

import java.io.Serializable;

/**
 * 创建树节点的pojo
 */
//因为service同web都要用,是用来系统之间的传递,所有需要序列化
public class TreeNode implements Serializable{
    private Long id;//书控件的节点的id值
    private String text;//显示节点文本,也就是文件夹的名字
    private String state;//状态:表示树节点的状态  close关闭 open打开

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
