package Challenge.challenge.repository;

import Challenge.challenge.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
}
