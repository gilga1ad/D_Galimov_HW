import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Test {

    final String nameAnnotation;

    Test(final String nameAnnotation) {
        this.nameAnnotation = "@Class1$" + nameAnnotation + "()";
    }

    public void testAnnotations() {
        try {
            Class cl = Class.forName("Class1");

            Method[] method = cl.getMethods();
            for(Method md: method) {
                Annotation[] annotations = md.getDeclaredAnnotations();

                for(Annotation a: annotations) {
                    if (a.toString().equals(nameAnnotation)) {
                        try {
                            md.invoke(null, null);
                        } catch (IllegalAccessException | InvocationTargetException e) {}
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class is not found");
            System.exit(1);
        }



    }

}
