package com.shopapi.service;

import com.shopapi.domain.Todo;
import com.shopapi.dto.PageRequestDTO;
import com.shopapi.dto.TodoDTO;
import com.shopapi.repository.TodoRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2

public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet(){
        Long tno = 1L;

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

    @Test
    public void testModify(){

        TodoDTO dto = TodoDTO.builder()
                .tno(1L)
                .title("ModifyTitle")
                .content("ModifyContent")
                .dueDate(LocalDate.of(2024,11,11))
                .build();

        todoService.modify(dto);
    }


    @Test
    public void testGetList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(10)
                .build();
        log.info(todoService.getList(pageRequestDTO));

    }


}
