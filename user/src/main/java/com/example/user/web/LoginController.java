package com.example.user.web;

import com.example.user.feign.MessageFeignClient;
import com.example.user.model.LoginParam;
import com.example.user.service.RedisServiceImpl;
import com.example.user.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class LoginController {

    @Autowired
    MessageFeignClient messageFeignClient;

    @Autowired
    RedisServiceImpl redisService;

    @PostMapping("login")
    public String login(@RequestBody LoginParam loginParam){

        //取出用户的手机号
        String userPhoneNum = loginParam.getPhone();
        //拿着手机号 去redis中查询 刚才发送的验证码
        String codeFromReids = (String)redisService.get(userPhoneNum);
        //取出用户 前端表单中输入的验证码
        String userCode = loginParam.getPhoneCode();
        //然后比对 用户输入的验证码和 redis中取出来的验证码
        if(userCode.equals(codeFromReids)){
            redisService.remove(userPhoneNum);
            return "登录成功";
        }else{
            return "登录失败";
        }
        //如果一致  就返回登录成功（删除redis中的验证码 防止验证码被重复使用）  否则失败

    }

    @PostMapping("sendPhongCode")
    public String sendPhongCode(@RequestBody LoginParam loginParam){

        //生成验证码
        String randomeCode = (new Random().nextInt(89999)+10000)+"";

        //将手机号作为ikey  验证码作为 value
        DataUtil.phoneCodeMap.put(loginParam.getPhone(),randomeCode);

        return messageFeignClient.sendPhoneMsg(loginParam.getPhone(),
                randomeCode);
    }


}
