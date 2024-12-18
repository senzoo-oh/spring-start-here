package org.example.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration      // 해당 클래스가 구성클래스임을 나타내는 어노테이션
@ComponentScan(basePackages = {"org.example.services", "org.example.repositories", "org.example.processors"})
public class ProjectConfiguration {
}
