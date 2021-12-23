package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    // 동시성 문제
    // 여러 쓰레드가 동시에 같은 인스턴스 필드의 값을 변경하면서 발생하는 문제
    // 여러 쓰레드가 같은 인스턴스 필드에 값에 접근해야 하기때문에 트래픽이 증가할수록 자주 발생한ㅁ다.
    // 싱글톤 객체의 필드를 변경하며 사용할때 동시성 문제를 조심해야한다.
    @Test
    void local(){
        log.info("main Start");
        Runnable userA = () ->{
            service.logic("userA");
        };

        Runnable userB = () ->{
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        // Thread-A는 userA를 namestore에 저장했다.
        threadA.start();
        //sleep(2000);//동시성 문제 발생 X
        sleep(100);
        // Thread-B는 userB를 namestore에 저장했다.
        threadB.start();
        // Thread-A는 userB를 namestore에 조회했다.
        // Thread-B는 userB를 namestore에 조회했다..

        sleep(3000);// 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int i) {
        try{
            Thread.sleep(i);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
