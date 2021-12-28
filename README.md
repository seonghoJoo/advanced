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
#### 부모 클래스에 알고리즘의 골격인 템프릿을 정의하고 일부 변경되는 로직은 자식 클래스에 정의하는것. 
자식클래스가 알고리즘 전체 구조를 변경하지 않고 특정부분만 재정의 할수 있음. ```상속```과 ```오버라이딩```을 통한 ```다형성```으로 문제를 해결

![image](https://user-images.githubusercontent.com/32606456/147478017-f5d8a137-36d2-469c-9587-9fbcb5b570a3.png)

execute() -> call() 호출
call() -> 상속받은 call()호출

## 전략 패턴
템플릿 메서드 패턴과 비슷한 역할을 하면서 상속으로 생기는 단점을 제거 할 수 있는 패턴
변하지 않는 부분 ```Context```라는 곳에 두고, 변하는 부분을 ```Strategy```라는 인터페이스를 만들고 해당 인터페이스를 구현하도록 문제 해결
### 상속이 아닌 위임을 통해 문제를 해결
```Context``` 템플릿 역할 ```Strategy``` 변하는 알고리즘 

![image](https://user-images.githubusercontent.com/32606456/147520741-364ca582-8f15-4168-8039-933aa234eafa.png)

###익명 내부 클래스


