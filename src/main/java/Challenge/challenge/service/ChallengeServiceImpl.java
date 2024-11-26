package Challenge.challenge.service;

import Challenge.challenge.domain.Challenge;
import Challenge.challenge.dto.ChallengeDto;
import Challenge.challenge.repository.ChallengeRepository;

public class ChallengeServiceImpl implements ChallengeService {
    private ChallengeRepository challengeRepository;

    @Override
    public Challenge createChallenge(ChallengeDto challengeDto){
        Challenge challenge = new Challenge(
                challengeDto.getTitle(),
                challengeDto.getDescription(),
                challengeDto.getPeriod(),
                challengeDto.getDue_date(),
                challengeDto.getFrequency(),
                challengeDto.getCapacity(),
                challengeDto.getCoin(),
                challengeDto.getCategory(),
                challengeDto.getMember()
        );
        return challengeRepository.save(challenge);
    }

    @Override
    public void deleteChallenge(int challengeId) {
        Challenge challenge = challengeRepository.findById(challengeId).get();
        challengeRepository.delete(challenge);
    }

}

