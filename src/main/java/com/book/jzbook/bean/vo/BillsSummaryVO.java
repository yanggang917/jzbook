package com.book.jzbook.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: yg
 * @Date: 2019/12/2 10:23
 * @Description:
 */
public class BillsSummaryVO {
    private BigDecimal y;
    private String name;

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
