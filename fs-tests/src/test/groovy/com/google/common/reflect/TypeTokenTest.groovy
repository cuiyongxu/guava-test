package com.google.common.reflect

import com.google.common.collect.Lists
import spock.lang.Specification

/**
 * 反射
 * 遗留,使用场景?
 * Created by cuiyongxu on 17/6/20.
 */
class TypeTokenTest extends Specification {

    def "java 泛型擦除"() {
        given:
        ArrayList<String> stringList = Lists.newArrayList("1");
        ArrayList<Integer> intList = Lists.newArrayList(1);

        println "stringList type is " + stringList.getClass()
        println "intList type is " + intList.getClass()
        println stringList.getClass().isAssignableFrom(intList.getClass())
    }

    def "test" (){
        given:
        Object stringList = Lists.newArrayList("1");
        List<Integer> rsts=stringList;
        rsts.forEach({
            i-> println i;
        })
    }

    def "guava解决方式"() {
        given:
        TypeToken<ArrayList<String>> stringList = new TypeToken<ArrayList<String>>() {};
        TypeToken<ArrayList<Integer>> intList = new TypeToken<ArrayList<Integer>>() {};


        TypeToken<?> stringTypeToken = stringList.resolveType(ArrayList.class.getTypeParameters()[0]);
        TypeToken<?> intTypeToken = intList.resolveType(ArrayList.class.getTypeParameters()[0]);

        println "stringList type is " + stringTypeToken.getType()
        println "intList type is " + intTypeToken.getType()
        println stringList.getClass().isAssignableFrom(intList.getClass())
    }

    def "guava其他方法"() {
        given:
        TypeToken<ArrayList<String>> stringList = new TypeToken<ArrayList<String>>() {};

        //获得包装的java.lang.reflect.Type.
        println stringList.getType()
        //返回的运行时类
        println stringList.getRawType()
        //返回一个Set，包含了这个所有接口，子类和类是这个类型的类
        println stringList.getTypes()
        //检查某个类型是不是数组
        println stringList.isArray()
        println stringList.getComponentType()


    }
}
