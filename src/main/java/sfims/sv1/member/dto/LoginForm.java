package sfims.sv1.member.dto;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Slf4j
public class LoginForm {

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 20)
    private String loginId;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    public LoginForm() {}

    public LoginForm(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
