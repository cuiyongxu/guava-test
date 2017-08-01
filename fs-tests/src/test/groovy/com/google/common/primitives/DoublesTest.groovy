package com.google.common.primitives

import com.greenpineyu.fel.FelEngine
import com.greenpineyu.fel.FelEngineImpl
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/21.
 */
class DoublesTest extends Specification {


    def "运算表达式问题:1.0 / 0.0"() {
        given:
        FelEngine fel = new FelEngineImpl();
        Object obj = fel.eval("1/0");
        println obj
        println Double.isInfinite(obj)
    }


    def "运算表达式问题:0.0 / 0.0"() {
        given:
        FelEngine fel = new FelEngineImpl();
        Object obj = fel.eval("0/0");
        println obj
        println Double.isNaN(obj)
    }

    def "运算表达式问题:-1 / 0.0"() {
        given:
       //暂无
        println "NEGATIVE_INFINITY"
    }

}
