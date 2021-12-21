package hello.advanced.app.v3;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService3 {

    private final OrderRepository3 orderRepository3;
    // LogTrace 인터페이스 주입받는다
    private final LogTrace trace;

    public void orderItem(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.request()");
            orderRepository3.save(itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e;// 예외를 꼭 다시 던져주어야함
        }
    }
}
