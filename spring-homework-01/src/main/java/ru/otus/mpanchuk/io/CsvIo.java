package ru.otus.mpanchuk.io;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Getter;
import ru.otus.mpanchuk.model.Answer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class CsvIo {

    private final List<Answer> list = new ArrayList<>();
    private final String filePath;

    public CsvIo(String filePath) {
        this.filePath = filePath;
    }

    public void readCsv() {
        try {

            List<Answer> refs = new CsvToBeanBuilder(new FileReader(filePath))
                    .withType(Answer.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            list.addAll(refs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void outCsv() {
        for (Answer item : list) {
            if (!item.toString().equals(" null")) {
                System.out.println(item.getQuestion());
                String[] answers = item.getAnswers().split(",");
                for (String ans : answers) {
                    System.out.println("   - " + ans);
                }
                System.out.println("\n-------------------------------------\n");
            }

        }
    }
}
