package hello.advanced.app.v1;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController1 {

    private final OrderService1 orderService1;

    @GetMapping("/v1/request")
    public String request(String itemId){
        orderService1.orderItem(itemId);

        return "ok";
    }

}
