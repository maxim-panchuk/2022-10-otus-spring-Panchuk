package ru.otus.mpanchuk.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.mpanchuk.model.Notation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@PropertySource("classpath:property.properties")
@Component
public class NotationDaoImpl implements NotationDao {

    private final String filepath;
    private final String ansFilepath;

    public NotationDaoImpl(@Value("${file.csvpath}") String filepath,
                           @Value("${file.anspath}") String ansFilepath) {
        this.filepath = filepath;
        this.ansFilepath = ansFilepath;
    }

    @Override
    public List<Notation> getAllQuestions() {
        List<Notation> list = new ArrayList<>();
        try {
            List<Notation> refs = new CsvToBeanBuilder(new FileReader(filepath))
                    .withType(Notation.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            list.addAll(refs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public ArrayList<String> getAllAnswers() {

        ArrayList<String> list = new ArrayList<>();

        try {
            FileReader fr = new FileReader(ansFilepath);
            Scanner scanner = new Scanner(fr);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");
                list.add(line[1]);
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}