package hello.advanced.app.v4;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController4 {

    private final OrderService4 orderService4;

    // LogTrace 인터페이스 주입받는다
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId){

        //제네릭 String으로 설정
        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                orderService4.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()");
    }

}
