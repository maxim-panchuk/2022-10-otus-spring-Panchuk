package ru.otus.mpanchuk;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.mpanchuk.service.NotationService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        NotationService ns = context.getBean(NotationService.class);
        ns.getNotations();
        ns.printNotations();
    }
}
