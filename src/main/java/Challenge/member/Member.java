package Challenge.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @NotNull
    @Column(name = "id", length = 8, unique = true)
    private String id;

    @NotNull
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @Column(name = "password", length = 15)
    private String password;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "address", length = 100)
    private String address;

    @NotNull
    @Column(name = "coin")
    private int coin;

    public Member(String id, String name, String email, String password, LocalDate birth, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
        this.coin = 2000;
    }
}
