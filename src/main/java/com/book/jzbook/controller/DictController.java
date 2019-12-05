package com.book.jzbook.controller;

import com.book.jzbook.bean.entity.DictDO;
import com.book.jzbook.service.DictService;
import com.book.jzbook.utils.ResJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yg
 * @Date: 2019/11/26 09:13
 * @Description:
 */
@Controller
@RequestMapping(value = "/dict")
public class DictController {
    @Resource
    private DictService dictService;

    @RequestMapping(value = "/selectList", method = {RequestMethod.POST})
    @ResponseBody
    public ResJson selectList() {
        List<DictDO> dictDOList = this.dictService.selectList();
        return ResJson.success(dictDOList);
    }
}
