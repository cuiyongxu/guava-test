package com.google.common.net

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/21.
 */
class UrlEscapersTest extends Specification{

    /**
     * 暂未发现区别
     * @return
     */
    def "url地址转码"(){
        given:
        String url = "<a href=\"http://en.wikipedia.org/wiki/UTF-16\">UTF-16</a>にほん｜友達";
        println UrlEscapers.urlFormParameterEscaper().escape(url)
        println URLEncoder.encode(url,"UTF-8")
    }
}
