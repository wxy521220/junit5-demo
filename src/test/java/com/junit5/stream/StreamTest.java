package com.junit5.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest {

    //根据 Collection 获取流
    @Test
    void getStreamCollection(){

        List<String> lists=new ArrayList();
        lists.add("张三");
        lists.add("李四");
        System.out.println(lists.stream());
        lists.stream().forEach(list->System.out.println(list));

        Set<String> sets=new HashSet<>();
        sets.add("王五");
        sets.add("李六");
        System.out.println(sets.stream());

    }


    //Map 获取流
    @Test
    void getStreamMap(){
        Map<String,Object> maps=new HashMap<>();
        maps.put("张三","25");
        maps.put("李四","27");
        Stream<Map.Entry<String, Object>> streams = maps.entrySet().stream();
        maps.entrySet().stream().forEach(stringObjectEntry -> System.out.println(stringObjectEntry.getValue()));
        Stream<String> streamKeys = maps.keySet().stream();
        streamKeys.forEach(streamKey->System.out.println(streamKey));
        Stream<Object> streamValues = maps.values().stream();
        streamValues.forEach(streamValue->System.out.println(streamValue));
    }


    //数组获取流
    @Test
    void getStreamArrays(){
        String[] arrays={"张三","张开","李啊四"};
        System.out.println(Stream.of(arrays));
        Stream<String> stream = Arrays.stream(arrays);
        System.out.println(stream);
        stream.filter(s->s.startsWith("张")).filter(s->s.length()==2).forEach(s->System.out.println(s));


    }


}
