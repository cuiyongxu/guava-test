package com.google.common.base

import com.ijson.groovy.entity.Client
import com.google.common.collect.Lists
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class MoreObjectsTest extends Specification {

    /**
     * 如果第一个值为null,则返回第二个值,a为null,b也为null,则抛出空指针
     * @return
     */
    def "map设置返回默认值,只对null有效,且前后值为同类型"() {

        given:
        def a = ""
        def b = Lists.newArrayList("aaa")
        when:
        def v = MoreObjects.firstNonNull(a, b)
        then:
        println v
        v instanceof String
    }





    def "查看toString"() {
        given:
        //默认com.google.common.base.MoreObjectsTest$Client@453da22c
        //转换后Student{id=1, name=Jim, age=13}
        Client student = new Client();
        student.setId(1);
        student.setName("ww");
        student.setAge(13);
        println student.toString()
        println student.toLogString()
    }

}
