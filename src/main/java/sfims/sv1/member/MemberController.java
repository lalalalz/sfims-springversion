package sfims.sv1.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfims.sv1.member.dto.JoinForm;
import sfims.sv1.member.dto.LoginForm;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        LoginForm loginForm = new LoginForm();
        model.addAttribute("loginForm", loginForm);
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        JoinForm joinForm = new JoinForm();
        model.addAttribute("joinDto", joinForm);
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute @Valid JoinForm joinForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        return "redirect:/home";
    }
}
