package Challenge.challenge.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class ChallengeParticipantId {
    private int challenge_id;
    private String participant_id;

    public ChallengeParticipantId(int challenge_id, String participant_id) {
        this.challenge_id = challenge_id;
        this.participant_id = participant_id;
    }
}
