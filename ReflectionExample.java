import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier; // 用于获取修饰符信息
import java.lang.reflect.InvocationTargetException; // 调用方法可能抛出的异常

// 这是一个用于演示反射的简单类
class MyReflectionClass {
    // 公有字段
    public String publicField = "这是一个公有字段";

    // 私有字段
    private int privateField = 123;

    // 公有构造器
    public MyReflectionClass() {
        System.out.println("MyReflectionClass: 无参构造器被调用");
    }

    // 带有参数的公有构造器
    public MyReflectionClass(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
        System.out.println("MyReflectionClass: 带参构造器被调用，字段已初始化");
    }

    // 公有方法
    public void publicMethod(String param) {
        System.out.println("MyReflectionClass: 公有方法 publicMethod 被调用，参数是: " + param);
    }

    // 私有方法
    private String privateMethod(int value) {
        System.out.println("MyReflectionClass: 私有方法 privateMethod 被调用，值为: " + value);
        return "私有方法的返回值是: " + (privateField + value);
    }

    // toString 方法，方便打印对象状态
    @Override
    public String toString() {
        return "MyReflectionClass{" +
               "publicField='" + publicField + '\'' +
               ", privateField=" + privateField +
               '}';
    }
}

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // 1. 获取 Class 对象
            // 有三种常见方式获取 Class 对象：
            // Class<?> clazz1 = MyReflectionClass.class; // 最常用，静态获取
            // MyReflectionClass obj = new MyReflectionClass();
            // Class<?> clazz2 = obj.getClass(); // 通过对象实例获取

            // 通过类的完整名称动态加载类（常用在框架或需要动态加载的场景）
            String className = "MyReflectionClass";
            Class<?> clazz = Class.forName(className);
            System.out.println("成功获取 Class 对象：" + clazz.getName());
            System.out.println("====================");


            // 2. 通过反射创建对象
            System.out.println("--- 通过反射创建对象 ---");
            // 获取无参构造器
            Constructor<?> defaultConstructor = clazz.getConstructor(); // 获取 public 无参构造器
            MyReflectionClass obj1 = (MyReflectionClass) defaultConstructor.newInstance();
            System.out.println("创建对象 obj1: " + obj1);

            // 获取带参构造器
            Constructor<?> parameterizedConstructor = clazz.getConstructor(String.class, int.class); // 获取 public 带参构造器
            MyReflectionClass obj2 = (MyReflectionClass) parameterizedConstructor.newInstance("反射创建的字段值", 999);
            System.out.println("创建对象 obj2: " + obj2);
            System.out.println("====================");


            // 3. 通过反射访问字段
            System.out.println("--- 通过反射访问字段 ---");
            // 访问公有字段
            Field publicField = clazz.getField("publicField"); // 获取 public 字段
            System.out.println("字段名: " + publicField.getName() + ", 类型: " + publicField.getType().getName());
            System.out.println("obj2 中 publicField 的当前值: " + publicField.get(obj2)); // 获取 obj2 实例上的该字段值
            publicField.set(obj2, "通过反射修改的值"); // 修改 obj2 实例上的该字段值
            System.out.println("修改后 obj2: " + obj2);

            // 访问私有字段
            Field privateField = clazz.getDeclaredField("privateField"); // 获取 private 字段 (注意使用 getDeclaredField)
            System.out.println("字段名: " + privateField.getName() + ", 类型: " + privateField.getType().getName());

            // 对于私有字段，需要设置可访问性才能读取或修改
            privateField.setAccessible(true);
            System.out.println("obj2 中 privateField 的当前值 (通过反射访问私有): " + privateField.get(obj2));
            privateField.set(obj2, 777); // 修改私有字段值
            System.out.println("修改后 obj2 (私有字段被修改): " + obj2);
            privateField.setAccessible(false); // 使用完毕后恢复默认访问级别 (好习惯)
            System.out.println("====================");


            // 4. 通过反射调用方法
            System.out.println("--- 通过反射调用方法 ---");
            // 调用公有方法
            Method publicMethod = clazz.getMethod("publicMethod", String.class); // 获取 public 方法及其参数类型
            publicMethod.invoke(obj1, "传递给公有方法的参数"); // 在 obj1 实例上调用该方法，并传递参数

            // 调用私有方法
            Method privateMethod = clazz.getDeclaredMethod("privateMethod", int.class); // 获取 private 方法 (getDeclaredMethod)
            // 对于私有方法，同样需要设置可访问性
            privateMethod.setAccessible(true);
            String result = (String) privateMethod.invoke(obj2, 50); // 在 obj2 实例上调用私有方法
            System.out.println("私有方法的返回值是: " + result);
            privateMethod.setAccessible(false); // 使用完毕后恢复默认访问级别
            System.out.println("====================");

            // 5. 获取其他类信息 (例如修饰符)
            System.out.println("--- 获取其他类信息 ---");
            int modifiers = clazz.getModifiers();
            System.out.println("类的修饰符整数值: " + modifiers);
            System.out.println("类是 public 的吗? " + Modifier.isPublic(modifiers));
            System.out.println("类是 abstract 的吗? " + Modifier.isAbstract(modifiers));
            System.out.println("publicField 是 public 的吗? " + publicField.getModifiers());
            System.out.println("privateMethod 是 private 的吗? " + privateMethod.getModifiers());


        } catch (ClassNotFoundException e) {
            System.err.println("错误：找不到指定的类！" + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.err.println("错误：找不到指定的方法或构造器！" + e.getMessage());
        } catch (NoSuchFieldException e) {
            System.err.println("错误：找不到指定的字段！" + e.getMessage());
        } catch (InstantiationException e) {
            System.err.println("错误：无法实例化类！" + e.getMessage()); // 例如，类是抽象类或接口
        } catch (IllegalAccessException e) {
            System.err.println("错误：没有访问权限！" + e.getMessage()); // 通常是因为没有 setAccessible(true)
        } catch (InvocationTargetException e) {
             // 如果被调用的方法内部抛出了异常，InvocationTargetException 会包装它
            System.err.println("错误：被调用的方法内部抛出了异常！具体异常是: " + e.getTargetException().getMessage());
            // e.getTargetException().printStackTrace(); // 打印原始异常堆栈
        } catch (Exception e) {
            System.err.println("发生了一个未知错误: " + e.getMessage());
            e.printStackTrace(); // 打印堆栈跟踪以便调试
        }
    }
}
