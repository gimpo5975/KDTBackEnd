package com.shopapi.dto;

import java.util.List;

public class PageResponseDTO<E> {

    private List<E> dtoList;

    private List<Integer> pageNumList;

    private PageRequestDTO pageRequestDTO;

    private boolean prev, next;

    private int totalCount, prevPage, nextPage, totalPage, current;


    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long total){

        this.dtoList = dtoList;
        this.pageRequestDTO = pageRequestDTO;
        this.totalCount = (int)total;

        //끝페이지 end
        int end = (int) (Math.ceil(pageRequestDTO.getPage() / 10.0)) * 10;
        //현재 페이지 / 10.0 자리 올림 X 10

        //시작 페이지
        int start = end - 9;


        //진짜 마지막 페이지
        int last = (int)(Math.ceil(totalCount / (double) pageRequestDTO.getSize()));

    }


}
