package com.book.jzbook.controller;

import com.book.jzbook.bean.entity.BillsDO;
import com.book.jzbook.bean.vo.BillsSummaryVO;
import com.book.jzbook.bean.vo.BillsVO;
import com.book.jzbook.service.BillsService;
import com.book.jzbook.utils.MapSortUtils;
import com.book.jzbook.utils.ResJson;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: yg
 * @Date: 2019/11/22 14:44
 * @Description:
 */
@Controller
@RequestMapping(value = "/bills")
public class BillsController {

    @Resource
    BillsService billsService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public ResJson save(@RequestBody BillsDO billsDO) {
        this.billsService.save(billsDO);
        return ResJson.success();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResJson delete(@RequestParam int billsId) {
        this.billsService.delete(billsId);
        return ResJson.success();
    }


    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ResJson query() {
        List<BillsVO> ss = this.billsService.selectList();
        Map<String, List<BillsVO>> res = ss.stream().peek(e->{
            String addTime = getFormatDateStr(e.getAddTime());
            /*String today = getFormatDateStr(new Date());
            Calendar calendar= Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,-24);
            String yesterday = getFormatDateStr(calendar.getTime());
            if (today.equals(addTime)){
                e.setAddTimeStr("今天");
            }else if (yesterday.equals(addTime)){
                e.setAddTimeStr("昨天");
            }else {
                e.setAddTimeStr(addTime);
            }*/
            e.setAddTimeStr(addTime);
        }).collect(Collectors.groupingBy(BillsVO::getAddTimeStr));

        Map result = MapSortUtils.sortByKey(res, true);
        return ResJson.success(result);
    }

    private String getFormatDateStr(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 E", Locale.CHINA);
        String str=sdf.format(date);
        return str;
    }


    @RequestMapping(value = "/summary")
    @ResponseBody
    public ResJson summary() {
        List<BillsSummaryVO> billsSummaryVOList = this.billsService.summary();
        BigDecimal totalMoney = new BigDecimal("0.00");
        for (BillsSummaryVO billsSummaryVO:billsSummaryVOList){
            totalMoney = totalMoney.add(billsSummaryVO.getY());
        }

        Map res = Maps.newHashMap();
        res.put("list", billsSummaryVOList);
        res.put("totalMoney", totalMoney);
        return ResJson.success(res);
    }
}
