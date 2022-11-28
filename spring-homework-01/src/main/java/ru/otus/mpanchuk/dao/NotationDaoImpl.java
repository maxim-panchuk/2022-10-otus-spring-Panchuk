package ru.otus.mpanchuk.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.mpanchuk.model.Notation;
import ru.otus.mpanchuk.utils.Parser;
import java.util.ArrayList;

@PropertySource("classpath:property.properties")
@Component
public class NotationDaoImpl implements NotationDao {

    private final ArrayList<Notation> notationList;

    public NotationDaoImpl(@Value("${file.csvpath}") String filepath) {
        Parser parser = new Parser(filepath);
        this.notationList = parser.parseNotations();
    }

    @Override
    public ArrayList<Notation> getAllNotations() {
        return this.notationList;
    }

    @Override
    public String getQuestionById(String id) {
        for (Notation item : notationList) {
            if (id.equals(item.getId())) return item.getQuestion();
        }
        return null;
    }

    @Override
    public String getAnswersById(String id) {
        for (Notation item : notationList) {
            if (id.equals(item.getId())) return item.getAnswers();
        }
        return null;
    }

    @Override
    public String getRightAnswerById(String id) {
        for (Notation item : notationList) {
            if (id.equals(item.getId())) return item.getRightAns();
        }
        return null;
    }

    @Override
    public Integer getTestSize() {
        return this.notationList.size();
    }
}