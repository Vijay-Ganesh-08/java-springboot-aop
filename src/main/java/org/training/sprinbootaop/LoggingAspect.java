package org.training.sprinbootaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {


    /*
     * Aspect-Oriented Programming (AOP) in Spring Boot is a powerful feature that enhances modularity by
     * handling cross-cutting concerns such as logging, security, and transaction management
     * separately from business logic
     */

    /*
     * Before is used to execute this method before the actual execution
     * AfterReturning is used to execute this method only when the actual execution is successfully completed
     * AfterReturning is used to execute this method only when the actual execution throws exception
     * After is used to execute this method regardless the actual execution throws exception or completed successfully.
     */

    @Before("execution(public * org.training.sprinbootaop.EmployeeController.getAliens())")
    public void logBefore(){
        log.info("GetEmployees Method called");
    }

    @AfterReturning("execution(public * org.training.sprinbootaop.EmployeeController.getAliens())")
    public void logAfter(){
        log.info("GetEmployees Method Executed Successfully");
    }

    @AfterThrowing("execution(public * org.training.sprinbootaop.EmployeeController.getAliens())")
    public void logAfterThrowing(){
        log.info("GetEmployees Method Throws Exception");
    }

    @After("execution(public * org.training.sprinbootaop.EmployeeController.getAliens())")
    public void logAfterFinally(){
        log.info("GetEmployees Method Completed");
    }

    @Pointcut("execution(* org.training.sprinbootaop.EmployeeController.*(..))")
    public void userControllerMethods() {}

    @AfterReturning(pointcut = "userControllerMethods()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        log.info("GetEmployees Method {} Returns {} ",joinPoint.getSignature().getName(),result);
    }

}
