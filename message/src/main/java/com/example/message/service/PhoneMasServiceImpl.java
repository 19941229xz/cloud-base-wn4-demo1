package com.example.message.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PhoneMasServiceImpl implements PhoneMsqService {


    @Autowired
    RedisServiceImpl redisService;

    @Override
    public String sendPhoneMsg(String phoneNum,String code) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FyrvZQtmnQriUF3x8ui",
                "WnN61YbCd9sn7b5GK0beQu7a79meZJ");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "源码课堂");
        request.putQueryParameter("TemplateCode", "SMS_191768213");

//        String randomeCode = (new Random().nextInt(89999)+10000)+"";
        // 将手机验证码存放到redis中  手机作为 key 验证码作为 value
        // 过期时间设置为三分钟
        redisService.set(phoneNum,code,(long)3*60*1000);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);

            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }



        return "发送成功";
    }
}
