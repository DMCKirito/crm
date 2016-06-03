package com.kirito.dsy.crm.service.impl;

import com.kirito.dsy.crm.dal.ITestDAO;
import com.kirito.dsy.crm.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kirito on 16/5/30.
 */
@Service
public class TestServiceImpl implements ITestService {
    Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    ITestDAO testDAO;

    @Override
    public int insertName(int name) {
        logger.info("enter TestServiceImpl with param {}", name);

        return testDAO.selectByName(name);
    }
}
