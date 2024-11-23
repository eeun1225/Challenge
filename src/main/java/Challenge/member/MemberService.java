package Challenge.member;

import Challenge.member.dto.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public Member signUp(SignUpRequest signUpRequest) {
        Member member = new Member(
                signUpRequest.getId(),
                signUpRequest.getName(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getBirth(),
                signUpRequest.getPhone(),
                signUpRequest.getAddress()
        );

        return memberRepository.save(member);
    }

    public boolean isIdDuplicate(String id) {
        return memberRepository.existsById(id);
    }
}
