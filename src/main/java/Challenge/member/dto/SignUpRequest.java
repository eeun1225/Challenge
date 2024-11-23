package Challenge.member.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class SignUpRequest {
    @NotNull
    @Size(min = 4, max = 20)
    private String id;

    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    @Size(max = 30)
    private String email;

    @NotNull
    @Size(min = 12, max = 20)
    private String password;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birth;

    @Size(min = 10, max = 11)
    private String phone;
    private String address;

}
