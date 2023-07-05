package com.test.demo.test;

@Deprecated
public class Usera extends User{

    /**
     * 表示当前的方法定义将覆盖父类中的方法
     */
    @Override
    public void user1(){
        System.out.println("usera");
    }


    /**
     * 表示代码被弃用，如果使用了被@Deprecated注解的代码则编译器将发出警告
     */
    @Deprecated
    public void usera1(){
        System.out.println("usera1");
    }

    /**
     * 表示关闭编译器警告信息
     */
    @SuppressWarnings("deprecation")
    public void usera2(){
        System.out.println("usera2");
    }
}
