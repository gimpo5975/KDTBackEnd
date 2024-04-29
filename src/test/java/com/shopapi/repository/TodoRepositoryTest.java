package com.shopapi.repository;

import com.shopapi.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @DisplayName("TodoRepository 테스트")
    public void repositoryTest1() {

        log.info("===========================");
        log.info(todoRepository);
    }


    @Test
    @DisplayName("데이터 추가 테스트")
    public void testInsert() {

        for (int i = 1; i <= 10; i++) {

            Todo todo = Todo.builder()
                    .title("제목" + i)
                    .dueDate(LocalDate.of(2024, 04, 26))
                    .writer("hong" + i)
                    .build();

            todoRepository.save(todo);
        }
    }

    @Test
    @DisplayName("데이터 조회 테스트")
    public void testRead(){
        Long tno = 5l;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info("----------");
        log.info(todo);

    }

    @Test
    @DisplayName("데이터 수정 테스트")
    public void testModify(){
        Long tno = 2l;

        Optional<Todo> result = todoRepository.findById(tno);


        Todo todo = result.orElseThrow();
        todo.setTitle("기분 좋은날");
        todo.setWriter("홍길동");

        todoRepository.save(todo);

    }

    @Test
    @DisplayName("데이터 삭제 테스트")
    public void testDelete(){
        Long tno = 1l;

        todoRepository.deleteById(tno);
    }

    @Test
    @DisplayName("페이징 처리 테스트")
    public void testPaging(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());
        Page<Todo> result = todoRepository.findAll(pageable);

        log.info("--------------------");
        log.info(result.getTotalElements());

        result.getContent().stream().forEach(todo -> log.info(todo));
    }



}//end of class