package kkalinowski.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CustomAuthenticationAspect {

    @Before("@annotation(authentication) && args(credentials,..)")
    public void before(CustomAuthentication authentication, CustomCredentials credentials) {
        log.info("CustomAuthenticationAspect login: "+credentials.getLogin());
        log.info("CustomAuthenticationAspect password: "+credentials.getPassword());

        if (!(credentials.getLogin().equals("test") && credentials.getPassword().equals("test"))) {
            throw new RuntimeException("Wrong login or password");
        }
    }
}
