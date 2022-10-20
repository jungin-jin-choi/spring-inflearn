package hello.core.lifecycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient implements InitializingBean, DisposableBean {
    private String url;
    public NetworkClient(){
        System.out.println("생성자호출, url="+url);
    }

    public void setUrl(String url){
        this.url = url;
    }
    // 서비스 시작 시 호출
    public void connect(){
        System.out.println("connect = " + url);
    }
    public void call(String message){
        System.out.println("call = " + url + " message = "+message);
    }
    public void disconnect(){
        System.out.println("close =" + url);
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화");
    }

    @PreDestroy
    public void destroy() throws Exception {
        disconnect();
    }
}
