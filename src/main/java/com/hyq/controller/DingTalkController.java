package com.hyq.controller;

import com.hyq.common.Result;
import com.hyq.pojo.TextMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/ding/talk")
public class DingTalkController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${ding-talk-url}")
    private String dingTalkUrl;

    @RequestMapping("/text")
    public Result sendMsgText(@Valid @RequestBody TextMsg textMsg){
        try {
            Assert.notNull(dingTalkUrl,"钉钉请求地址未配置！");
            ResponseEntity<Map> result = restTemplate.postForEntity(dingTalkUrl, textMsg, Map.class);
            Map body = result.getBody();
            return Result.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }

    }
}
