package ru.otus.mpanchuk.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.mpanchuk.dao.NotationDaoImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тест компонента Service Impl")
public class NotationServiceImplTest {

    private NotationServiceImpl notationService;

    @InjectMocks
    private NotationDaoImpl notationDao = new NotationDaoImpl("src/main/test/ru/otus/mpanchuk/testNotation.csv"
            , "src/main/test/ru/otus/mpanchuk/testAnswer.csv");

    @BeforeEach
    void initNotation() {
        notationService = new NotationServiceImpl(notationDao);
        notationService.getNotations();
    }

    @Test
    @DisplayName("Должен правильно инициализировать ответ")
    void shouldInitAnsListProp() {
        Assertions.assertEquals(notationService.getAns().get(0), "8");
    }

    @Test
    @DisplayName("Должен правильно инициализировать вопрос")
    void shouldInitQuestionListProp() {
        Assertions.assertEquals(notationService.getList().get(0).toString(), "1) 2 * 4 =  7,8,10");
    }


}
