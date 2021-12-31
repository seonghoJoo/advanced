package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace){
        this.trace = trace;
    }
    //제네릭은 반환 타입만 신경쓰면 됨
    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try{

            status = trace.begin(message);
            //로직 호출
            T result = callback.call();
            
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
