package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //메소드에 붙이는 에노테이션
@Retention(RetentionPolicy.RUNTIME) //런타임 동안에 살아있는
public @interface MethodAop {
    String value();
}
