package com.google.common.base

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class SplitterTest extends Specification {

    def "将String转换成list"() {
        given:
        String string = "2,a,c,5,e,6";
        when:
        List<String> list = Splitter.on(",").splitToList(string)
        then:
        println list
    }

    def "将String转换成list3"() {
        given:
        String string = "\"2\",\"3\"";
        when:
        List list = Splitter.on(",").splitToList(string)
        then:
        println list
    }

    def "将String转换成list4"() {
        given:
        String string = "2,3";
        when:
        List list = Splitter.on(",").splitToList(string)
        then:
        println list
    }




    def "将List转换成String"() {
        given:
        def string = Joiner.on("#").join("aa", "vvv");
        println string
    }

    def "将String转换成list2"() {
        given:
        String string = "AccountObj.name";
        String string2 = "AccountObj.name.fields";
        when:
        List<String> list2 = Splitter.on(".").splitToList(string2)
        then:
        println list
        println list2
    }

    def "将String转换成map"() {
        given:
        String string = "wansong=万松,liyiguang=李异光,wangzhuang=王壮,lichaoshuai=李朝帅";
        when:
        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(string);
        then:
        println map.get("wansong")
    }


    def "String转map2"() {
        given:
        def extension = "mongo.servers = mongodb://test:C80E9E8C92B849BEFA7008DE8CFB4FD4@vlnx112045001.x.firstshare.cn:27017/test  ";
        Map<String, String> map = Splitter.on(",").omitEmptyStrings().trimResults().withKeyValueSeparator("=").split(extension);
        println map.toString()
    }

    def "将String转换成list,去空格"() {
        given:
        String string = "2,a , c  ,5  ,e,  6";
        when:
        List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(string)
        then:
        println list
    }


    def "Map转String"() {
        given:
        Map<String, String> map = Maps.newHashMap()
        map.put("a", "b");
        map.put("c", "d");
        println Joiner.on(",").withKeyValueSeparator("=").join(map);
    }


    def "将String按照特定规则切割,不去空值"() {
        given:
        String string = "aa.dd,,ff,,.";
        List<String> list = Splitter.onPattern("[.|,]").splitToList(string);
        println list
    }


    def "正则分割,可包含多个标点符号,去空格,并转list"() {
        given:
        String string = "aa.dd,,ff,,.";
        List<String> list = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(string);
        println list
    }


    def "正则分割,可包含多个标点符号,去空格"() {
        given:
        Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .split("hello,word,,世界，水平, ， , 我的，， 你的,大家的,");

        splitResults.forEach({
            String str ->
                str;
                println str
        })
    }

}

