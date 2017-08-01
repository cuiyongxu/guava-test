package com.google.common.collect

import com.google.common.base.Splitter
import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/20.
 */
class MultisetTest extends Specification {


    def "计数器"() {
        given:
        Multiset multiset = HashMultiset.create();
        String context = " 假如生活欺骗了你， 不要悲伤，不要心急！ 忧郁的日子里须要镇静： 相信吧，快乐的日子将会来临！ 心儿永远向往着未来； 现在却常是忧郁。 一切都是瞬息，一切都将（会）过去； 而那过去了的，就会成为亲切的怀恋。";
        Iterable<String> words = Splitter.onPattern("[\\u4e00-\\u9fa5]").omitEmptyStrings().trimResults().split(context);//匹配中文标点符号
        for (String word : words) {
            multiset.add(word);
        }

        multiset.elementSet().forEach({
            k ->
                k;
                println k + ":" + multiset.count(k)
        })

        /*

        ！:2
        。:2
        （:1
        ）:1
        ：:1
        ；:2
        ，:5

         */
    }
}
