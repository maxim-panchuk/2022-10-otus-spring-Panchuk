package ru.otus.mpanchuk.dao;

import ru.otus.mpanchuk.model.Notation;

import java.util.ArrayList;
import java.util.List;

public interface NotationDao {
    List<Notation> getAllQuestions();
    ArrayList<String> getAllAnswers();
}