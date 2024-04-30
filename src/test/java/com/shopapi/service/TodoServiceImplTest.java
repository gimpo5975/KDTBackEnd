package com.shopapi.service;

import com.shopapi.domain.Todo;
import com.shopapi.dto.TodoDTO;
import com.shopapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class TodoServiceImplTest {

    @Autowired
    private TodoService todoService;

    @Test
    @DisplayName("등록 테스트")
    public void testRegister() {

    TodoDTO todoDTO = TodoDTO.builder()
            .title("서비스 테스트1")
            .writer("홍길동")
            .dueDate(LocalDate.of(2024, 04, 30))
            .build();

    Long tno = todoService.register(todoDTO);
    log.info("서비스 테스트 결과 : " + tno);

    }//end of method

}//end of class