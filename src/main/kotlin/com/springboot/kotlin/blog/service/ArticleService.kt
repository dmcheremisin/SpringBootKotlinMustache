package com.springboot.kotlin.blog.service

import com.springboot.kotlin.blog.dto.RenderedArticle
import com.springboot.kotlin.blog.entities.Article
import com.springboot.kotlin.blog.extensions.render
import com.springboot.kotlin.blog.repositories.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class ArticleService(private val articleRepository: ArticleRepository) {

    @Transactional(readOnly = true)
    fun getAllArticles() = articleRepository.findAllByOrderByAddedAtDesc().map { it.render() }

    @Transactional(readOnly = true)
    fun getArticleBySlug(slug: String): RenderedArticle {
        return articleRepository.findBySlug(slug)
                ?.render()
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Article doesn't exist")
    }

}