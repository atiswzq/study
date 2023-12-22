package com.example.demo1215.stringDemo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kywzq
 * @ClassName StringTest.java
 * @Description TODO
 * @createTime 2023年12月15日 08:40:00
 */
public class StringTest {


/*

    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘数据
        Scanner scanner = new Scanner(System.in);
        //next方式接收字符串(不可以接收空格)
        System.out.println("Next方式接收:");
        //判断用户还有没有输入字符
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println("输入内容：" + str);
        }
        // 凡是属于IO流的类如果不关闭会一直占用资源.要养成好习惯用完就关掉.
        // 就好像你接水完了要关 水龙头一样.很多下载软件或者视频软件如果你不彻底关,
        // 都会自己上传下载从而占用资源,你就会觉得 卡,这一个道理.
        //1scanner.close();


    }
*/


    public static void main(String[] args) {

        int[] a = new int[11];
        int[] b = new int[]{1,23,3};
        int[] c = {1,2,3};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        int[][] aa = {{1,3,4},{2,5,6}};
        System.out.println(Arrays.toString(aa[0]));
        System.out.println(aa[0][2]);
        System.out.println(Arrays.deepToString(aa));
    }

}
