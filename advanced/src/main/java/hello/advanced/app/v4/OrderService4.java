package hello.advanced.app.v4;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService4 {

    private final OrderRepository4 orderRepository4;
    // LogTrace 인터페이스 주입받는다
    private final LogTrace trace;

    public void orderItem(String itemId){

        //제네릭 Void 으로 설정
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepository4.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem(itemId)");
    }
}
