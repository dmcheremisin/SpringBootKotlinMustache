package com.springboot.kotlin.blog.controller

import com.springboot.kotlin.blog.service.ArticleService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["articles"] = articleService.getAllArticles()
        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun getArticleBySlug(@PathVariable slug: String, model: Model): String {
        val article = articleService.getArticleBySlug(slug)
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

}