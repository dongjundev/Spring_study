# ControllerAdvice, AOP 테스트
ControllerAdvice, AOP 함께 사용.
aop로 요청값, 응답값 로깅시 서비스에서 에러가 터지면 aop 응답값이 찍히지않음. 에러가 터진 순간부터 controllerAdvice가 처리하고 aop로 돌아오지않음.
@Transactional은 잘 작동함.

## 일반
![image](https://user-images.githubusercontent.com/60119368/175475029-7e9ab6a5-1e9f-4ef4-935c-5cc888a65f70.png)

## 런타임 에러
![image](https://user-images.githubusercontent.com/60119368/175475102-d730f798-f114-4f27-8489-aaf5fc2d898b.png)

## DB 에러
![image](https://user-images.githubusercontent.com/60119368/175475249-b063330a-e9e6-46ca-b4b9-89c3816c76e1.png)
try{}catch{} 처럼 먹어버리지 않고 @Transactional 잘 작동함.
