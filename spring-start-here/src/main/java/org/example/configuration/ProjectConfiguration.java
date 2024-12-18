package org.example.configuration;

import org.example.services.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration      // 해당 클래스가 구성클래스임을 나타내는 어노테이션
@ComponentScan(basePackages = {"org.example.services", "org.example.repositories"})
public class ProjectConfiguration {
}
