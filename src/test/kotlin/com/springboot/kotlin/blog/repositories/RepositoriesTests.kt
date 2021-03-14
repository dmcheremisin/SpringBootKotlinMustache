package com.springboot.kotlin.blog.repositories

import com.springboot.kotlin.blog.entities.Article
import com.springboot.kotlin.blog.entities.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val article = Article("Spring Framework 5.0 GA goes GA", "Dear Spring community...", "Loren ipsum", juergen)
        entityManager.persist(article);
        entityManager.flush()
        val articleFromDb = articleRepository.findByIdOrNull(article.id!!)
        assertThat(articleFromDb).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val userFromDb = userRepository.findByLogin(juergen.login)
        assertThat(userFromDb).isEqualTo(juergen)
    }
}