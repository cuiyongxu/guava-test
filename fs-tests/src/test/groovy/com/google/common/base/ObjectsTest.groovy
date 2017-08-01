package com.google.common.base

import com.google.common.collect.Lists
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class ObjectsTest extends Specification {

    // CollectionUtil - apache 可以不分先后顺序
    def "判断两个值是否相等,可判断任意对象"() {
        given:
        def a = Lists.newArrayList("a,b")
        def b = Lists.newArrayList("b")
        def c = Lists.newArrayList("b,a")
        println Objects.equal(a, b)
        println Objects.equal(a, c)
    }

}
