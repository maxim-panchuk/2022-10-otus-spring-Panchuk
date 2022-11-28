package ru.otus.mpanchuk.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.otus.mpanchuk.model.Notation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final String filepath;

    public Parser(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Notation> parseNotations() {
        ArrayList<Notation> list = new ArrayList<>();
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