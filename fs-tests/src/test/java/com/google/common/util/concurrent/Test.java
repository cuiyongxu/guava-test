package com.google.common.util.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by cuiyongxu on 17/6/21.
 */
public class Test {
    public static void main(String[] args) {
        List stringList = Lists.newArrayList("1");
        List<Integer> rsts=  stringList;

        Consumer<? super Integer> xx=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        Predicate<? super Integer> filter=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };
        rsts.stream().filter(filter).forEach(xx);
    }
}
