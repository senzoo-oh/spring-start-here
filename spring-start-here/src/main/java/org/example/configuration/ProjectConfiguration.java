package org.example.configuration;

import org.example.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      // 해당 클래스가 구성클래스임을 나타내는 어노테이션
public class ProjectConfiguration {

    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
