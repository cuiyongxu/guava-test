package com.google.common.base

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/16.
 */
class CharMatherTest extends Specification {

    def "获取字符在一个字符串中出现的次数"() {
        given:
        def a = "日子日" //查询 '日' 和 '子' 在字符串中出现的次数
        def b = "假如生活欺骗了你，\n" +
                "不要悲伤，不要心急！\n" +
                "忧郁的日 子里须要镇静：\n" +
                "相信吧，快乐的日子日将会来临！\n" +
                "心儿永远向往着未来；\n" +
                "现在却常是忧郁。\n" +
                "一切都是瞬息，一切都将会过去；\n" +
                "而那过去了的，就会成为亲切的怀恋。"
        println CharMatcher.anyOf(a).countIn(b);

    }
}
