package com.en.adback.websocket;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.yeauty.annotation.*;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@ServerEndpoint(prefix = "app.ad.websocket")
@Component
public class WebSocketEndpoint {


    public String  deviceId;

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
        deviceId = parameterMap.getParameter("vmcNo");
        log.info("新连接：客户端id：[{}]",deviceId);
        if (StringUtils.isEmpty(deviceId)){
            session.sendText("无devicesId[?vmcNo=xxxxxxxxxxxxxxx]！");
        }
        Session oldSession = WsSessionManager.getSession(deviceId);
        if (Objects.isNull(oldSession)){
           WsSessionManager.putSession(deviceId,session);
        }else{
            oldSession.close();
            WsSessionManager.putSession(deviceId,session);
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        WsSessionManager.removeSession(deviceId);
        log.info("客户端关闭：客户端id：[{}]",deviceId);
    }

    @OnError
    public void onError(Session session, Throwable e) {
        WsSessionManager.removeSession(deviceId);
        log.error("错误：客户端id：[{}]",deviceId,e);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("收到客户端消息:{}",message);
        session.sendText("服务端收到消息："+message);
    }

    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
       //do nothing!
    }

    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    session.close();
                    System.out.println("read idle：["+deviceId+"]");
                    break;
                case WRITER_IDLE:
                    System.out.println("write idle：["+deviceId+"]");
                    break;
                case ALL_IDLE:
                    System.out.println("all idle：["+deviceId+"]");
                    break;
                default:
                    break;
            }
        }
    }

}