package com.book.jzbook.bean.vo;

import com.book.jzbook.bean.entity.BillsDO;
import lombok.Data;

/**
 * @Auther: yg
 * @Date: 2019/11/23 14:45
 * @Description:
 */
@Data
public class BillsVO extends BillsDO {

    private String dictName;
    private String addTimeStr;
    private String icon;
}
