import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloworld1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(helloworld1.getMessage());
        HelloWorld helloworld2 =
                (HelloWorld) applicationContext.getBean("helloworld");

        Cat beanCat = (Cat) applicationContext.getBean("cat");
        Cat beanCat1 = (Cat) applicationContext.getBean("cat");

        System.out.println(helloworld1 == helloworld2);
        System.out.println(beanCat == beanCat1);

    }

}