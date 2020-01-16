/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.alarm;

import com.navercorp.pinpoint.web.alarm.checker.AlarmChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 发送告警到钉钉和微信群的告警发送类
 * 有任何问题，欢迎关注公众号【侠梦的开发笔记】交流
 */
public class DingTalkAndWechatMessageSender implements AlarmMessageSender {
    private final Logger logger = LoggerFactory.getLogger(DingTalkAndWechatMessageSender.class);

    @Autowired
    private RestTemplate restTemplate;
    private String dingTalkUrl;

    private static String DING_ALARM_PREFIX= "【告警】";
    public DingTalkAndWechatMessageSender(){
        logger.info("init DingTalkAndWechatMessageSender,{}",dingTalkUrl);
    }
    @Override
    public void sendSms(AlarmChecker checker, int sequenceCount) {

        if(StringUtils.isEmpty(dingTalkUrl)){
            logger.warn("web.ding.talk.url is not set！");
            return;
        }
        List smsMessage = checker.getSmsMessage();
        String textMsg = String.join("\r\n", smsMessage);
        send(textMsg);
    }
    @Override
    public void sendEmail(AlarmChecker checker, int sequenceCount) {
        String emailMessage = checker.getEmailMessage();
        if(StringUtils.isEmpty(dingTalkUrl)){
            logger.warn("web.ding.talk.url is not set！");
            return;
        }
        send(emailMessage);
    }
    public void send(String textMsg){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map map = dingMap(textMsg);

        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(map, headers);
        ResponseEntity<DingResponse> responseEntity = restTemplate.postForEntity(dingTalkUrl, request, DingResponse.class);
        DingResponse dingResponse = Optional.ofNullable(responseEntity).map(ResponseEntity::getBody).orElse(null);
        logger.info("send alarm msg: {},dingtalk result: {} ",map,dingResponse);
    }


    public static Map dingMap(String message){
        Map textMap = new HashMap();
        textMap.put("content",DING_ALARM_PREFIX + message);

        Map result = new HashMap();
        result.put("msgtype","text");
        result.put("text",textMap);
        return result;
    }

    public String getDingTalkUrl() {
        return dingTalkUrl;
    }
    public void setDingTalkUrl(String dingTalkUrl) {
        this.dingTalkUrl = dingTalkUrl;
        logger.info("init dingtalk url: ,{}",dingTalkUrl);
    }

    static class DingResponse{
        private int errcode;
        private String errmsg;

        public int getErrcode() {
            return errcode;
        }
        public void setErrcode(int errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }
        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        @Override
        public String toString() {
            return "DingResponse{" +
                    "errcode=" + errcode +
                    ", errmsg='" + errmsg + '\'' +
                    '}';
        }
    }
}
