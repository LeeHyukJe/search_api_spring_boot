package com.wisenut.search.domain.common.security;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class SecurityChecker {

    @Pointcut("@annotation(SecurityCheck)")
    public void checkMethodSecurity(){}

    @Around("checkMethodSecurity()")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("Checking mehtod security....");
        // TODO 여기에 보안 검사 로직 구현하기
        Object result = joinPoint.proceed();
        return result;
    }
}
