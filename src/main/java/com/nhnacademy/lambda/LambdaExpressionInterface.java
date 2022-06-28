package com.nhnacademy.lambda;

import java.io.BufferedReader;
import java.io.IOException;

public interface LambdaExpressionInterface {

    @FunctionalInterface
    interface Print <T> {

        void print(T type);
    }

    @FunctionalInterface
    interface  BufferReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    @FunctionalInterface
    interface Consumer<T> {
        void accept(T t);
    }

    @FunctionalInterface
    interface Function<T, R> {
        R apply(T t);
    }
}
