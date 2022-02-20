package hello.advanced.trace.proxy;

import hello.advanced.trace.proxy.code.ProxyPatternClient;
import hello.advanced.trace.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatterTest {

    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

}
