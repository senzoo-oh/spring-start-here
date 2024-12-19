package org.example.configuration;

import org.example.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration      // 해당 클래스가 구성클래스임을 나타내는 어노테이션
@ComponentScan(basePackages = "org.example.services")
@EnableAspectJAutoProxy     // 스프링 앱에서 애스펙트 메커니즘을 활성화 함
public class ProjectConfiguration {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
