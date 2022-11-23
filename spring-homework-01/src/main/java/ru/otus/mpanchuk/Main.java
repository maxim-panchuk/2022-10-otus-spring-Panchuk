package ru.otus.mpanchuk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.mpanchuk.service.NotationService;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Main.class);

        NotationService ns = ctx.getBean(NotationService.class);
        ns.getNotations();
        ns.test();
    }
}
