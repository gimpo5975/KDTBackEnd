package com.shopapi.repository.search;

import com.shopapi.domain.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1();
}
