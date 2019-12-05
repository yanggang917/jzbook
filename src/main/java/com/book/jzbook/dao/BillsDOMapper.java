package com.book.jzbook.dao;

import com.book.jzbook.bean.entity.BillsDO;
import com.book.jzbook.bean.vo.BillsSummaryVO;
import com.book.jzbook.bean.vo.BillsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/22 15:45
 * @Description:
 */
@Mapper
public interface BillsDOMapper {

    void insert(BillsDO billsDO);

    List<BillsVO> selectList();

    @Update("update bills set del_flag=1 where id = #{billsId}")
    void delete(int billsId);

    @Select("SELECT b.`name`, SUM(a.money) y FROM bills a LEFT JOIN dict b ON a.dict_id = b.id GROUP BY a.dict_id, b.`name`")
    List<BillsSummaryVO> summary();
}
