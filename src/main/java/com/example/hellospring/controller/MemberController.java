package com.example.hellospring.controller;


import com.example.hellospring.domain.Member;
import com.example.hellospring.domain.MemberFormDto;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    // 오토와이어드 어노테이션이 스프링 컨테이너에서 memberService Bean 을 찾아서 넣어준다.
    // DI : 의존성 주입, 스프링이 알아서 넣어준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberFormDto form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        // Home 화면으로 redirect
        // redirect는 주소로 보낼 때
        // html은 파일 경로를 리턴
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }


}
