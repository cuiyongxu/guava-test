package com.google.common.collect

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/20.
 */
class BiMapTest extends Specification {

    def "BiMap双向绑定"() {
        given:
        BiMap weekNameMap = HashBiMap.create()
        weekNameMap.put("星期一", "Monday");
        weekNameMap.put("星期二", "Tuesday");
        weekNameMap.put("星期三", "Wednesday");
        weekNameMap.put("星期四", "Thursday");
        weekNameMap.put("星期五", "Friday");
        weekNameMap.put("星期六", "Saturday");
        weekNameMap.put("星期日", "Sunday")

        println weekNameMap.get("星期一") // Monday
        println weekNameMap.inverse().get("Monday") //星期一
    }
}




