package com.example.user.web;

import com.example.user.feign.MessageFeignClient;
import com.example.user.model.LoginParam;
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

    @PostMapping("login")
    public String login(@RequestBody LoginParam loginParam){

        //从data util中获取正确的验证码
        String rightCode = DataUtil.phoneCodeMap
                .get(loginParam.getPhone());

        if(rightCode.equals(loginParam.getPhoneCode())){
            return "登录成功";
        }else{
            return "登录失败";
        }



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
