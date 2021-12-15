package hello.advanced.trace;

import hello.advanced.trace.hellotrace.HelloTrace;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {

    @Test
    void bigin_end(){
        HelloTrace trace = new HelloTrace();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception(){
        HelloTrace trace = new HelloTrace();
        TraceStatus status = trace.begin("Hello");
        trace.exception(status, new IllegalStateException());
    }

}
