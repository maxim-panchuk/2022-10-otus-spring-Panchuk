package ru.otus.mpanchuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mpanchuk.dao.NotationDao;
import ru.otus.mpanchuk.model.Student;

import java.util.Scanner;

@Service
public class TestServiceImpl implements TestService{

    private final NotationDao notationDao;
    private final NotationService notationService;
    private final Student student = new Student();

    @Autowired
    public TestServiceImpl(NotationDao dao, NotationService notationService) {
        this.notationDao = dao;
        this.notationService = notationService;
        initStudent();
    }

    private void initStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Print name: ");
        this.student.setName(sc.nextLine());
        System.out.println("Print lastname: ");
        this.student.setSurname(sc.nextLine());
    }


    @Override
    public void test() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 1; i <= notationDao.getTestSize(); i++){
            String question = notationDao.getQuestionById(i + "");
            String answers = notationDao.getAnswersById(i + "");
            if (!question.equals(" null") && !answers.equals(" null")) {
                System.out.println(question + "\n");
                String[] ans = answers.split(",");
                for (String item : ans) {
                    System.out.println("   - " + item);
                }
                String in = sc.next();
                if (notationService.isAnswerRight(i + "", in)) {
                    count++;
                }
                System.out.println("\n-------------------------------------\n");
            }
        }

        if (count < 4) System.out.println("Student " + student.getName() + " " +
                student.getSurname() + " didn't pass the test");
        else {
            System.out.println("Student " + student.getName() + " " +
                    student.getSurname() + " passed the test");
        }

    }
}