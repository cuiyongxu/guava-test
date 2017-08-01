package com.google.common.base

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class StringsTest extends Specification {

    def "判断字符串是我否为空"() {

        given:
        println Strings.isNullOrEmpty(null)
        println Strings.isNullOrEmpty("")
        println Strings.isNullOrEmpty("null")
        println Strings.isNullOrEmpty("123")

    }

    def "获得两个字符串相同的前缀"() {
        given:
        def a = "com.google.common.base";
        def b = "com.google.common.net";
        println Strings.commonPrefix(a, b);
    }

    def "获得两个字符串相同的后缀"() {
        given:
        def a = "com.google.common.base.Util1.java";
        def b = "com.google.common.net.Util2.java";
        println Strings.commonSuffix(a, b)
    }

    def "用0补全字符串后不足位"() {
        given:
        char c = '0'
        println Strings.padEnd("test", 10, c);
    }

    def "用0补全字符串前不足位"() {
        given:
        char c = '0'
        println Strings.padStart("test", 10, c);
    }


    def "字符串为空串或null,可以null值为参数,null或空传返回null"() {
        given:
        def a = "";
        def b = null;
        def c = "test";
        when:
        def av = Strings.emptyToNull(a);
        def bv = Strings.emptyToNull(b);
        def cv = Strings.emptyToNull(c);
        then:
        println av + ":" + bv + ":" + cv
        null == av
        null == bv
        "test" == cv
    }


}
