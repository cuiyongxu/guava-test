package com.google.common.base

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/21.
 */
class JoinerTest extends Specification {

    def "拼接字符串"() {
        given:
        Joiner joiner = Joiner.on(":").skipNulls();
        println joiner.join("123", null, "foo", "bar"," ","ddd","","aa",null,"bb");

    }


    def "拼接字符串2"() {
        given:
        Joiner joiner = Joiner.on("&").skipNulls();
        println joiner.join("123", 22, "foo", "bar"," ","ddd","","aa",99,"bb");

    }
}
