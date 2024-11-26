package Challenge.challenge.repository;

import Challenge.challenge.domain.ChallengeParticipantId;
import Challenge.challenge.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, ChallengeParticipantId> {
}
