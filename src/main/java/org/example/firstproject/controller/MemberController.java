package org.example.firstproject.controller;


import org.example.firstproject.entity.Member;
import org.example.firstproject.dto.MemberForm;
import org.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

@Autowired
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members/new")
    public String newMemberForm(){
        return"members/new";
    }

    @PostMapping("/members/join")
    public String joinMember(MemberForm form){
        System.out.println(form.toString());

        Member member=form.toEntity();
        System.out.println(member.toString());

        Member saved =memberRepository.save(member);
        System.out.println(saved.toString());

        return"";
    }
}
