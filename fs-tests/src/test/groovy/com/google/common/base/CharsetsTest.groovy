package com.google.common.base

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class CharsetsTest extends Specification {

    def "校验两个汉字是否相等(不分先后顺序)"() {
        given:

        def name = "崔永旭"
        def name2 = "崔旭永"
        when:
        byte[] b1 = name.getBytes();
        byte[] b2 = name2.getBytes();

        byte[] b3 = name.getBytes(Charsets.US_ASCII);
        byte[] b4 = name2.getBytes(Charsets.US_ASCII);

        then:
        false == Arrays.equals(b1, b2)//java 默认  false
        true == Arrays.equals(b3, b4)//true
    }
}
