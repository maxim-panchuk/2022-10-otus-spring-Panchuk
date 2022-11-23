package ru.otus.mpanchuk.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mpanchuk.dao.NotationDao;
import ru.otus.mpanchuk.model.Notation;

import java.util.List;
import java.util.Scanner;

@Service
@Getter
public class NotationServiceImpl implements NotationService {

    private final NotationDao dao;
    private List<Notation> list;
    private List<String> ans;

    @Autowired
    public NotationServiceImpl(NotationDao dao) {
        this.dao = dao;
    }

    @Override
    public void getNotations() {
        list = dao.getAllQuestions();
        ans = dao.getAllAnswers();
    }

    @Override
    public boolean test() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Notation item = list.get(i);
            if (!item.toString().equals(" null")) {
                System.out.println(item.getQuestion() + "\n");
                String[] answers = item.getAnswers().split(",");
                for (String ans : answers) {
                    System.out.println("   - " + ans);
                }
                String in = sc.next();
                if (in.equals(ans.get(i))) {
                    count++;
                }
                System.out.println("\n-------------------------------------\n");
            }
        }

        if (count < 4) System.out.println("Test isn't passed");
        else {
            System.out.println("Test successfully passed");
            return true;
        }
        return false;
    }
}