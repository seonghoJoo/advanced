package hello.advanced.app.v1;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService1 {

    private final OrderRepository1 orderRepository1;

    public void orderItem(String itemId){
        orderRepository1.save(itemId);

    }
}
