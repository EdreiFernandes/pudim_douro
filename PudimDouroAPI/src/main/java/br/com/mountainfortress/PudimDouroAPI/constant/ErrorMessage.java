package br.com.mountainfortress.PudimDouroAPI.constant;

public final class ErrorMessage {
    public static final String USER_NOT_EXIST = "This user does not exist";
    public static final String EDITION_NOT_EXIST = "There is no open edition";
    public static final String REGISTERED_USER = "User is already registered";
    public static final String INVALID_TOKEN = "Token is not valid!";
    public static final String REGISTERED_EMAIL = "E-mail already registered!";
    public static final String USED_NICKNAME = "Nickname already used!";
    public static final String WRONG_LOGIN = "Wrong email or password!";
    public static final String DUPLICATE_VOTE = "Your vote has already been registered";
    public static final String NOT_SUBSCRIBED = "Selected user is not subscribed to this edition";
    public static final String EQUAL_USERS = "Users are equal in more than one position";
    public static final String AVAILABLE_SOON = "'Sorry! This functionality is not yet available. Try again later, please!";

    private ErrorMessage(){
        throw new AssertionError();
    }
}
