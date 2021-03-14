package com.springboot.kotlin.blog.repositories

import com.springboot.kotlin.blog.entities.Article
import com.springboot.kotlin.blog.entities.User
import org.springframework.data.repository.CrudRepository

interface ArticleRepository: CrudRepository<Article, Long> {

    fun findBySlug(slug: String): Article?

    fun findAllByOrderByAddedAtDesc(): Iterable<Article>

}

interface UserRepository: CrudRepository<User, Long> {

    fun findByLogin(login: String): User?
}
