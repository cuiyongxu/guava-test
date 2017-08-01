package com.google.common.base

import com.ijson.groovy.entity.Client
import spock.lang.Specification

/**
 * 最大的优点在于它是一种傻瓜式的防护
 * Created by cuiyongxu on 17/6/19.
 */
class OptionalTest extends Specification {

    def str = "ceshi";

    def "非空值校验"() {
        given:
        Optional<String> stringOptional = Optional.of(str)
        println stringOptional.get()
    }
    //为Optional赋值，当T为Null直接抛NullPointException,建议这个方法在调用的时候直接传常量，不要传变量
    def "空值校验"() {
        given:
        //提前报错
        Optional<Client> clientOptional = Optional.of(null);
    }

}
