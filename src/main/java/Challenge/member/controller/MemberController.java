package Challenge.member.controller;

import Challenge.member.domain.Member;
import Challenge.member.dto.SignUpRequest;
import Challenge.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
    private final MemberService memberService;

    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

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

    @GetMapping("/mypage")
    public String myPage(@SessionAttribute(value = "memberId", required = false) String memberId, Model model) {
        if (memberId == null) {
            return "redirect:/login";
        }

        Member member = memberService.getMemberById(memberId);
        model.addAttribute("member", member);
        return "mypage";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model, @SessionAttribute(name = "memberId", required = false) String memberId) {
        if (memberId == null) {
            return "redirect:/login";
        }

        Member member = memberService.getMemberById(memberId);
        model.addAttribute("member", member);
        return "/update";
    }

    @PostMapping("/update")
    public String updateMember(@ModelAttribute Member member, @SessionAttribute(name = "memberId", required = false) String memberId) {
        if (memberId == null) {
            return "redirect:/login";
        }

        memberService.updateMember(member);
        return "redirect:/update";
    }

    @PostMapping("/delete")
    public String deleteMember(HttpSession session) {
        String memberId = (String) session.getAttribute("memberId");
        if (memberId != null) {
            memberService.deleteMember(memberId);
            session.invalidate();
        }
        return "redirect:/main";
    }

}
