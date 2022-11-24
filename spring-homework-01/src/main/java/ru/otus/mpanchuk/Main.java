package ru.otus.mpanchuk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.mpanchuk.service.NotationService;
import ru.otus.mpanchuk.service.TestServiceImpl;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Main.class);

        TestServiceImpl tsi = ctx.getBean(TestServiceImpl.class);
        tsi.test();
    }
}