package com.example.demo0908.java8;

/**
 * @author kywzq
 * @ClassName MockStream.java
 * @Description TODO
 * @createTime 2022年09月08日 18:15:00
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author bravo
 * @date 2020-03-19 17:55
 */
public class MockStream {


    static List<Employe> list1;

    static {
        list1 = new ArrayList<>();
        list1.add(new Employe("i", 18, "杭州", 999.9, new ArrayList<>(Arrays.asList("成年人", "学生", "男性"))));
        list1.add(new Employe("am", 19, "温州", 777.7, new ArrayList<>(Arrays.asList("成年人", "打工人", "宇宙最帅"))));
        list1.add(new Employe("iron", 21, "杭州", 888.8, new ArrayList<>(Arrays.asList("喜欢打篮球", "学生"))));
        list1.add(new Employe("man", 17, "宁波", 888.8, new ArrayList<>(Arrays.asList("未成年人", "家里有矿"))));
    }


    public static void main(String[] args) throws JsonProcessingException {

        // 对比真正的Stream API
        List<Person> list = new ArrayList<>();
        list.add(new Person("李健", 46));
        list.add(new Person("周深", 48));
        list.add(new Person("周深", 48));
        list.add(new Person("张学友", 59));



/*        List<String> collect = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                .map(Person::getName)                   // 拿到他们的名字
                .collect(Collectors.toList());          // 整理成List<String>

        prettyPrint(collect);

        List<String> collect1 = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                .map(Person::getName).sorted(Comparator.comparingInt(String::length).reversed())                  // 拿到他们的名字
                .collect(Collectors.toList());          // 整理成List<String>

        prettyPrint(collect1);

        List<String> collect2 = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                .map(Person::getName).sorted((str1,str2)->str2.length()-str1.length())                  // 拿到他们的名字
                .collect(Collectors.toList());          // 整理成List<String>

        prettyPrint(collect2);

        Set<String> collect3 = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                .map(Person::getName).sorted((str1,str2)->str2.length()-str1.length())                  // 拿到他们的名字
                .collect(Collectors.toSet());          // 整理成List<String>

        Map<String,Integer> collect4 = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                // 拿到他们的名字
                .collect(Collectors.toMap(Person::getName,Person::getAge,(preKey,nextKey)->nextKey));          // 整理成List<String>
        prettyPrint(collect4);

        String collect5 = list
                .stream()                               // 真正的Stream API需要先转成stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                    .map(Person::getName)
                // 拿到他们的名字
                .collect(Collectors.joining("~"));          // 整理成List<String>
        prettyPrint(collect5);

        Optional<Integer> maxAge = list
                .stream()
                .filter(person -> person.getAge() > 40).map(Person::getAge).max(Integer::compareTo);
        prettyPrint(maxAge.orElse(0));

       long count = list
                .stream()
                .filter(person -> person.getAge() > 40).count();
        prettyPrint(count);

        List<Person> personStream = list
                .stream()
                .filter(person -> person.getAge() > 40).distinct().collect(Collectors.toList());
        prettyPrint(personStream);

        List<Person> personList = list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))), ArrayList::new)
        );
        prettyPrint(personList);

        List<Person> studentList = list.stream().filter(distinctByKey(Person::getName)).collect(Collectors.toList());*/


       /* prettyPrint(list.stream().filter(person -> person.getAge()<50).collect(Collectors.partitioningBy(person -> person.getAge()==46)));
        prettyPrint(list.stream().filter(person -> person.getAge()>50).collect(Collectors.averagingInt(Person::getAge)));*/
/*

        Set<String> allTags = list1.stream().flatMap(student -> student.getTags().stream()).collect(Collectors.toSet());
        prettyPrint(allTags);*/

        Map<Boolean, List<Person>> personList = list.stream().filter(person -> person.getAge() > 40).collect(Collectors.groupingBy(person -> person.getAge() >= 50));
        prettyPrint(personList);
        Map<Integer, Map<String, List<Person>>> personList2 = list.stream().filter(person -> person.getAge() > 40).collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(Person::getName)));
        prettyPrint(personList2);

    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
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


@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
}

@Getter
class MyList<T> {
    private List<T> list = new ArrayList<>();

    public boolean add(T t) {
        return list.add(t);
    }

    /**
     * 给MyList传递具体的判断规则，然后MyList把内部现有符合判断（true）的元素集返回
     *
     * @param predicate
     * @return
     */
    public MyList<T> filter(Predicate<T> predicate) {
        MyList<T> filteredList = new MyList<>();

        for (T t : list) {
            if (predicate.test(t)) {
                // 收集判断为true的元素
                filteredList.add(t);
            }
        }

        return filteredList;
    }

    /**
     * 把MyList中的List<T>转为List<R>
     *
     * @param mapper
     * @param <R>
     * @return
     */
    public <R> MyList<R> map(Function<T, R> mapper) {
        MyList<R> mappedList = new MyList<>();

        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }

        return mappedList;
    }

}

/**
 * 定义一个Predicate接口，名字无所谓
 *
 * @param <T>
 * <p>
 * 定义了一个test()方法，传入任意对象，返回true or false，具体判断逻辑由子类实现
 * @param t
 * @return 定义了一个test()方法，传入任意对象，返回true or false，具体判断逻辑由子类实现
 * @param t
 * @return
 */
/*
@FunctionalInterface
interface Predicate<T> {
    */
/**
 * 定义了一个test()方法，传入任意对象，返回true or false，具体判断逻辑由子类实现
 *
 * @param t
 * @return
 *//*

    boolean test(T t);
}
*/


/**
 * 定义一个Function接口，名字无所谓
 *
 * @param <E>
 * @param <R>
 */

@FunctionalInterface
interface Function<E, R> {
    /**
     * 定义一个apply()方法，接收一个E返回一个R。也就是把E映射成R
     *
     * @param e
     * @return
     */
    R apply(E e);
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employe {
    private String name;
    private Integer age;
    private String address;
    private Double salary;
    // 个人标签
    private List<String> tags;
}