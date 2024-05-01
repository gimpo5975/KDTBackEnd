package com.shopapi.service;


import com.shopapi.dto.PageRequestDTO;
import com.shopapi.dto.PageResponseDTO;
import com.shopapi.dto.TodoDTO;

public interface TodoService {
    //crud, pageing
    //#1. 등록 기능
    Long register(TodoDTO todoDTO);

    //#2. 조회
    TodoDTO get(Long tno);


    //#3. 업데이트(=갱신)
    void modify(TodoDTO todoDTO);

    //#4. 삭제
    void remove(Long tno);


    //#5. 페이징
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);



}
