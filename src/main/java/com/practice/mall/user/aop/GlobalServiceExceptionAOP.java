package com.practice.mall.user.aop;

import com.practice.mall.user.exception.CheckedException;
import com.practice.mall.user.exception.ResultAssertException;
import com.practice.mall.user.response.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalServiceExceptionAOP {

    @Around("execution(* com.practice.mall.user.service.*.*(..))")
    public Response handleCheckedException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return (Response) joinPoint.proceed();
        } catch (ResultAssertException ex) {
            return new Response(ex.getCode(), ex.getMessage());

        } catch (CheckedException ex) {
            return new Response(ex.getCode(), ex.getMessage());
        }

    }
}
