package Challenge.member;

import Challenge.member.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
        Member member = memberService.signUp(signUpRequest);
        return ResponseEntity.ok("회원가입을 축하드립니다.");
    }

    @GetMapping("/signup/checkId")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkDuplicateId(@RequestParam String id) {
        boolean isDuplicate = memberService.isIdDuplicate(id);

        Map<String, Object> response = new HashMap<>();
        if (isDuplicate) {
            response.put("status", "BAD_REQUEST");
            response.put("message", "이미 사용 중인 아이디입니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("status", "OK");
            response.put("message", "사용 가능한 아이디입니다.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

}
