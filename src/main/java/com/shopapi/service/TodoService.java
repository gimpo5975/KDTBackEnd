package com.shopapi.service;

import com.shopapi.domain.Todo;
import com.shopapi.dto.TodoDTO;

public interface TodoService {
//#1. 등록 기능
    Long register(TodoDTO todoDTO);


}//end of interface
