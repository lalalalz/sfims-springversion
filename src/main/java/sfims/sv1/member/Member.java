package sfims.sv1.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Slf4j
@Entity
@Getter
@EqualsAndHashCode
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String loginId;
    private String password;
    private String birthday;
    private String name;
    private String phone;
    private String email;

    protected Member() {}

    public Member(String loginId, String password, String birthday, String name, String phone, String email) {
        this.loginId = loginId;
        this.password = password;
        this.birthday = birthday;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
