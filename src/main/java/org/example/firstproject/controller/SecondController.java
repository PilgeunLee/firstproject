package org.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/random-quote")
    public String randomQuite(Model model){
        String[] quote ={
                "행복은 습관이다. 그것을 몸에 지니라"+"-허버드",
                "고개를 숙이지 마십시오. 세상을 똑바로 정면으로"+"-헬렌켈러-",
                "고난의 시기에 동요하지 않는것 이것은 진정"+"-베토벤-",
                "당신이 할 수 있다고 믿ㄴ든 할수 없다고 믿든"+"-헨리 포드-"
        };
        int randInt =(int)(Math.random() * quote.length);
        model.addAttribute("randomQuote",quote[randInt]);
        return "quote";
    }
}
