package Challenge.challenge.service;

import Challenge.challenge.domain.Challenge;
import Challenge.challenge.dto.ChallengeDto;

public interface ChallengeService {
    Challenge createChallenge(ChallengeDto challengeDto);
    void deleteChallenge(int challengeId);
}
