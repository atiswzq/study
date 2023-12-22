package com.example.demo0908.java8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Maps;

import java.util.*;
import java.util.function.Function;

/**
 * @author kywzq
 * @ClassName LambadaTest.java
 * @Description TODO
 * @createTime 2022年09月08日 17:12:00
 */
public class LambadaTest {
    static List<Person> persionList;
    static int a;

    static {
        persionList = new ArrayList<>();
        persionList.add(new Person("wzq", 18));
        persionList.add(new Person("wzq2", 18));
        persionList.add(new Person("wzq3", 19));


    }


    public static void main(String[] args) throws JsonProcessingException {
    /*    MyList<Person> personMyList = new MyList<>();
        personMyList.add(new Person("李健", 46));
        personMyList.add(new Person("周深", 28));
        personMyList.add(new Person("张学友", 59));

        // 需求：过滤出年龄大于40的歌手的名字
        MyList<String> result = personMyList.filter(person -> person.getAge() > 40).map(Person::getName);
        prettyPrint(result.getList());

        System.out.println("\n---------------------------------------------\n");

        // 对比真正的Stream API
        List<Person> list = new ArrayList<>();
        list.add(new Person("李健", 46));
        list.add(new Person("周深", 28));
        list.add(new Person("张学友", 59));

        List<String> collect = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                .map(Person::getName)                   // 拿到他们的名字
                .collect(Collectors.toList());          // 整理成List<String>

        prettyPrint(collect);*/

      /*  Predicate<Person> predicate = person -> {
            if(person.getAge() == 18) {
                return true;

            }
            return false;
        };
        ArrayList<Person> persionList = new ArrayList<>();
        persionList.add(new Person("wzq",18));
        persionList.add(new Person("wzq2",18));
        persionList.add(new Person("wzq3",19));

        List groupList = new ArrayList();
        groupList = foreachIfNonNull(persionList,groupList,predicate);
        prettyPrint(groupList);*/


        prettyPrint(groupingBy(persionList, person -> person.getAge()));

    }


    /**
     * groupBy分组，比如 List(User)，分组后变成Map(age, List(user))
     *
     * @param originList   需要分组的List
     * @param keyExtractor 分组规则（key）
     * @return
     */
    public static <T, K> Map<K, List<T>> groupingBy(List<T> originList, Function<T, K> keyExtractor) {
        return groupingBy(originList, keyExtractor, v -> v);
    }

    /**
     * groupBy分组，比如 List(User)，分组后变成Map(age, List(username))
     *
     * @param originList     需要分组的List
     * @param keyExtractor   分组规则（key）
     * @param valueExtractor 分组List值的抽取规则
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K, V> Map<K, List<V>> groupingBy(List<T> originList, Function<T, K> keyExtractor, Function<T, V> valueExtractor) {
        if (originList == null || originList.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<K, List<V>> map = new HashMap<>(originList.size());
        for (T element : originList) {
            K key = keyExtractor.apply(element);
            if (key == null) {
                continue;
            }

            List<V> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(valueExtractor.apply(element));
        }

        return map;
    }


    private String eat() {
        // System.out.println("我要吃烧烤");
        return "我要吃烧烤";
    }

    private void test() {
        new MyThread(() -> {
            System.out.println("不用买票");
            System.out.println("骑电瓶车..." + this.eat());
        }).start();
    }

    private void test1() {
        // 构造一个匿名内部类对象
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("xxx" + this);
            }
        };
        new Thread(r).start();
    }

    /**
     * 按JSON格式输出
     *
     * @param obj
     * @throws JsonProcessingException
     */
    private static void prettyPrint(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(s);
    }
}





