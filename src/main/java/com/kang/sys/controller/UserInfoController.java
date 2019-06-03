package com.kang.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kang.sys.entity.User;
import com.kang.sys.mapper.RoleMapper;
import com.kang.sys.service.IUserInfoService;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@RestController
@RequestMapping("/user")
@Api()
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;
    @Resource
    private RoleMapper roleMapper;



}
