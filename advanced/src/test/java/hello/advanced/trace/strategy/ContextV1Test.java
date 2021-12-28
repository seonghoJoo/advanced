package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.StrageLogic1;
import hello.advanced.trace.strategy.code.strategy.StrageLogic2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /*
       전략패턴 사용
    */
    @Test
    void strategyV1(){
        StrageLogic1 strageLogic1 = new StrageLogic1();
        ContextV1 context1 = new ContextV1(strageLogic1);
        context1.execute();

        StrageLogic2 strageLogic2 = new StrageLogic2();
        ContextV1 context2 = new ContextV1(strageLogic2);
        context2.execute();
    }

    //익명 클래스 사용 가능
    @Test
    void strategyV2(){
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직 1 실행");
            }
        };
        ContextV1 context1 = new ContextV1(strategyLogic1);
        log.info("strategyLogic1 = {}", strategyLogic1.getClass());
        context1.execute();

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직 2 실행");
            }
        };
        ContextV1 context2 = new ContextV1(strategyLogic2);
        log.info("strategyLogic2 = {}", strategyLogic2.getClass());
        context2.execute();
    }

    // 불필요한 변수 선언 없애기
    @Test
    void strategyV3(){
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직 1 실행");
            }});
        context1.execute();

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직 2 실행");
            }
        });
        context2.execute();
    }

    //람다 사용
    @Test
    void strategyV4(){

        ContextV1 context1 = new ContextV1(()->log.info("비즈니스 로직 실행1"));
        context1.execute();
        ContextV1 context2 = new ContextV1(()->log.info("비즈니스 로직 실행2"));
        context2.execute();
    }
}
