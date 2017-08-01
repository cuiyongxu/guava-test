package com.google.common.collect

import com.ijson.groovy.entity.Client
import com.google.common.base.Joiner
import com.google.common.base.MoreObjects
import com.google.common.base.Predicate
import com.google.common.base.Predicates
import org.spockframework.util.Nullable
import spock.lang.Specification


/**
 * 当对象被不可信的库调用时，不可变形式是安全的；
 * 不可变对象被多个线程调用时，不存在竞态条件问题
 * 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
 * 不可变对象因为有固定不变，可以作为常量来安全使用。
 * 集合测试,list
 * Created by cuiyongxu on 17/6/16.
 */
class CollectionsTest extends Specification {

    def "使用builder创建不可变集合"() {
        given:
        Set<String> strings = ImmutableSet.<String> builder().add("e", "d", "c", "a").build();
        strings.forEach({
            k ->
                k;
                println k
        })
    }

    def "使用of创建不可变集合"() {
        given:
        Set<String> strings = ImmutableSet.of("e", "d", "c", "a");
        strings.forEach({
            k ->
                k;
                println k
        })
    }

    def "使用copyOf创建不可变集合"() {
        given:
        String[] string = new String[4];
        string[0] = "r";
        string[1] = "a";
        string[2] = "c";
        string[3] = "d";
        Set<String> strings = ImmutableSet.copyOf(string);
        strings.forEach({
            k ->
                k;
                println k
        })
    }


    def "有序不可变集合，排序是在构造集合的时候完成的"() {
        given:
        ImmutableSet<String> isortedSet = ImmutableSortedSet.of("c", "a", "d", "2", "e", "c", "3", "4");
        ImmutableSet<String> set = ImmutableSet.of("e3", "e1", "e2");

        ImmutableList<String> iList = ImmutableList.of("c", "a", "b", "1");

        ImmutableMap<String, String> iMap = ImmutableMap.of("k2", "v2", "k1", "v1");

        //COLOR_NAMES.add("purple")//会抛出空指针,不允许呗修改
        println isortedSet
        println set
        println iList
        println iMap
    }


    def "从不可变集合中取值"() {
        given:
        ImmutableMap<String, String> iMap = ImmutableMap.of(
                "k1", "v1",
                "k2", "v2",
                "k3", "v3",
                "k4", "v4",
                "k5", "v5");
        ImmutableSet keys = iMap.keySet();
        keys.forEach({ key ->
            key;
            println iMap.get(key)
        })

    }

    def "将map转换为特定规则的字符串"() {
        given:
        ImmutableMap<String, String> iMap = ImmutableMap.of(
                "k1", "v1",
                "k2", "v2",
                "k3", "v3",
                "k4", "v4",
                "k5", "v5");

        println iMap.toString()
        String result = Joiner.on(",").withKeyValueSeparator("=").join(iMap);
        println result
    }


    def "将list转换为特定规则的字符串"() {
        given:
        ImmutableList<String> iList = ImmutableList.of("c", "a", "b", "1");
        println iList.toString()
        String result = Joiner.on("-").join(iList);
        println result
    }


    def "list条件过滤String"() {
        given:
        ImmutableList<String> names = ImmutableList.of("begin", "code", "Guava", "Java");
        Iterable<String> fitered = Iterables.filter(names, Predicates.or(Predicates.equalTo("Guava"), Predicates.equalTo("Java")));
        println fitered
    }


    def "list条件过滤对象属性值"() {
        given:
        ImmutableList<Client> names = ImmutableList.of(Client.create(1, "张三", 12), Client.create(2, "李四", 22), Client.create(3, "王五", 33));
        Iterable<Client> fitered = Iterables.filter(names, Predicates.or(new Predicate<Client>() {
            @Override
            boolean apply(@Nullable Client input) {
                if (input.age == 33) {
                    return true
                }
                return false
            }
        }, new Predicate<Client>() {
            @Override
            boolean apply(@Nullable Client input) {
                if (input.name.equals("李四")) {
                    return true
                }
                return false
            }
        }));
        fitered.forEach({
            value ->
                value
                println value.age + ":" + value.name
        })
    }

    def "检查一个collection中的所有元素是否符合某个条件"() {
        given:
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        boolean result = Iterables.all(names, Predicates.containsPattern("Jane|m"));
        println result
    }

    def "从map中取值,如果为空,则赋默认值"() {
        given:
        def map = Maps.newHashMap();
        println MoreObjects.firstNonNull(map.get("key"), "abc")
        map.put("key", "")
        println MoreObjects.firstNonNull(map.get("key"), "abc")
        map.put("key", "value")
        println MoreObjects.firstNonNull(map.get("key"), "abc")
    }


}


































