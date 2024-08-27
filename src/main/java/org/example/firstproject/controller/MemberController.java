package org.example.firstproject.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.firstproject.entity.Member;
import org.example.firstproject.dto.MemberForm;
import org.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
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
        log.info(form.toString());
        //System.out.println(form.toString());

        Member member=form.toEntity();
        log.info(member.toString());
        //System.out.println(member.toString());

        Member saved =memberRepository.save(member);
        log.info(saved.toString());
        //System.out.println(saved.toString());

        return"";
    }
}
