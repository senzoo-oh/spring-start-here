package org.example.main;

import org.example.configuration.ProjectConfiguration;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;
        System.out.println(b1);
    }
}