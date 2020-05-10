package com.navercorp.pinpoint.web.alarm;

import com.navercorp.pinpoint.web.alarm.checker.AlarmChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
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
 * @version 1.0
 * @Author: huangyunquan
 * @Date: 2020/5/10 20:46
 */
public class Pinpoint2DingTalkSmsSender implements SmsSender  {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSms(AlarmChecker checker, int sequenceCount, StepExecution stepExecution) {
        if(StringUtils.isEmpty(dingTalkUrl)){
            logger.warn("web.ding.talk.url is not set！");
            return;
        }
        List smsMessage = checker.getSmsMessage();
        String textMsg = String.join("\r\n", smsMessage);
        send(textMsg);
    }

    @Autowired
    private RestTemplate restTemplate;
    private String dingTalkUrl;

    private static String DING_ALARM_PREFIX= "【告警】";
    public Pinpoint2DingTalkSmsSender(){
        logger.info("init DingTalkSmsSender,{}",dingTalkUrl);
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

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDingTalkUrl() {
        return dingTalkUrl;
    }

    public void setDingTalkUrl(String dingTalkUrl) {
        this.dingTalkUrl = dingTalkUrl;
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
