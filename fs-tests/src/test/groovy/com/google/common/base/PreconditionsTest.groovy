package com.google.common.base

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/19.
 */
class PreconditionsTest extends Specification {

    def "判断参数是否符合某种条件,不推荐使用,但是可模拟写法"() {
        given:
        def age = 999
        boolean flag = age >= 18 && age < 99;
        Preconditions.checkArgument(flag, "age must in range (18,99)");
    }

    def "校验字符串是否为空,不推荐使用,但是可模拟写法"() {
        given:
        Preconditions.checkNotNull("我的天啊")
        Preconditions.checkNotNull("", "我是异常消息1")
        Preconditions.checkNotNull(null, "我是异常消息2")
    }
}
