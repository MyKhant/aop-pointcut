package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AccountServiceAspect {
    @Pointcut("this(com.demo.service.AccountServiceImpl)")
    public void thisPointcutAccountService(){}

//    @Before("thisPointcutAccountService()")
    public void beforeAccountServiceAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s is invoke with before advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(), LocalDateTime.now())
        );
    }
}
