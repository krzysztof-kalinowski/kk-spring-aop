package kkalinowski.springaop.controller;

import kkalinowski.springaop.aop.CustomAuthentication;
import kkalinowski.springaop.aop.CustomCredentialsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/time")
    public void timeTest() {
    }

    @PostMapping("/login")
    @CustomAuthentication
    public void login(@RequestBody CustomCredentialsDto customCredentialsDto) {
        log.info("login : "+customCredentialsDto.getLogin()+"; password: "+customCredentialsDto.getPassword());
    }

}
