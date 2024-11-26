package Challenge.challenge.domain;

import Challenge.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Participation {
    @EmbeddedId
    private ChallengeParticipantId id;

    @ManyToOne
    @MapsId("challenge_id")
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @ManyToOne
    @MapsId("participantid")
    @JoinColumn(name = "participant_id")
    private Member member;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    @Column(nullable = false)
    private String status;
}
