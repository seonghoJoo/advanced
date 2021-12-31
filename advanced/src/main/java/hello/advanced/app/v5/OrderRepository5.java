package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository5 {

    // LogTrace 인터페이스 주입받는다
    private final TraceTemplate template;

    public OrderRepository5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }


    public void save(String itemId){

        template.execute("OrderRepository.save()",() -> {
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}