package kkalinowski.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
@Slf4j
public class TimeLoggingAspect {

    @Pointcut("execution(* kkalinowski.springaop..*(..))")
    private void timeLogPointcut() {
    }

    @Before("timeLogPointcut()")
    public void beforeTimeLogPointcut(JoinPoint joinPoint) {
        log.info("beforeTimeLogPointcut "+ joinPoint.getSignature().getName());
    }

    @After("timeLogPointcut()")
    public void afterTimeLogPointcut(JoinPoint joinPoint) {
        log.info("afterTimeLogPointcut "+ joinPoint.getSignature().getName());
    }

    @Around("execution(* kkalinowski.springaop.controller..*(..))")
    public Object aroundTimeLogPointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long time = System.nanoTime() - startTime;
        log.info("aroundTimeLogPointCut "+proceedingJoinPoint.getSignature().getName()+" time: "+time+" ns");
        return proceed;
    }
}
