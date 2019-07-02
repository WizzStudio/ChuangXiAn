package com.chuangxian.util;

import com.chuangxian.exception.NoAuthenticationException;
import com.chuangxian.util.ToolSupport.ResponseBodySovler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeChatUtil {

    @Value("${wx.url}")
    private String WECHAT_OPENID_URL;

    private static RestTemplate restTemplate = new RestTemplate();

    public ResponseBodySovler getWechatResponseBody(String code) throws Exception {
        //String url = WECHAT_OPENID_URL + URLEncoder.encode(code,"UTF-8");
        String url = WECHAT_OPENID_URL + code;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() != 200) {
            throw new NoAuthenticationException("connect wechat failed");
        }

        ResponseBodySovler responseBodySovler = JsonUtil.jsonToObject(responseEntity.getBody(), ResponseBodySovler.class);
        return responseBodySovler;
    }

    public String test() {
        //WeChatUtil weChatUtil = new WeChatUtil();
        return WECHAT_OPENID_URL;
    }


}
