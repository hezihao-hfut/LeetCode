package com.example.other;

import com.example.access.AccessControlDemo;
/**
 * 其他包的类，用于演示不同包中的访问控制
 */
public class OtherPackageDemo {
    
    public static void main(String[] args) {
        System.out.println("===== 不同包的访问测试 =====");
        
        // 创建AccessControlDemo实例
        AccessControlDemo demo = new AccessControlDemo();
        
        // 只能访问公有成员
        System.out.println("可访问公有变量: " + demo.publicVar);
        // System.out.println(demo.protectedVar); // 编译错误，不能访问保护变量
        // System.out.println(demo.defaultVar);   // 编译错误，不能访问默认变量
        // System.out.println(demo.privateVar);   // 编译错误，不能访问私有变量
        
        demo.publicMethod();
        // demo.protectedMethod(); // 编译错误，不能访问保护方法
        // demo.defaultMethod();   // 编译错误，不能访问默认方法
        // demo.privateMethod();   // 编译错误，不能访问私有方法
        
        System.out.println("\n===== 不同包子类访问测试 =====");
        OtherPackageSubClass subDemo = new OtherPackageSubClass();
        subDemo.testAccess();
    }
}

/**
 * 不同包中的子类
 */
class OtherPackageSubClass extends AccessControlDemo {
    
    public void testAccess() {
        System.out.println("不同包的子类可访问父类的公有变量: " + publicVar);
        System.out.println("不同包的子类可访问父类的保护变量: " + protectedVar);
        // System.out.println(defaultVar); // 编译错误，不能访问父类的默认变量
        // System.out.println(privateVar); // 编译错误，不能访问父类的私有变量
        
        publicMethod();
        protectedMethod(); // 子类可以访问父类的protected方法，即使在不同包
        // defaultMethod(); // 编译错误，不能访问父类的默认方法
        // privateMethod(); // 编译错误，不能访问父类的私有方法
    }
}
