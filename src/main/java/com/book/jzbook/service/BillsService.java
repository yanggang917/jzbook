package com.book.jzbook.service;

import com.book.jzbook.bean.entity.BillsDO;
import com.book.jzbook.bean.vo.BillsSummaryVO;
import com.book.jzbook.bean.vo.BillsVO;

import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/22 15:42
 * @Description:
 */
public interface BillsService {

    void save(BillsDO billsDO);

    List<BillsVO> selectList();

    void delete(int billsId);

    List<BillsSummaryVO> summary();
}
