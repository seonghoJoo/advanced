# advanced

Spring 심화편

앞으로 배울것

로그추적기

#ThreadLocal

## 동시성 문제
지역변수에서는 발생하지 않는다. 지역변수는 쓰레드마다 각각 다른 메모리영역이 할당된다.
동시성 문제가 발생하는 곳은 같은 ```인스턴스의 필드(싱글톤에서 발생), static 공용 필드```에서 발생


### 예제
1. ```private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();``` 
2. ```private ThreadLocal<String> traceIdHolder = new ThreadLocal<>();  ```
3. ```private ThreadLocal<Integer> traceIdHolder = new ThreadLocal<>();  ```

## 템플릿 메서드 패턴
### 변하는 것과 변하지 않는것을 분리(핵심기능 | 부가기능)


