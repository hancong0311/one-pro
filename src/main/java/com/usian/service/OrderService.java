package com.usian.service;

import org.springframework.stereotype.Service;

/**
 * @Title: OrderService
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/10/28 14:55
 */
@Service
public class OrderService {

    public void cancleOrder(){
        System.out.println("service----订单状态未支付，改为已取消！！！！");
    }
}
