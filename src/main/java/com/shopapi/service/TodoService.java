package com.shopapi.service;

import com.shopapi.domain.Todo;
import com.shopapi.dto.TodoDTO;

public interface TodoService {
//#1. 등록 기능
    Long register(TodoDTO todoDTO);

    //#2. 조회
    TodoDTO get(Long tno);
    
    //#3. 업데이트
    void modify(TodoDTO todoDTO);

    //#4. 삭제
    void remove(Long tno);

    //#5. 페이징

}//end of interface
