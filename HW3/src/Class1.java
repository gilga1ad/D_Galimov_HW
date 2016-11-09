import java.lang.annotation.*;

public class Class1 {

    @Annotation1
    public static void method1() {
        System.out.println("method1");
    }

    @Annotation1
    public static void method11() {
        System.out.println("method11");
    }

    @Annotation2
    public static void method2() {
        System.out.println("method2");
    }

    @Annotation3
    public static void method3() {
        System.out.println("method3");
    }

    @Annotation3
    public static void method33() {
        System.out.println("method33");
    }

    @Annotation4
    public static void method4() {
        System.out.println("method4");
    }

    @Annotation5
    public static void method5() {
        System.out.println("method5");
    }

    @Annotation5
    public static void method55() {
        System.out.println("method55");
    }

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface Annotation1 {
    }

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface Annotation2 {
    }

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface Annotation3 {
    }

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface Annotation4{
    }

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface Annotation5 {
    }

}
