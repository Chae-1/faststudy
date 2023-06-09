package chbo.chbo.ch3;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registerDateTime;

    public Member(String email, String password, String name, LocalDateTime registerDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = registerDateTime;
    }

    public void changePassword(String oldPwd, String newPwd) {
        if(!password.equals(oldPwd))
            throw new WrongIdPasswordException();
        this.password = newPwd;
    }
}
