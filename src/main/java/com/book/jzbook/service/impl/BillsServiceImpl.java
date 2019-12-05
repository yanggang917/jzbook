package com.book.jzbook.service.impl;

import com.book.jzbook.bean.entity.BillsDO;
import com.book.jzbook.bean.vo.BillsSummaryVO;
import com.book.jzbook.bean.vo.BillsVO;
import com.book.jzbook.dao.BillsDOMapper;
import com.book.jzbook.dao.DictDOMapper;
import com.book.jzbook.service.BillsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/22 15:43
 * @Description:
 */
@Service
public class BillsServiceImpl implements BillsService {
    @Resource
    private BillsDOMapper billsDOMapper;

    @Resource
    private DictDOMapper dictDOMapper;

    @Override
    public void save(BillsDO billsDO) {
        billsDO.setAddTime(new Date());
        this.billsDOMapper.insert(billsDO);
        this.dictDOMapper.updateTime(billsDO.getDictId());
    }

    @Override
    public List<BillsVO> selectList() {
        List<BillsVO> billsVOList = this.billsDOMapper.selectList();
        return billsVOList;
    }

    @Override
    public void delete(int billsId) {
        this.billsDOMapper.delete(billsId);
    }

    @Override
    public List<BillsSummaryVO> summary() {
        return this.billsDOMapper.summary();
    }
}
