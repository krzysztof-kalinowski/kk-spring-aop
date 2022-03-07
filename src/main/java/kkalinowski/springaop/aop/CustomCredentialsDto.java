package kkalinowski.springaop.aop;

public class CustomCredentialsDto implements CustomCredentials {

    private String login;
    private String password;

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
