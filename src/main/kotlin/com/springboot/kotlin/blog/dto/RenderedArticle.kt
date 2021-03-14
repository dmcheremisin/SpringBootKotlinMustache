package com.springboot.kotlin.blog.dto

import com.springboot.kotlin.blog.entities.User

data class RenderedArticle(
        val slug: String,
        val title: String,
        val headline: String,
        val content: String,
        val author: User,
        val addedAt: String
)