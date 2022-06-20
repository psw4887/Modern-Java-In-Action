package com.nhnacademy.lambda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaExpression {

    public static void main(String[] args) {

        LambdaExpression le = new LambdaExpression();

        // TODO 1: 람다, 익명클래스를 사용한 예
        le.run((n) -> log.trace("lambda 사용"), 1);

        // TODO 2: 

    }

    private <T extends Number> void run(Print p, T type) {

        p.print(type);
    }
}

@FunctionalInterface
interface Print <T> {

    void print(T type);
}