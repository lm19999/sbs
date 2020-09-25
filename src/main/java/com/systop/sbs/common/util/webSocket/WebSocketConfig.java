package com.systop.sbs.common.util.webSocket;

/**
 * @Program: springboot-websocket
 * @Description: TODO
 * @Author: liumiao
 * @Date: 2020/8/27 9:26
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket配置
 */
@Configuration
public class WebSocketConfig{


    /**
     * 用途：扫描并注册所有携带@ServerEndpoint注解的实例。 @ServerEndpoint("/websocket")
     * PS：如果使用外部容器 则无需提供ServerEndpointExporter。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 支持注入其他类
     */
    @Bean
    public MyEndpointConfigure  newMyEndpointConfigure (){
        return new MyEndpointConfigure ();
    }
}
