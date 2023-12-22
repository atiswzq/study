package com.example.demo0908.java8;

import com.example.demo1104.test.ConvertUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.util.Lists;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author kywzq
 * @ClassName StreamTest.java
 * @Description TODO
 * @createTime 2022年09月09日 18:23:00
 */
public class StreamTest {

    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("i", 18, "杭州", 999.9));
        list.add(new Person("am", 19, "温州", 777.7));
        list.add(new Person("iron", 21, "杭州", 888.8));
        list.add(new Person("iron", 19, "宁波", 888.8));
    }

    public static void main(String[] args) throws IOException {
       /* //获取所有的Person的名字
        List<String> nameList = list.stream().map(Person::getName).collect(Collectors.toList());
        prettyPrint(nameList);
        //获取一个List，每个元素的内容为：{name}来自{address}
        List<String> list1 = list.stream().map(person -> person.getName() + "来自"+ person.getAddress()).collect(Collectors.toList());
        prettyPrint(list1);
        //过滤出年龄大于等于18的Person
        List<Person> list2 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.toList());
        prettyPrint(list2);
        //过滤出年龄大于等于18 并且 月薪大于等于888.8 并且 来自杭州的Person
        List<Person> list3 = list.stream().filter(StreamTest::test).collect(Collectors.toList());
        prettyPrint("list3:"+list3);
        //获取年龄的min、max、sum、average、count。(降维度到age)
        Optional<Integer> age = list.stream().map(Person::getAge).min(Integer::compareTo);
        prettyPrint(age.orElse(0));
        int sum = list.stream().mapToInt(Person::getAge).sum();
        prettyPrint(sum);*/
    /*    ///查找并返回目标值，以findFirst()为代表
        boolean flag = list.stream().anyMatch(person -> person.getAge() == 18);
        prettyPrint(flag);
        // list转成list
        List<String> list4 = list.stream().filter(person -> person.getAge()>18).map(Person::getName).collect(Collectors.toList());
        prettyPrint(list4);
        // list转成linkedList
        List<Person> list5 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.toCollection(LinkedList::new));
        prettyPrint(list5);
        // list转成map
        Map<String,Integer> map = list.stream().filter(person -> person.getAge()>18).collect(Collectors.toMap(Person::getName,Person::getAge,(next,pre)->next));
        prettyPrint(map);
        // list转成map
        Map<String,Integer> map1 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.toMap(Person::getName,Person::getAge,(next,pre)->pre));
        prettyPrint(map1);
        // 如果你要对自定义的对象去重，比如Person，那么你必须重写hashCode()和equals()
        Set<String> persons = list.stream().map(Person::getName).collect(Collectors.toSet());
        prettyPrint("persons"+persons);*/
        /* // 字段分组 Collectors.mapping 映射
       Map<String,List<Integer>> map2 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.groupingBy(Person::getName,Collectors.mapping(Person::getAge,Collectors.toList())));
        prettyPrint(map2);
        // 多个字段分组
        Map<String,Map<Integer,List<Integer>>> map3 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.groupingBy(Person::getName,Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getAge,Collectors.toList()))));
        prettyPrint(map3);
        */
      /*  // 字段分组 Collectors.counting 统计
        Map<String,Long> map5 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        prettyPrint(map5);
        // 多个字段组合分组
        Map<String,List<Integer>> map6 = list.stream().filter(person -> person.getAge()>18).collect(Collectors.groupingBy(e->fetchGroupKey(e),Collectors.mapping(Person::getAge,Collectors.toList())));
        prettyPrint(map6);*/

      /*  // 排序功能 按年龄和名称升序排
        list.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        prettyPrint(list);

        // 排序功能 按年龄和名称降序排
        list.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName).reversed());
        prettyPrint(list);

        // 排序功能 按年龄和名称降序排
        list.sort(Comparator.comparingInt(Person::getAge).reversed().thenComparing(Person::getName));
        prettyPrint(list);*/

    /*    // stream截取不改变原集合，角标超过也不会报错
        List<String> list = Lists.newArrayList("a", "b", "c", "d");

        List<String> limit3 = list.stream().limit(3).collect(Collectors.toList());
        // 超出实际长度也不会报错
        List<String> limit5 = list.stream().limit(5).collect(Collectors.toList());
        List<String> range3_4 = list.stream().skip(2).limit(2).collect(Collectors.toList());
        // 超出实际长度也不会报错
        List<String> range3_5 = list.stream().skip(2).limit(3).collect(Collectors.toList());

        System.out.println(limit3 + " " + limit5 + " " + range3_4 + " " + range3_5);

        List<String> aList = Lists.newArrayList("a", "b", "c", "d");

        List<String> bList = Lists.newArrayList("aa", "b", "c", "dd");


        // 对aList去重（收集bList中没有的元素）
        aList.stream().filter(aItem -> !bList.contains(aItem)).collect(Collectors.toList());

        // bList在前
        bList.addAll(aList);

        System.out.println(bList);*/
/*
        List<String> personList = list.stream().filter(person -> person.getAge()>50).map(Person::getAddress).collect(Collectors.toCollection(LinkedList::new));
        prettyPrint(personList);*/

        /*try {
            ProcessBuilder proc = new ProcessBuilder(
                    "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
                    "http://cn.bing.com");
            proc.start();
        } catch (Exception e) {
            System.out.println("Error executing progarm.");
        }*/

        /*//url链接地址
        String localpath = "http://www.baidu.com";
        URL url = new URL(localpath);
        //根据url直接获得返回的数据
        BufferedReader breaded = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        while ( breaded.readLine() != null) {    //打印这些数据
            System.out.println(breaded.readLine());
        }

        // 获得系统类型
        String osName = System.getProperty("os.name", "");
        System.out.println(osName);
        if (osName.startsWith("Windows")) {    //如果是windows系统
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + localpath);    //打开浏览器
        }*/
        String str = "cmd /c start iexplore http://192.168.70.19:44171/?reqVersion=39489";
        try {
            Runtime.getRuntime().exec(str);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String fetchGroupKey(Person person) {
        return person.getName() + "#" + person.getAddress();
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }


    private static boolean test(Person person) {
        boolean flag = false;
        if (person.getAge() > 18 && person.getSalary() >= 888.8 && person.getAddress().equals("杭州")) {
            flag = true;
        }
        return flag;
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


    @Getter
    @Setter
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
        private String address;
        private Double salary;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }


}
