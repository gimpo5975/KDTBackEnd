package com.shopapi;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Abc {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bbb","ccc", "ddd"};
        //배열을 문자열로 저장
       List<String> strList = Arrays.asList(strArr);

        //정렬하고 출력
        //1. 기존 방식
        Arrays.sort(strArr);
        Collections.sort(strList);

        for(String str : strArr){
            System.out.println(str);
        }
        for(String str : strList){
            System.out.println(str);
        }


        //  => 위 데이터 소스를 기반으로 하는 스트림을 생성
        Stream<String> strStream1 = strList.stream();
        Stream<String> strStream2 = Arrays.stream(strArr);

       // strStream1.sorted().forEach(System.out::println );
        strStream2.sorted()
                .forEach(System.out::println);   //스티림 처리하고 닫음
       // int numOfStr = strStream2.count();  //에러, 스트림이 이미 닫혔음
           //  단,한번 사용하면 닫혀서 다시 사용할 없음. 필요하다면 스트림을 다시 생성해야 함


        // 중간 연산 : 연산 결과가 스트림인 연산, 스트림에 연속해서 중간 연산할 수 있음

        // 최종 연산 : 연산 결과가 스트림이 아닌 연산, 스트림의 요소를 소모하므로 단 한번만 가능
        strStream1.distinct().limit(2).sorted().forEach(System.out::println );
        //           중간연산      중간연산         중간연산   최종연산
        //스트림에서 중간 연산은 연산결과를 스트림으로 반환하기 때문에 중간 연산을 연속해서 연결할 수 있음
        // 지연된 연산 :스트림의 중간 연산은 최종 연산이 수행되기 전까지는 수행되지 않음
        //          distinct(), Limit(), sorted() 등은 즉각 적인 연산이 수행되는 것이 아니라
        //          단지 어떤 작업이 수행되어야하는지를 지정해주는 것일 뿐
        //          최종 연산이 수행되어야 비로소 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모 됨

        //distinct() : 중복을 제거
        //filter(Predicate<T> predcate)  : 조건에 안 맞는 요소는 제외
        // limit(long maxSize)  :  스트림의 일부를 잘라냄
        // sorted() : 스트림의 요소를 정렬
        //  Stream<T>       map()  : 스트림의 요소를 반환
        //  DoubleStream    mapToDouble(ToDoubleFunction<T> mapper)
        //  IntStream       mapToInt(ToIntFunction<T> mapper)
        //   ...
        //  Stream<T>       flatMap(Function<T, Stream<R>> mapper), 스트림 요소를 반환
        //  long count()    : 스트림의 요소의 개수 반환
        //...
        // Optional<T> reduce(BinaryOperator<T> accumulator) : 스트림의 요소를 하나씩 줄여(리듀싱)가면서 게산
        //...
        // collect(Collector<T,A,R> collector) : 스트림의 요소를 수집
        //                                  주로 요소를 그룹화하거나 분할한 결과를 컬렉션에서 담아 반환하는데 사용
        // ....   나머지는 jdk17 API 참조





        // 중간연산은 map(), flatMap() 많이 사용
        // 최종연선 reduce(), collect()

    }



}
