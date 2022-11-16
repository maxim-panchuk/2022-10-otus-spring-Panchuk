package ru.otus.mpanchuk.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.otus.mpanchuk.model.Notation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NotationDaoImpl implements NotationDao {

    String filepath;

    public NotationDaoImpl(String filepath) {
        this.filepath = filepath;
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
}
