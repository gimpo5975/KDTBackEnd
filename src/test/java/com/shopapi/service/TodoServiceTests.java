package com.shopapi.service;

import com.shopapi.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2

public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet(){
        Long tno = 50L;

        log.info(todoService.get(tno));
    }


    @Test
    public void testRegister(){

        TodoDTO dto = TodoDTO.builder()
                .title("Title")
                .content("Content")
                .dueDate(LocalDate.of(2023,12,31))
                .build();

        log.info(todoService.register(dto));

    }

}
