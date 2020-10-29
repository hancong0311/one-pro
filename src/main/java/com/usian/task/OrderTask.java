package com.usian.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title: OrderTask
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/10/28 14:03
 */
//@Component
public class OrderTask {

    /**
     * 没一秒触发一次
     * @Scheduled 生效的前提是，开启了Scheduled功能
     */
    @Scheduled(cron = "1 * * * * ?")
    public void cancleOrder(){
        System.out.println("取消订单了！"+new Date());
    }

}
