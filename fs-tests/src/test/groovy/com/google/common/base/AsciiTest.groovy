package com.google.common.base

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class AsciiTest extends Specification {

    def IGNORED = "`10-=~!@#\$%^&*()_+[]\\{}|;':\",./<>?'\u00c1\u00e1\n";
    def LOWER = "abcdefghijklmnopqrstuvwxyz";
    def UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    def "判断字符串大小写是否相等"() {
        given:

        println Ascii.toLowerCase(UPPER).equals(LOWER)
        println Ascii.toLowerCase(IGNORED).equals(IGNORED)
        println Ascii.toLowerCase("coding").equals("coding")

        println Ascii.toUpperCase(LOWER).equals(UPPER)
        println Ascii.toUpperCase(IGNORED).equals(IGNORED)
        println Ascii.toUpperCase("coding").equals("CODING")
        println Ascii.toUpperCase("ddd").equals(null)
        println Ascii.toUpperCase("\${demo}").equals("\${demo}")

        println "\${demo}".toUpperCase().equals("\${demo}")

    }


}
