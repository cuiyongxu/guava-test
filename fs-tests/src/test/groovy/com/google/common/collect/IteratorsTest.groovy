package com.google.common.collect

import com.ijson.groovy.entity.Client
import com.google.common.base.Function
import com.google.common.base.Predicate
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/20.
 */
class IteratorsTest extends Specification {

    def "判断迭代器中的元素是否都满足某个条件 all 方法"() {
        given:
        //List<String> list = Lists.newArrayList("李异光","万松","王壮","李朝帅","崔永旭");
        List<String> list = Lists.newArrayList("李异光", "李朝帅");

        Predicate<String> condition = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("李");
            }
        };
        println Iterators.all(list.iterator(), condition);
    }


    def "aaa"() {
        given:
        List<String> list = Lists.newArrayList("a", "b", "c");
        list.stream().map({
            e -> e

        })



    }


    def "判断迭代器中的元素是否都满足某个条件 all 方法2"() {
        given:
        List<String> list = Lists.newArrayList("0Apple", "0Oct", "0Title", "0Video", "0Mp3");

        Predicate<String> condition = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("0");
            }
        };
        println Iterators.all(list.iterator(), condition);
    }


    def "filter方法过滤符合条件的项"() {
        given:
        List<String> list = Lists.newArrayList("李异光", "万松", "王壮", "李朝帅", "崔永旭");
        Iterator<String> startPElements = Iterators.filter(list.iterator(), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("李");
            }
        });

        println startPElements.toList()
    }


    def "find方法返回符合条件的第一个元素"() {
        given:
        List<String> list = Lists.newArrayList("李异光", "万松", "王壮", "李朝帅", "崔永旭");
        String startPElements = Iterators.find(list.iterator(), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("李");
            }
        });

        println startPElements
    }


    def "transform方法，对迭代器元素做转换"() {
        given:
        List<String> list = Lists.newArrayList("李异光", "万松", "王壮", "李朝帅", "崔永旭");
        Iterator<Client> users = Iterators.transform(list.iterator(), new Function<String, Client>() {
            @Override
            Client apply(String input) {
                return new Client(new Random().nextInt(666), input, new Random().nextInt(100));
            }
        })

        for (Client user : users) {
            println user.toString()
        }

    }
}
