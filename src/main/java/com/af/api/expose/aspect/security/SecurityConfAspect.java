package com.af.api.expose.aspect.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.af.api.expose.utils.Constants.ANNOTATION_PATH;
import static com.af.api.expose.utils.Constants.AOP_SECURITY_CONF_MAIN_METHOD;

@Aspect
@Component
public class SecurityConfAspect {

    @Pointcut(ANNOTATION_PATH)
    public void securityAspect() {
    }

    @Around(AOP_SECURITY_CONF_MAIN_METHOD)
    public Object securityAspect(ProceedingJoinPoint securityConf) throws Throwable {
        securityConf.getArgs();
        return securityConf.proceed();
    }
}
