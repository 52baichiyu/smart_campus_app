package com.example.smart_campus_app.controller;

import com.example.smart_campus_app.bean.PaymentRecord;
import com.example.smart_campus_app.bean.RechargeRecord;
import com.example.smart_campus_app.service.RechargeRecordService;
import com.example.smart_campus_app.util.JsonResult;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RechargeRecordController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/11/15 12:09
 * @Version 1.0
 **/
@RestController
@Api(tags = "用户充值记录相关接口")
@RequestMapping("/rechargeRecord")
public class RechargeRecordController extends BaseController {

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @GetMapping("/selectAll")
    @ApiOperation("通过房间号查询宿舍电费充值记录")
    public JsonResult seleceAll(@RequestParam("homeNumber") String homeNumber){

        List<RechargeRecord> result = rechargeRecordService.selectAll(homeNumber);
        return JsonResult.sucess(result);
    };


    //校园卡充值记录查询
    @GetMapping("/seleceByCardNumber")
    @ApiOperation("通过校园卡号查询充值记录")
    JsonResult seleceByCardNumber(@RequestParam("cardNumber") String cardNumber){
        List<RechargeRecord> result = rechargeRecordService.seleceByCardNumber(cardNumber);
        return JsonResult.sucess(result);
    }



    //宿舍电费充值
    @GetMapping("/rechargeHome")
    @ApiOperation("通过宿舍号充值")
    JsonResult rechageHome(@RequestParam("homeNumber")String homeNumber,
                           @RequestParam("money")int money,
                           @RequestParam("cardNumber")String cardNumber){
        rechargeRecordService.rechargeHome(homeNumber,money,cardNumber);
        String result = "充值成功";
        return JsonResult.sucess(result);
    }



}
