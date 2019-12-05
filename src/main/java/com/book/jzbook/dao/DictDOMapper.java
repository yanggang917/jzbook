package com.book.jzbook.dao;

import com.book.jzbook.bean.entity.DictDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/26 09:16
 * @Description:
 */
@Mapper
public interface DictDOMapper {

    List<DictDO> selectList();

    @Update("update dict set update_time = now() where id = #{dictId}")
    void updateTime(int dictId);
}
