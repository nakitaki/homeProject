package e10_Reflection.ex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.sql.SQLOutput;
import java.sql.Struct;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("e10_Reflection.ex1.Person");

            Constructor<?>[] constructors = c.getConstructors(); //will return an array of constructors
            System.out.println("Constructors: " + Arrays.toString(constructors));

            Constructor<?> constructorDefault = c.getConstructor();
            Constructor<?> constructorAllArgs = c.getConstructor(String.class, int.class);

            try {
                Person person = (Person) constructorAllArgs.newInstance("Ivan", 25);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            Method[] methods = c.getMethods();
            System.out.println("Methods: " + Arrays.toString(methods));

            Method[] declaredMethods = c.getDeclaredMethods();
            System.out.println("Methods: " + Arrays.toString(declaredMethods));

            Field[] declaredFields = c.getDeclaredFields();
            System.out.println("Fields: " + Arrays.toString(declaredFields));

            System.out.println("Class name: " + c.getName());
            System.out.println("Class simple name: " + c.getSimpleName());

            Class<?> studentClass = Class.forName("e10_Reflection.ex1.Student");

            System.out.println("Super class name: " + studentClass.getSuperclass());

            System.out.println("Interfaces names: " + Arrays.toString(studentClass.getInterfaces()));

            System.out.println("Modifiers: " + Modifier.toString(studentClass.getModifiers()));

            System.out.println("Fields: " + Arrays.toString(studentClass.getFields()));
            System.out.println("Declared fields: " + Arrays.toString(studentClass.getDeclaredFields()));

            System.out.println("Constructors " + Arrays.toString(studentClass.getConstructors()));
            System.out.println("Declared constructors: " + Arrays.toString(studentClass.getDeclaredConstructors()));

            Annotation[] annotations = studentClass.getAnnotations();
            System.out.println("Annotations: " + Arrays.toString(annotations));

            Annotation[] declaredAnnotations = studentClass.getDeclaredAnnotations();
            System.out.println("Declared annotations: " + Arrays.toString(declaredAnnotations));

            Method method = studentClass.getDeclaredMethod("privateMessage");

            method.setAccessible(true);

            Student student = new Student();

            System.out.println("Private method without parameters: " + method.invoke(student));

            method = studentClass.getDeclaredMethod("privateMessageWithParam", String.class);
            method.setAccessible(true);

            System.out.println("Private method with parameters: " + method.invoke(new Student(),"This is private message passed as parameter!"));

            Field field = studentClass.getDeclaredField("fNumber");
            field.setAccessible(true);
            Student testStrudent = new Student("Ivan", 20, "F12345");
            System.out.println("Getting private field: " + field.get(testStrudent));
            field.set(testStrudent,"F99999");
            System.out.println("Modified private field: " + field.get(testStrudent));


        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
