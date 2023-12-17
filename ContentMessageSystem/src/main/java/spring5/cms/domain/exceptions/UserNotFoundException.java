package spring5.cms.domain.exceptions;

public class UserNotFoundException extends RuntimeException {

    private String id;
    public UserNotFoundException(String id) {
        this.id = id;
    }
}
