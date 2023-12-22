package com.example.demo1215.DesignDemo.chain;

/**
 * @author kywzq
 * @ClassName AbstractLoginHandler.java
 * @Description TODO
 * @createTime 2023年12月21日 13:31:00
 */
public abstract  class AbstractLoginHandler<T> {
    /**
     * 责任链，下一个链接节点
     */
    protected AbstractLoginHandler<T> next = null;
    /**
     * 内部逻辑
     * @param loginDTO 登录DTO
     */
    public abstract String doHandler(LoginDTO loginDTO) throws Exception;

    public void next(AbstractLoginHandler handler) {
        this.next = handler;
    }
    public static class Builder<T> {
        private AbstractLoginHandler<T> head;
        private AbstractLoginHandler<T> tail;

        public Builder<T> addHandler(AbstractLoginHandler handler) {
            if (this.head == null) {
                this.head = handler;
                this.tail = handler;
            } else {
                this.tail.next(handler);
                this.tail = handler;
            }
            return this;
        }

        public AbstractLoginHandler build() {
            return this.head;
        }
    }

    /*
    * 总结：责任链模式适用于需要执行多个步骤，且这些步骤没有一定的先后顺序时
    * 实现步骤：
    *   1.定义一个链式抽象类，里面定义添加链式对象的方法，以及一个抽象的功能类方法
    *   2.创建对象继承该抽象类，具体实现功能类方法（原则：每个对象只负责单一功能）
    *   3.调用方定义链式抽象类对象，把相关要实现的功能类作为参数传递到链式对象中
    *
    * */
}
