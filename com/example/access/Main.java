package com.example.access;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Java访问控制演示 =====\n");
        
        // 创建主类实例
        AccessControlDemo demo = new AccessControlDemo();
        demo.testInternalAccess();
        
        // 创建子类实例
        System.out.println("\n===== 子类访问测试 =====");
        SubClass subDemo = new SubClass();
        subDemo.testAccess();
        
        // 在同一个包中访问
        System.out.println("\n===== 同包类访问测试 =====");
        System.out.println("可访问公有变量: " + demo.publicVar);
        System.out.println("可访问保护变量: " + demo.protectedVar);
        System.out.println("可访问默认变量: " + demo.defaultVar);
        // System.out.println(demo.privateVar); // 编译错误，不能访问私有变量
        
        demo.publicMethod();
        demo.protectedMethod();
        demo.defaultMethod();
        // demo.privateMethod(); // 编译错误，不能访问私有方法
    }
}
