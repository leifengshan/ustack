package com.stack.bpm.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: FlowTest
 *
 * @author Ferris
 * @date 2021/11/10 16:50
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlowTest {

    /**
     * 部署
     * key Process_1636533663589
     */
    @Test
    public void deploy() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("abc.bpmn")
                .deploy();

        System.out.println("deploymentId:"+deployment.getId()+",deploymentName:"+deployment.getName());
    }


    /**
     * 启动
     * key Process_1636533663589
     */
    @Test
    public void startProcess() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        Map<String, Object> variables = new HashMap<>();
        variables.put("r", Integer.valueOf(1));

        ProcessInstance pi = processEngine.getRuntimeService()
                .startProcessInstanceByKey("Process_1636533663589", variables);
        System.out.println("pi:"+ pi.getId());
    }

    /**
     * 查询任务
     */
    @Test
    public void queryTask() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .processDefinitionKey("Process_1636533663589")
                .list();

        for (Task task : tasks) {
            System.out.println("tkey:"+ task.getTaskDefinitionKey()+",assignee:"+task.getAssignee());

            processEngine.getTaskService()
                    .setAssignee(task.getId(), "张三");
        }
    }


    /**
     * 查询任务
     */
    @Test
    public void queryTask0() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("张三")
                .list();

        for (Task task : tasks) {
            System.out.println("tkey:"+ task.getTaskDefinitionKey()+",assignee:"+task.getAssignee());
        }
    }

    /**
     * 完成任务
     */
    @Test
    public void completeTask() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("张三")
                .list();

        for (Task task : tasks) {
            System.out.println("tkey:"+ task.getTaskDefinitionKey()+",assignee:"+task.getAssignee());

            Map<String, Object> variables = new HashMap<>();
            variables.put("r", Integer.valueOf(0));

            processEngine.getTaskService().complete(task.getId(), variables);
        }
    }

}
