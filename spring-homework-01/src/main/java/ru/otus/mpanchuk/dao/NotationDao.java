package ru.otus.mpanchuk.dao;

import ru.otus.mpanchuk.model.Notation;

import java.util.ArrayList;

public interface NotationDao {
    ArrayList<Notation> getAllNotations();
    String getQuestionById(String id);
    String getAnswersById(String id);
    String getRightAnswerById(String id);
    Integer getTestSize();
}