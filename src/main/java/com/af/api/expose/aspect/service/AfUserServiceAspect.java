package com.af.api.expose.aspect.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.af.api.expose.utils.Constants.AOP_AF_USER_SERVICE_MAIN_METHOD;
import static com.af.api.expose.utils.Constants.AOP_AF_USER_SERVICE_PATH;


@Component
public class AfUserServiceAspect {
    @Pointcut(AOP_AF_USER_SERVICE_PATH)
    public void startAfUserService() {
    }

    @Around(AOP_AF_USER_SERVICE_MAIN_METHOD)
    public Object afUserServiceSteps(ProceedingJoinPoint afUserService) throws Throwable {
        afUserService.getArgs();
        try {
            return afUserService.proceed();
        } catch (Exception exception) {
            throw exception;
        }
    }
}