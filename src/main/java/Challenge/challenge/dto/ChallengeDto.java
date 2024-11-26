package Challenge.challenge.dto;

import Challenge.member.domain.Member;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ChallengeDto {
    private int id;
    private String title;
    private String description;
    private String period;
    private LocalDate due_date;
    private int frequency;
    private int capacity;
    private int coin;
    private String category;
    private String certification;
    private Member member;
}
