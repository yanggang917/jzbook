package com.book.jzbook.bean.entity;

import com.book.jzbook.utils.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yg
 * @Date: 2019/11/22 15:49
 * @Description:
 */
public class BillsDO {
    private int id;
    private BigDecimal money;
    private int dictId;

//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd")
    @JsonFormat(timezone = "GMT+8", pattern = "HH:mm:ss")
    private Date addTime;
    private String remark;
    private int delFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getDictId() {
        return dictId;
    }

    public void setDictId(int dictId) {
        this.dictId = dictId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
