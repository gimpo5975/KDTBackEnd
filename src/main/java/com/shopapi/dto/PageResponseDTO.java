package com.shopapi.dto;

import java.util.List;

public class PageResponseDTO<E> {

    private List<E> dtoList;

    private List<Integer> pageNumList;

    private PageRequestDTO pageRequestDTO;

    private boolean prev, next;

    private int totalCount, prevPage, nextPage, totalPage, current;


    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long total){

    }


}
