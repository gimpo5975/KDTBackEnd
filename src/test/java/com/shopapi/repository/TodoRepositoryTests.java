package com.shopapi.repository;

import com.shopapi.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1(){

        Assertions.assertNotNull(todoRepository);
        // Assertions.assertNotNull(todoRepository); 코드는 JUnit 같은 테스트 프레임워크에서 사용되는 구문으로,
        // todoRepository 객체가 null이 아닌지를 확인합니다. 즉, todoRepository가 null이면 테스트를 실패시키고,
        // 그렇지 않다면 테스트를 계속 진행하게 됩니다.

        log.info(todoRepository.getClass().getName());

    }


    @Test
    public void testInsert(){//객체 저장 테스트
        Todo todo = Todo.builder()  //객체 생성
                .title("Title")
                .content("Content")
                .deuDate(LocalDate.of(2024,5,8))
                .build();

        Todo result =  todoRepository.save(todo);   //데이터베이스에 객체 저장

        log.info(result);//생성된 객체 확인
    }

}//end of class