package kosmok.teamlebimbe.ecommerce.exception;

public class EmailAlredyExistException extends RuntimeException {
    private static final long serialVersionUID = -3915381141253480396L;

    private String email;

    public EmailAlredyExistException(String email) {
        super("Email already exist: " + email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



}
