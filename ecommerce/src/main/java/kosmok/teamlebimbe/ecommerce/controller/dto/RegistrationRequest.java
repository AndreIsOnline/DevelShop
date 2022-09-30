package kosmok.teamlebimbe.ecommerce.controller.dto;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;

public class RegistrationRequest {
    @NotBlank(message = "Mandatory username")
    private String username;
    @NotBlank(message = "Mandatory email")
    private String email;
    @NotBlank(message = "Mandatory password")
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
