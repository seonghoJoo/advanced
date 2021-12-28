# advanced

Spring 심화편

앞으로 배울것

## 로그추적기
1. v0 - 로그 trace 적용 전
2. v1 - TraceStatus 변수가 controller->service->repository로 이어지지 않음
3. v2 - TraceStatus 변수 인터페이스 선언 인스턴스 객체 traceId 동시성 문제 발생(FieldLocalLogTrace)
4. v3 - ThreadLocal을 통해 동시성 문제 해결(ThreadLocalLogTrace) / 핵심기능과 부가기능이 섞여있음
5. v4 - 템플릿 메서드 적용 (핵심기능과 템플릿을 호출하는 코드가 섞여있음)

# ThreadLocal

## 동시성 문제
지역변수에서는 발생하지 않는다. 지역변수는 쓰레드마다 각각 다른 메모리영역이 할당된다.
동시성 문제가 발생하는 곳은 같은 ```인스턴스의 필드(싱글톤에서 발생), static 공용 필드```에서 발생


### 쓰레드 로컬 사용 예제
1. ```private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();``` 
2. ```private ThreadLocal<String> traceIdHolder = new ThreadLocal<>();  ```
3. ```private ThreadLocal<Integer> traceIdHolder = new ThreadLocal<>();  ```

## 템플릿 메서드 패턴
### 변하는 것(부가기능)과 변하지 않는것(핵심기능)을 분리

![image](https://user-images.githubusercontent.com/32606456/147478017-f5d8a137-36d2-469c-9587-9fbcb5b570a3.png)

execute() -> call() 호출
call() -> 상속받은 call()호출
