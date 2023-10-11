package com.af.api.expose.aspect.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.af.api.expose.utils.Constants.ANNOTATION_PATH;
import static com.af.api.expose.utils.Constants.AOP_VALIDATE_USER_INFORMATION_MAIN_METHOD;

@Component
@Aspect
public class ValidateAfUserRegistrationAsp {

    @Pointcut(ANNOTATION_PATH)
    public void validateAfUserInfo() {
    }

    @Around(AOP_VALIDATE_USER_INFORMATION_MAIN_METHOD)
    public Object validateAfUserInfo(ProceedingJoinPoint validateAfUserAsp) throws Throwable {
        validateAfUserAsp.getArgs();
        return validateAfUserAsp.proceed();
    }
}
