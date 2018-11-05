package com.david.ssm.service.impl;

import com.david.ssm.entity.User;
import com.david.ssm.mapper.UserMapper;
import com.david.ssm.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
