package ru.otus.mpanchuk.service;

import ru.otus.mpanchuk.dao.NotationDao;
import ru.otus.mpanchuk.model.Notation;

import java.util.List;

public class NotationServiceImpl implements NotationService {

    private final NotationDao dao;
    private List<Notation> list;

    public NotationServiceImpl(NotationDao dao) {
        this.dao = dao;
    }

    @Override
    public void getNotations() {
        list = dao.getAllQuestions();
    }

    @Override
    public void printNotations() {
        for (Notation item : list) {
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
