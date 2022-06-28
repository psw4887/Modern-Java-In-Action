package com.nhnacademy.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaExpression {

    public static void main(String[] args) throws IOException {

        LambdaExpression le = new LambdaExpression();

        // TODO 1: 람다, 익명클래스를 사용한 예
        le.run((n) -> log.trace("lambda 사용"), 1);

        // TODO 2: 실행 어라운드 패턴
        log.trace(le.processFile());
        log.trace(le.processFile(BufferedReader::readLine));


    }

    private <T extends Number> void run(Print p, T type) {

        p.print(type);
    }

    private String processFile() throws IOException {
        try(BufferedReader bf = new BufferedReader(new FileReader("data.txt"))) {
            return bf.readLine();
        }
    }

    private String processFile(BufferReaderProcessor b) throws IOException {

        try(BufferedReader bf = new BufferedReader(new FileReader("data.txt"))) {
            return b.process(bf);
        }
    }
}

@FunctionalInterface
interface Print <T> {

    void print(T type);
}

@FunctionalInterface
interface  BufferReaderProcessor {
    String process(BufferedReader b) throws IOException;
}