package chbo.chbo.ch3;

import lombok.Data;

@Data
public class RegisterRequest {
    private String confirmPassword;
    private String password;
    private String email;
    private String name;

    public boolean isPasswordEqualToConfirmPassword() {
        return password.equals(confirmPassword);
    }

}
