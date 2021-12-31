package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController5 {

    private final OrderService5 orderService5;

    private final TraceTemplate traceTemplate;

    // LogTrace 인터페이스 주입받는다
    public OrderController5(OrderService5 orderService5, LogTrace trace) {
        this.orderService5 = orderService5;
        this.traceTemplate = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId){

        return traceTemplate.execute("OrderController.request()", new TraceCallback<String>() {
            @Override
            public String call() {
                orderService5.orderItem(itemId);
                return "ok";
            }
        });

        //제네릭 String으로 설정
    }

}
