package com.stack.bpm.module.flow.service;

import com.stack.bpm.module.flow.dao.FlowDeployMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: FlowDeployService
 *
 * @author Ferris
 * @date 2021/11/12 16:59
 * @Version 1.0
 */
@Service
public class FlowDeployService {

    @Resource
    private FlowDeployMapper flowDeployMapper;

}
