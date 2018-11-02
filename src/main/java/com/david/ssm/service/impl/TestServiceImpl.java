package com.david.ssm.service.impl;

import com.david.ssm.entity.Test;
import com.david.ssm.mapper.TestMapper;
import com.david.ssm.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author david
 * @since 2018-11-02
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
