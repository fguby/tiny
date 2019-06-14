package com.mall.tiny.controller;

import com.mall.tiny.common.CommonPage;
import com.mall.tiny.common.JSONResult;
import com.mall.tiny.mbg.model.User;
import com.mall.tiny.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  user管理 Controller
 *
 */
@Api(tags = "UserController", description = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("获取所有用户列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<List<User>> getUserList() {
        return JSONResult.success(userService.listAllUser());
    }

    @ApiOperation("添加用户")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult createUser(@RequestBody User user) {
        JSONResult jsonResult;
        int count = userService.createUser(user);
        if (count == 1) {
            jsonResult = JSONResult.success(user);
            logger.debug("create user success:{}", user);
        } else {
            jsonResult = JSONResult.failed("操作失败");
            logger.debug("create user failed:{}", user);
        }
        return jsonResult;
    }

    @ApiOperation("获取指定id的用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<User> getUser(@PathVariable("id") int id) {
        return JSONResult.success(userService.getUser(id));
    }

    @ApiOperation("删除指定id的用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONResult deleteUser(@PathVariable("id") int id) {
        int count = userService.deleteUser(id);
        if (count == 1) {
            logger.debug("delete user success: id = {}", id);
            return JSONResult.success(null);
        } else {
            logger.debug("delete user failed: id = {}", id);
            return  JSONResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询用户")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<CommonPage<User>> listUser(@RequestParam(value = "pageNum", defaultValue = "1")
                                                 @ApiParam("页码") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "3")
                                                 @ApiParam("每页数量") Integer pageSize
                                                 ) {
        List<User> userList = userService.listUser(pageNum, pageSize);
        return JSONResult.success(CommonPage.restPage(userList));
    }
}
