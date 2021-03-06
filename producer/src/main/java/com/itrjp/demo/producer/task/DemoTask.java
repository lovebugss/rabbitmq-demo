package com.itrjp.demo.producer.task;

import com.itrjp.demo.producer.service.DemoService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : renjp
 * @date : 2021-03-06 21:22
 **/
@Service
@EnableScheduling
public class DemoTask {

    public final DemoService demoService;

    public DemoTask(DemoService demoService) {
        this.demoService = demoService;
    }

    @Scheduled(cron = "0/2 * * * * *")
    public void demo() {
        LocalDateTime now = LocalDateTime.now();
        demoService.sendMsg(now.toString());
    }
}
