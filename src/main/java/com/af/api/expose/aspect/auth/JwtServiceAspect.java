package com.af.api.expose.aspect.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.af.api.expose.utils.Constants.AOP_JWT_SERVICE_MAIN_METHOD;
import static com.af.api.expose.utils.Constants.ANNOTATION_PATH;

@Aspect
@Component
public class JwtServiceAspect {

    @Pointcut(ANNOTATION_PATH)
    public void jwtService(){}

    @Around(AOP_JWT_SERVICE_MAIN_METHOD)
    public Object jwtService(ProceedingJoinPoint jwtServiceAsp) throws Throwable {
        jwtServiceAsp.getArgs();
        return jwtServiceAsp.proceed();
    }
}
