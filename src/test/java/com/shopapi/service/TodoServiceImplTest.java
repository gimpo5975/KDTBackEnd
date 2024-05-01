package com.shopapi.service;

import com.shopapi.dto.PageRequestDTO;
import com.shopapi.dto.PageResponseDTO;
import com.shopapi.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("service 등록 테스트...")
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("서비스 테스트1")
                .writer("홍길동 테스터")
                .dueDate(LocalDate.of(2024, 04, 30))
                .build();

        Long tno = todoService.register(todoDTO);
        log.info("서비스 테스트 결과 TNO : " + tno);
    }

    @Test
    @DisplayName("목록처리 테스트")
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();

        PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);

        log.info("목록처리 테스트 ---------------------" + response);

    }
}





// 스트림(stream)
//       데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메소드들을 정의해 놓음
//       데이터 소스를 추상화 - 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게
//        만들어 놓은 것, 코드의 재사용성이 높아짐
//        스트림을 이용하면 배열이나 컬렉션 뿐만 아니라 파일에 저장된 데이터도 모두
//        같은 방식으로 다룰 수 있음
//        단,한번 사용하면 닫혀서 다시 사용할 없음. 필요하다면 스트림을 다시 생성해야 함
//        스트림은 데이터 소스를 변경하지 않는다. 데이터 소스로부터 데이터를 읽기만할 뿐
//         정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수 있음
//        List<String> sortList = strStream.sorted().collect(Collectors.toList());
//        forEach(람다식)



























