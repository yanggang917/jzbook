package com.book.jzbook.service;

import com.book.jzbook.bean.entity.DictDO;

import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/26 09:15
 * @Description:
 */
public interface DictService {
    List<DictDO> selectList();
}
