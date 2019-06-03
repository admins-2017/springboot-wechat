package com.kang.sys.service.impl;

import com.kang.sys.entity.User;
import com.kang.sys.mapper.UserInfoMapper;
import com.kang.sys.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, User> implements IUserInfoService {

}
