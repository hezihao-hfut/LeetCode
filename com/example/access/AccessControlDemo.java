package com.example.access;

/**
 * Java访问控制演示类
 * 展示Java中的四种访问控制级别：
 * - public: 任何类都可访问
 * - protected: 同包类及子类可访问
 * - default (无修饰符): 只有同包类可访问
 * - private: 只有本类可访问
 */
public class AccessControlDemo {
    
    // 公有变量 - 任何类都可访问
    public String publicVar = "公有变量";
    
    // 保护变量 - 同包类及子类可访问
    protected String protectedVar = "保护变量";
    
    // 默认变量(无修饰符) - 只有同包类可访问
    String defaultVar = "默认变量";
    
    // 私有变量 - 只有本类可访问
    private String privateVar = "私有变量";
    
    // 公有方法 - 任何类都可调用
    public void publicMethod() {
        System.out.println("这是公有方法，任何类都可调用");
        // 在类内部可以访问所有变量
        System.out.println("在类内部访问变量：");
        System.out.println("- " + publicVar);
        System.out.println("- " + protectedVar);
        System.out.println("- " + defaultVar);
        System.out.println("- " + privateVar);
    }
    
    // 保护方法 - 同包类及子类可调用
    protected void protectedMethod() {
        System.out.println("这是保护方法，同包类及子类可调用");
    }
    
    // 默认方法 - 只有同包类可调用
    void defaultMethod() {
        System.out.println("这是默认方法，只有同包类可调用");
    }
    
    // 私有方法 - 只有本类可调用
    private void privateMethod() {
        System.out.println("这是私有方法，只有本类可调用");
    }
    
    // 测试内部访问
    public void testInternalAccess() {
        System.out.println("\n===== 类内部访问测试 =====");
        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod(); // 私有方法在类内部可以调用
    }
}

/**
 * 子类，用于测试继承时的访问控制
 */
class SubClass extends AccessControlDemo {
    
    public void testAccess() {
        System.out.println("子类可访问父类的公有变量: " + publicVar);
        System.out.println("子类可访问父类的保护变量: " + protectedVar);
        System.out.println("子类可访问父类的默认变量(仅在同包时): " + defaultVar);
        // System.out.println(privateVar); // 编译错误，不能访问父类的私有变量
        
        publicMethod();
        protectedMethod();
        defaultMethod(); // 仅在同包时可访问
        // privateMethod(); // 编译错误，不能访问父类的私有方法
    }
}
