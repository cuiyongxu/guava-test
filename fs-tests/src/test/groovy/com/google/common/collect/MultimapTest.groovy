package com.google.common.collect

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/20.
 */
class MultimapTest extends Specification {


    def "Map中key对应多个value,类似Map<String,List<String>>"() {
        //使用场景:同一个目录下会包含多个文件,每个文件又有多个listener
        given:
        //ArrayListMultimap
        //HashMultimap
        //LinkedListMultimap
        //LinkedHashMultimap
        //TreeMultimap
        //ImmutableListMultimap
        //ImmutableSetMultimap
        Multimap<String, String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("channel", "6000");
        myMultimap.put("channel", "5000");
        myMultimap.put("channel", "3000");
        myMultimap.put("route", "NewB");
        myMultimap.put("route", "NewB");


        println myMultimap.size() //5
        println myMultimap //{route=[NewB, NewB], channel=[6000, 5000, 3000]}

        println myMultimap.get("channel")//[6000, 5000, 3000]
        println myMultimap.get("route")//[NewB, NewB]

        for(def value :myMultimap.values()){
            println value
            //NewB
            //NewB
            //6000
            //5000
            //3000
        }

        myMultimap.remove("route","NewB")
        println myMultimap.get("route") //[NewB]

        myMultimap.removeAll("channel");
        println myMultimap //{route=[NewB]}

    }
}
