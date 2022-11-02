package ru.otus.mpanchuk;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.mpanchuk.io.CsvIo;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        CsvIo csvIo = context.getBean(CsvIo.class);
        csvIo.readCsv();
        csvIo.outCsv();
    }
}
