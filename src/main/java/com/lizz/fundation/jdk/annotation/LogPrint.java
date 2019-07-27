package com.lizz.fundation.jdk.annotation;

import java.lang.annotation.*;

/**
 * LogPrint
 * java.lang.annotation提供了四种元注解，专门注解其他的注解（在自定义注解的时候，需要使用到元注解）：
 *
 *  @Target –注解用于什么地方，默认值为任何元素，表示该注解用于什么地方。可用的ElementType指定参数
 *  ● ElementType.CONSTRUCTOR:用于描述构造器
 *  ● ElementType.FIELD:成员变量、对象、属性（包括enum实例）
 *  ● ElementType.LOCAL_VARIABLE:用于描述局部变量
 *  ● ElementType.METHOD:用于描述方法
 *  ● ElementType.PACKAGE:用于描述包
 *  ● ElementType.PARAMETER:用于描述参数
 *  ● ElementType.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 *
 *
 *  @Retention –什么时候使用该注解，即注解的生命周期，使用RetentionPolicy来指定
 *  RetentionPolicy.SOURCE : 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。
 *  RetentionPolicy.CLASS : 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式
 *  RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。
 *
 *
 * @Documented –注解是否将包含在JavaDoc中

 * @Inherited– 是否允许子类继承该注解
 * @Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。
 * 如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
 *
 * @author lizz365
 * @date 19/7/16
 */
public class LogPrint {

    /**
     * 自定义注解类编写的一些规则:
     * 1. Annotation型定义为@interface, 所有的Annotation会自动继承java.lang.Annotation这一接口,并且不能再去继承别的类或是接口.
     * 2. 参数成员只能用public或默认(default)这两个访问权修饰
     * 3. 参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和String、Enum、Class、annotations等数据类型,以及这一些类型的数组.
     * 4. 要获取类方法和字段的注解信息，必须通过Java的反射技术来获取 Annotation对象,因为你除此之外没有别的获取注解对象的方法
     * 5. 注解也可以没有定义成员
     * PS:自定义注解需要使用到元注解
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogPrintInMethod{
        String value() default "lizzlog";
    }

    static class Log{
        @LogPrintInMethod("log365")
        private String val;

        public String getVal() {
            return val;
        }
    }


    public static void main(String[] args) {
        Log log = new Log();
        System.out.println(log.getVal());
    }
}
