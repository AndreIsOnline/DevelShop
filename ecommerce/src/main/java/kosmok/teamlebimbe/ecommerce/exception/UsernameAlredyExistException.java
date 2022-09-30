package kosmok.teamlebimbe.ecommerce.exception;

public class UsernameAlredyExistException extends RuntimeException {

    private static final long serialVersionUID = -3915381141253480396L;

    private String username;

    public UsernameAlredyExistException(String username) {
        super("Username alredy exist: " + username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
