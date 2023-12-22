package com.timer.demo1028.proxy.dynamicDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 动态代理学习
 * @author: wang zeq
 * @date:2021/11/3/003 9:04
 */
public class ProxyTest {


    // 动态代理要解决两个问题一个动态类的问题，另一个是动态类和加强代码的耦合问题(所谓耦合就是不能因为加强代码的调整直接要调整动态类)
    public static void main(String[] args) throws Exception {

        // 动态类利用jvm底层proxy类去创建一个动态对象，这样就不需要维护动态类，原理是反射
        /*
         * 参数1：Calculator的类加载器（当初把Calculator加载进内存的类加载器）
         * 参数2：代理对象需要和目标对象实现相同接口Calculator
         * */
      /*  Class<?> calculatorProxyClazz =Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        // 得到唯一的有参构造 $Proxy(InvocationHandler h)，和反射的Method有点像，可以理解为得到对应的构造器执行器
        Constructor constructor = calculatorProxyClazz.getConstructor(InvocationHandler.class);
        // 用构造器生成代理对象
        Calculator calculatorProxy = (Calculator) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                CalculatorImpl calculatorImpl = new CalculatorImpl();
                System.out.println(method.getName() + "方法开始执行...");
                int result = (int)method.invoke(calculatorImpl, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束...");
                return result;

            }
        });
        calculatorProxy.add(1,2);*/
        // 1.得到目标对象
        CalculatorImpl target = new CalculatorImpl();
        // 2.传入目标对象，得到增强对象（如果需要对目标对象进行别的增强，可以另外编写getXxInvocationHandler）
        InvocationHandler logInvocationHandler = getLogInvocationHandler(target);
        // 3.传入目标对象+增强代码，得到代理对象
        Calculator calculatorProxy = (Calculator) getProxy(target, logInvocationHandler);
        calculatorProxy.add(1, 2);
    }


    /**
     * 传入目标对象+增强代码，获取代理对象
     *
     * @param target
     * @param handler
     * @return
     * @throws Exception
     */
    private static Object getProxy(final Object target, final InvocationHandler handler) throws Exception {
        // 参数1：随便找个类加载器给它 参数2：需要代理的接口
        Class<?> proxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor<?> constructor = proxyClazz.getConstructor(InvocationHandler.class);
        return constructor.newInstance(handler);
    }

    /**
     * 日志增强代码
     *
     * @param target
     * @return
     */
    private static InvocationHandler getLogInvocationHandler(final CalculatorImpl target) {
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy1, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行...");
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束...");
                return result;
            }
        };
    }


}
