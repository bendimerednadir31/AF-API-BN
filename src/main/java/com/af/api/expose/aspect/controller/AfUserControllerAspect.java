package com.af.api.expose.aspect.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.af.api.expose.utils.Constants.AOP_AF_USER_CONTROLLER_MAIN_METHOD;
import static com.af.api.expose.utils.Constants.AOP_AF_USER_CONTROLLER_PATH;

@Aspect
@Component
public class AfUserControllerAspect {
    @Pointcut(AOP_AF_USER_CONTROLLER_PATH)
    public void startAfUserController(){}

    @Around(AOP_AF_USER_CONTROLLER_MAIN_METHOD)
    public Object afUserRegistrationSteps(ProceedingJoinPoint afUserRegistration) throws Throwable {
        afUserRegistration.getArgs();
        try {
            return afUserRegistration.proceed();
        } catch (Exception exception) {;
            throw exception;
        }
    }
}