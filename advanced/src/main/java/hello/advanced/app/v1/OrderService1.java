package hello.advanced.app.v1;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService1 {

    private final OrderRepository1 orderRepository1;
    private final HelloTraceV1 helloTraceV1;

    public void orderItem(String itemId){

        TraceStatus status = null;

        try{
            status = helloTraceV1.begin("OrderService.request()");
            orderRepository1.save(itemId);
            helloTraceV1.end(status);
        }catch (Exception e){
            helloTraceV1.exception(status, e);
            throw e;// 예외를 꼭 다시 던져주어야함
        }
    }
}
