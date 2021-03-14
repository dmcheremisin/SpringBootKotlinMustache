package com.springboot.kotlin.blog.extensions

import com.springboot.kotlin.blog.dto.RenderedArticle
import com.springboot.kotlin.blog.entities.Article

fun Article.render() = RenderedArticle(
        slug,
        title,
        headline,
        content,
        author,
        addedAt.format()
)