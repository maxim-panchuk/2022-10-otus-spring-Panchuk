package ru.otus.mpanchuk.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.mpanchuk.model.Notation;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тест компонента DAO Notation")
public class NotationDaoImplTest {

    @InjectMocks
    private NotationDaoImpl notationDao = new NotationDaoImpl("src/main/test/ru/otus/mpanchuk/testNotation.csv"
            , "src/main/test/ru/otus/mpanchuk/testAnswer.csv");

    private Notation notation;

    @BeforeEach
    void initNotation() {
        notation = Notation.builder().question("1) 2 * 4 = ").answers("7,8,10").build();
    }

    @Test
    @DisplayName("Должен правильно парсить Notation")
    void shouldParseQuestion() {
        List<Notation> list = notationDao.getAllQuestions();
        Assertions.assertEquals(notation.toString(), list.get(0).toString());
    }

    @Test
    @DisplayName("Должен правильно парсить ответ")
    void shouldParseAnswer() {
        ArrayList<String> list = notationDao.getAllAnswers();
        Assertions.assertEquals(list.get(0), "8");
    }
}
