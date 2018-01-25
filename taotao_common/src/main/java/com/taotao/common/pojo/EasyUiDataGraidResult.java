package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;
//一定要实现序列化,网络才能通过流来传输
public class EasyUiDataGraidResult implements Serializable {
    private Long total;//总记录数
    private List rows;//对象的集合,可以使商品列表

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
