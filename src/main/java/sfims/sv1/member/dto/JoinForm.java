package sfims.sv1.member.dto;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Slf4j
public class JoinForm {

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 20)
    private String loginId;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "/^\\d{8}$/")
    @Size(min = 8, max = 8)
    private String birthday;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotEmpty
    @NotBlank
    private String phone;

    @Email
    @NotBlank
    @NotEmpty
    @Size(max = 40)
    private String email;

    public JoinForm() {}

    public JoinForm(String loginId, String birthday, String name, String phone, String email) {
        this.loginId = loginId;
        this.birthday = birthday;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
