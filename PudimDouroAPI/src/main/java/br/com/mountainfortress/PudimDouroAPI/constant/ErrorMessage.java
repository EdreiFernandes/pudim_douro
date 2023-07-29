package br.com.mountainfortress.PudimDouroAPI.constant;

public final class ErrorMessage {
    public static final String USER_NOT_EXIST = "This user does not exist";
    public static final String EDITION_NOT_EXIST = "There is no open edition";
    public static final String REGISTERED_USER = "User is already registered";
    public static final String INVALID_TOKEN = "Token is not valid!";
    public static final String REGISTERED_EMAIL = "E-mail already registered!";
    public static final String WRONG_LOGIN = "Wrong email or password!";

    private ErrorMessage(){
        throw new AssertionError();
    }
}
