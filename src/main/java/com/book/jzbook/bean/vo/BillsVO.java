package com.book.jzbook.bean.vo;

import com.book.jzbook.bean.entity.BillsDO;
import lombok.Data;

/**
 * @Auther: yg
 * @Date: 2019/11/23 14:45
 * @Description:
 */
public class BillsVO extends BillsDO {

    private String dictName;
    private String addTimeStr;
    private String icon;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getAddTimeStr() {
        return addTimeStr;
    }

    public void setAddTimeStr(String addTimeStr) {
        this.addTimeStr = addTimeStr;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
