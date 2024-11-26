package Challenge.challenge.domain;

import Challenge.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 20)
    private String period;

    @Column(nullable = false)
    private LocalDate due_date;

    @Column(nullable = false)
    private int frequency;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int coin;

    @Column(nullable = false, length = 20)
    private String category;

    @Column(nullable = false, length = 10)
    private String certification;

    @OneToOne
    @Column(nullable = false, length = 20)
    private Member member;

    public Challenge(String title, String description, String period, LocalDate due_date, int frequency, int capacity, int coin, String category, Member member) {
        this.title = title;
        this.description = description;
        this.period = period;
        this.due_date = due_date;
        this.frequency = frequency;
        this.capacity = capacity;
        this.coin = coin;
        this.category = category;
        this.member = member;
    }

}
