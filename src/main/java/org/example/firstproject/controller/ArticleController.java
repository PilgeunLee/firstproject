package org.example.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.firstproject.dto.ArticleForm;
import org.example.firstproject.entity.Article;
import org.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        //System.out.println(form.toString());

        //1. DTO를 엔티티로 변환
        Article article =form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        //2. 리파지토리를 엔티티를 DB로 저장
        Article saved =articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return"" ;
    }
}
