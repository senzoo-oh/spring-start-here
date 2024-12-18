package org.example.services;

import org.example.model.Comment;
import org.example.processors.CommentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private ApplicationContext context;

    public void sendComment(Comment c) {
        CommentProcessor p = context.getBean(CommentProcessor.class);   // CommentProcessor를 호출하는 여러 스레드가 있을 경우 경쟁상태 문제 발생가능성 -> 빈 스코프

        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);

        c = p.getComment(); // 수정된 Comment 인스턴스를 가져와 사용함
    }
}
