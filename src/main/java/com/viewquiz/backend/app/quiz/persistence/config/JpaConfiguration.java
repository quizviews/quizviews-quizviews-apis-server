package com.viewquiz.backend.app.quiz.persistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.viewquiz.backend.app.quiz.persitence.repository")
public class JpaConfiguration {

}
