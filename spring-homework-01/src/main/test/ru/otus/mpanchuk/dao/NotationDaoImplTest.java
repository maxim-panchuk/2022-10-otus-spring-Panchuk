package ru.otus.mpanchuk.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.mpanchuk.model.Notation;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тест компонента DAO Notation")
public class NotationDaoImplTest {

    @InjectMocks
    private NotationDaoImpl notationDao = new NotationDaoImpl("src/main/test/ru/otus/mpanchuk/testNotation.csv");

    private Notation notation;

    @BeforeEach
    void initNotation() {
        notation = Notation.builder().id("1").question("1 + 2 = ").answers("2,3,4").rightAns("3").build();
    }

    @Test
    @DisplayName("Должен правильно возвращать Question")
    void shouldGetQuestion() {
        String actualQ = notation.getQuestion();
        String testQ = notationDao.getQuestionById(notation.getId());
        Assertions.assertEquals(actualQ, testQ);
    }

    @Test
    @DisplayName("Должен правильно возвращать Answers")
    void shouldGetAnswers() {
        String actualA = notation.getAnswers();
        String testA = notationDao.getAnswersById(notation.getId());
        Assertions.assertEquals(actualA, testA);
    }

    @Test
    @DisplayName("Должен правильно возвращать RightAnswer")
    void shouldGetRightAnswer() {
        String actualA = notation.getRightAns();
        String testA = notationDao.getRightAnswerById(notation.getId());
        Assertions.assertEquals(actualA, testA);
    }

    @Test
    @DisplayName("Должен правильно возвращать Размер теста")
    void shouldGetSize() {
        int actualS = 1;
        int testS = notationDao.getTestSize();
        Assertions.assertEquals(actualS, testS);
    }
}