package com.stack.bpm;

import com.ustack.fw.task.EnableFerrisTask;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: FlowApplication
 *
 * @author Ferris
 * @date 2021/11/9 17:14
 * @Version 1.0
 */
@EnableFerrisTask
@SpringBootApplication
@EnableProcessApplication
public class FlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowApplication.class, args);
        System.out.println("FlowApplication start");
    }
}
