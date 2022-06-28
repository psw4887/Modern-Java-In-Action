package com.nhnacademy.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaExpression {

    public static void main(String[] args) throws IOException {

        LambdaExpression le = new LambdaExpression();

        // TODO 1: 람다, 익명클래스를 사용한 예
        le.run((n) -> log.trace("lambda 사용"), 1);

        // TODO 2: 실행 어라운드 패턴
//        log.trace(le.processFile());
//        log.trace(le.processFile(BufferedReader::readLine));

        // TODO 3: Predicate
        List<String> listOfStrings = List.of("data", "number", "nhn");
        LambdaExpressionInterface.Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = le.filter(listOfStrings, nonEmptyStringPredicate);
        nonEmpty.forEach(System.out::println);

        // TODO 4: Consumer
        le.forEach(
                Arrays.asList(1,2,3,4,5),
                System.out::println);

        // TODO 5: Function
        List<Integer> l = le.map(
                Arrays.asList("lambdas", "in", "action"),
                String::length);
        System.out.println(l);
    }

    private <T extends Number> void run(LambdaExpressionInterface.Print p, T type) {

        p.print(type);
    }

    private String processFile() throws IOException {
        try(BufferedReader bf = new BufferedReader(new FileReader("data.txt"))) {
            return bf.readLine();
        }
    }

    private String processFile(LambdaExpressionInterface.BufferReaderProcessor b) throws IOException {

        try(BufferedReader bf = new BufferedReader(new FileReader("data.txt"))) {
            return b.process(bf);
        }
    }

    private <T> List<T> filter(List<T> list, LambdaExpressionInterface.Predicate<T> p) {

        List<T> results = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    private <T> void forEach(List<T> list, LambdaExpressionInterface.Consumer<T> c) {

        for(T t: list) {
            c.accept(t);
        }
    }

    private <T, R> List<R> map(List<T> list, LambdaExpressionInterface.Function<T, R> f) {

        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }
}

