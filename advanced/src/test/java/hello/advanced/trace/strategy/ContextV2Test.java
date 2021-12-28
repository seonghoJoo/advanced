package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /*
    *   전략 패턴 적용
    * */

    @Test
    void strtategyV1(){
        ContextV2 context = new ContextV2();
        /*
        *   의존관계 주입을 미리 넣는게 아니라 실행시 넣는다.
        *   하나의 Context만 생성을 하면 됨.
        * */

        context.execute(new StrageLogic1());
        context.execute(new StrageLogic2());
    }


}
