package com.example.demo1215.DesignDemo.single;

/**
 * @author kywzq
 * @ClassName DesignTest.java
 * @Description TODO
 * @createTime 2023年12月15日 09:39:00
 */
public class DesignTest {



    void eat(Animal animal){
        animal.eat();
    }

    void play(AdvancedAnimal animal){
        animal.play();
    }

    public static void main(String[] args) {
        DesignTest test = new DesignTest();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Human human = new Human();
        test.eat(dog);
        test.eat(cat);
        test.eat(human);
        test.play(human);
    }

    /*
    * 总结 当一个方法被多个对象使用时，而且后面还有可能扩展更多对象时，就可以考虑里式替换原则和依赖倒转原则，将这些对象的抽象成一个
    * 标准父类，实现一个共同方法，具体对象集成该父类，实现父类的方法
    * 方法具体定义传参为父类，实际传参传具体的实现类时就可以实现复用
    * */
}
