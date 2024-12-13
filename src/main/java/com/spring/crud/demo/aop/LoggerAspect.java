package com.spring.crud.demo.aop;

import com.spring.crud.demo.model.emp.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Before("@annotation(com.spring.crud.demo.annotation.LogObjectBefore)")
    public void logEmployeeBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Employee) {
                Employee employee = (Employee) arg;
                log.info("******* Employee before :: {}", employee);
            }
        }
    }

    @AfterReturning(value = "@annotation(com.spring.crud.demo.annotation.LogObjectAfter)", returning = "result")
    public void logEmployeeAfter(JoinPoint joinPoint, Object result) {
        if (Objects.nonNull(result)) {
            if (result instanceof ResponseEntity) {
                ResponseEntity responseEntity = (ResponseEntity) result;

                if (responseEntity.getStatusCode().value() == 200) {
                    log.info("******* Returning object :: {}", responseEntity.getBody());
                } else {
                    log.error("Something went wrong while logging...!");
                }
            }
        }
    }
}
