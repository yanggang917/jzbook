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
@Data
public class BillsDO {
    private int id;
    private BigDecimal money;
    private int dictId;

//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd")
    @JsonFormat(timezone = "GMT+8", pattern = "HH:mm:ss")
    private Date addTime;
    private String remark;
    private int delFlag;
}
