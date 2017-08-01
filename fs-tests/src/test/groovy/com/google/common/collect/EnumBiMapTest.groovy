package com.google.common.collect

import com.ijson.groovy.entity.Key
import com.ijson.groovy.entity.Value
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/20.
 */
class EnumBiMapTest extends Specification{

    def "enummap双向绑定"() {
        given:
        EnumBiMap<Key, Value> week = EnumBiMap.create(Key.class, Value.class)
        week.put(Key.Monday, Value.星期一)
        week.put(Key.Tuesday, Value.星期二)
        week.put(Key.Wednesday, Value.星期三)
        week.put(Key.Thursday, Value.星期四)
        week.put(Key.Friday, Value.星期五)
        week.put(Key.Saturday, Value.星期六)
        week.put(Key.Sunday, Value.星期日)

        println week.get(Key.Saturday)
        println week.inverse().get(Value.星期五)
    }
}
