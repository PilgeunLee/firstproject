package org.example.firstproject.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.firstproject.dto.MemberForm;
import org.example.firstproject.entity.Member;
import org.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.lang.model.element.NestingKind;

@Slf4j
@Controller
public class MemberController{

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/singup")
    public String singUpPage(){
        return"members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm memberForm){
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return"";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id="+id);
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        Iterable<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "members/index";
    }


}