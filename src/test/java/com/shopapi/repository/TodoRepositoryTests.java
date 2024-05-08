package com.shopapi.repository;

import com.shopapi.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;

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
        for(int i=0;i<100; i++){
            Todo todo = Todo.builder()  //객체 생성
                    .title("Title"+i)
                    .content("Content"+i)
                    .dueDate(LocalDate.of(2024,5,8))
                    .build();

            Todo result =  todoRepository.save(todo);   //데이터베이스에 객체 저장

            log.info(result);//생성된 객체 확인
        }

    }

    @Test
    public void testRead(){//객체 저장 테스트

        Long tno = 1L;  //검색할 pk 임의 지정

        Optional<Todo> result = todoRepository.findById(tno);//db 에서 pk 1인 데이터 검색

        Todo todo = result.orElseThrow();

        log.info(todo);
    }


    @Test
    public void testUpdate(){//객체 변경 테스트

        //먼저 로딩 하고 엔티티 객체를 변경 setter
        Long tno = 1L;  //검색할 pk 임의 지정

        Optional<Todo> result = todoRepository.findById(tno);//db 에서 pk 1인 데이터 검색

        Todo todo = result.orElseThrow();

        todo.setTitle("Update Title");
        todo.setContent("Update Content");
        todo.setComplete(true);

        todoRepository.save(todo);
        log.info(todo);

    }

    @Test
    public void testPaging(){
        
        //페이지 번호는 0부터
        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> result =  todoRepository.findAll(pageable);

        log.info(result.getTotalElements());

        log.info(result.getContent());
        
    }

    @Test
    public void testSearch1(){

        todoRepository.search1();

    }

}//end of class