package com.book.jzbook.service.impl;

import com.book.jzbook.bean.entity.DictDO;
import com.book.jzbook.dao.DictDOMapper;
import com.book.jzbook.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/26 09:15
 * @Description:
 */
@Service
public class DictServiceImpl implements DictService {
    @Resource
    private DictDOMapper dictDOMapper;


    @Override
    public List<DictDO> selectList() {
        return this.dictDOMapper.selectList();
    }
}
