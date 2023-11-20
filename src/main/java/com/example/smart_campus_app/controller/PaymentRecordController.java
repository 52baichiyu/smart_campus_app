package com.example.smart_campus_app.controller;

import com.example.smart_campus_app.bean.PaymentRecord;
import com.example.smart_campus_app.service.PaymentRecordService;
import com.example.smart_campus_app.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PaymentRecordController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/11/15 12:09
 * @Version 1.0
 **/
@RestController
@Api(tags = "支付记录相关接口")
@RequestMapping("paymentRecord")
public class PaymentRecordController extends BaseController{


    @Autowired
    private PaymentRecordService paymentRecordService;

    @GetMapping("/selectAll")
    @ApiOperation("通过房间号查询宿舍消费记录")
    JsonResult selecetAll(@RequestParam("homeNumber") String homeNumber){

        List<PaymentRecord> result = paymentRecordService.seleceAll(homeNumber);
        return JsonResult.sucess(result);
    }


    //校园卡消费记录查询
    @GetMapping("/seleceByCardNumber")
    @ApiOperation("通过校园卡号查询消费记录")
    JsonResult seleceByCardNumber(@RequestParam("cardNumber") String cardNumber){
        List<PaymentRecord> result = paymentRecordService.seleceByCardNumber(cardNumber);
        return JsonResult.sucess(result);
    }



}
