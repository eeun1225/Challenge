package Challenge.member.service;

import Challenge.member.domain.Member;
import Challenge.member.repository.MemberRepository;
import Challenge.member.dto.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


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

    public void updateMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }

    public Member getMemberById(String memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다."));
    }
}
