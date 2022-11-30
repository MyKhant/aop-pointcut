package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {
    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyServicePointCut(){}
    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetAnnotationCurrencyServicePointcut(){}
    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyPointCut(){}
    @Pointcut("@annotation(com.demo.annotation.Intransaction)")
    public void annotationCurrencyServicePointCut(){}
    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointcut(){}
    @Pointcut("args(int,int)")
    public void argsCurrencyServicePointcut(){}
    @Pointcut("execution(public * com.demo.service.AccountServiceImpl.test(..))")
    public void executionCurrencyServicePointcut(){}
    @Pointcut("@args(com.demo.annotation.Validated)")
    public void argsAnnotationCurrencyServicePointcut(){}
//    @Before("withinCurrencyServicePointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s is invoke with %s before advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
    @Before("withinAnnotationCurrencyPointCut()")
    public void beforeWithinAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s is invoke with %s before advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
//    @Before("annotationCurrencyServicePointCut()")
    public void beforeAnnotationCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s before advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
//    @Before("beanCurrencyServicePointcut()")
    public void beforeBeanCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s before advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
//    @Before("withinCurrencyServicePointCut() && argsCurrencyServicePointcut()")
    public void argsBeanCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s before advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
//    @After("targetAnnotationCurrencyServicePointcut()")
    public void argsAnnotationCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s parameter after advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }
//    @AfterReturning(value = "argsAnnotationCurrencyServicePointcut()",returning = "country")
    public void argsAnnotationAfterReturningCurrencyAdvice(JoinPoint joinPoint,String country) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s parameter after returning advice return value:: [%s] in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        country,
                        LocalDateTime.now())
        );
    }
//    @AfterThrowing(value = "argsAnnotationCurrencyServicePointcut()",throwing = "e")
    public void argsAnnotationAfterReturningCurrencyAdvice(JoinPoint joinPoint,Throwable e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s parameter after throwing advice exception class is:: [%s] in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        e.getClass().getSimpleName(),
                        LocalDateTime.now())
        );
    }
//    @Around("targetAnnotationCurrencyServicePointcut()")
    public Object argsAnnotationCurrencyAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s method is invoke with %s parameter around advice in [%s].",
                        className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
        try {
            return joinPoint.proceed();
        }catch (Throwable e){
            System.out.println("Exception has been caught.");
        }
        finally {
            System.out.println("After invoking method >>>>");
        }
        return null;
    }
}
