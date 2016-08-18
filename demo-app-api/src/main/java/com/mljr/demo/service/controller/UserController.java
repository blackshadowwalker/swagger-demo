package com.mljr.demo.service.controller;

import com.mljr.demo.bean.ResponseDto;
import com.mljr.demo.bean.User;
import com.mljr.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ASUS on 2016/8/18.
 */
@Api(tags = "用户")
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation("查询用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto<List<User>> query(HttpServletRequest request) throws Exception {
        List<User> list = userService.query();
        return ResponseDto.rsOK(list);
    }

    @ApiOperation(value = "查询用户详情", notes = "e.g: GET /user/2 ")
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto<User> userDetail(
            @ApiParam(value = "用户id", required = true) @PathVariable(value = "userId") Long userId
    ) throws Exception {
        User item = userService.get(userId);
        return ResponseDto.rsOK(item);
    }

    @ApiOperation(value = "新增用户", notes = "这个是使用form表单提交数据，直接使用 User 对象接受参数 ")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto<User> insertUser(@ModelAttribute User user, HttpServletRequest request) throws Exception {
        User item = userService.add(user.getName(), user.getPassword());
        return ResponseDto.rsOK(item);
    }

    @ApiOperation(value = "新增用户", notes = "这个是使用 json 格式提交数据，直接使用 User 对象接受参数(需要使用注解 @RequestBody)")
    @RequestMapping(value = "json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDto<User> insertUserWithJson(@RequestBody User user) throws Exception {
        User item = userService.add(user.getName(), user.getPassword());
        return ResponseDto.rsOK(item);
    }

    @ApiOperation("修改用户密码")
    @RequestMapping(value = "password", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDto<User> updateUser(
            @ApiParam(value = "用户id", required = true) @RequestParam(value = "userId", required = true) Long userId,
            @ApiParam(value = "密码", required = true) @RequestParam(value = "password", required = true) String password
    ) throws Exception {
        User item = userService.update(userId, password);
        return ResponseDto.rsOK(item);
    }

    @ApiOperation("上传头像")
    @RequestMapping(value = "avator", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    @ResponseBody
    public ResponseDto<User> uploadAvator(
            @ApiParam(value = "用户id", required = true) @RequestParam(value = "userId", required = true) Long userId,
            @ApiParam("头像") @RequestPart("file") MultipartFile file
    ) throws Exception {
        log.info("用户{} 上传头像 {}", userId, file.getOriginalFilename());
        User item = userService.get(userId);
        //TODO 保存头像数据，生成URL
        item.setAvator("/images/avator/" + file.getOriginalFilename());
        return ResponseDto.rsOK(item);
    }

}
