package com.example.demo1215.DesignDemo.io;

import java.io.*;

/**
 * @author kywzq
 * @ClassName IoTest.java
 * @Description IO流学习
 * @createTime 2023年12月20日 10:41:00
 */
public class IoTest {


    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        FileWriter out = null;
        try {
            fos = new FileOutputStream("C:\\Users\\ky\\Videos\\音频\\1.txt");
            out = new FileWriter("C:\\Users\\ky\\Videos\\音频\\2.txt");
            // 开始写。
            byte[] bytes = {97, 98, 99, 100};
            // 将byte数组全部写出！
            //fos.write(bytes); // abcd
            // 将byte数组的一部分写出！
            //fos.write(bytes, 0, 2); // 再写出ab

            // 字符串
            String s = "我是一个中国人，我骄傲！！！";
            // 将字符串转换成byte数组。
            byte[] bs = s.getBytes();
            // 写
            fos.write(bs);

            // 开始写。
            char[] chars = {'我','是','中','国','人'};
            //out.write(chars);
            out.write(chars, 2, 3);
            out.flush();


            // 可以改变标准输出流的输出方向吗？ 可以// 标准输出流不再指向控制台，指向“log”文件。
            PrintStream printStream = new PrintStream("C:\\Users\\ky\\Videos\\音频\\2.txt");
            // 修改输出方向，将输出方向修改到"log"文件。
            System.setOut(printStream);// 修改输出方向
            // 再输出
            System.out.println("hello world1");
            System.out.println("hello kitty");
            System.out.println("hello zhangsan");


            // 创建java对象
            Student s2 = new Student("wanglening",1);
            // 序列化
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ky\\Videos\\音频\\3.txt"));

            // 序列化对象
            oos.writeObject(s2);
            // 刷新
            oos.flush();
            // 关闭
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fos !=null){
                fos.close();
            }
            if(out !=null){
                out.close();
            }

        }




    }
}
