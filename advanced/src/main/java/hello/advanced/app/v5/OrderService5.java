package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService5 {

    private final OrderRepository5 orderRepository5;
    // LogTrace 인터페이스 주입받는다
    private final TraceTemplate template;

    public OrderService5(OrderRepository5 orderRepository5, LogTrace trace) {
        this.orderRepository5 = orderRepository5;
        this.template = new TraceTemplate(trace);
    }


    public void orderItem(String itemId){

        template.execute("OrderService.orderItem(itemId)", ()-> {
                orderRepository5.save(itemId);
                return null;
        });
        //제네릭 Void 으로 설정
    }
}
