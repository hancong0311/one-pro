package com.usian.task;

import com.usian.service.OrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Title: OrderTask4Quartz
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/10/28 14:32
 *
 *   任务对象
 *   触发器对象
 *   调度中心
 *
 */
public class OrderTask4Quartz implements Job {

    @Autowired
    private OrderService orderService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("取消订单了！"+new Date());
        orderService.cancleOrder();
    }
}
