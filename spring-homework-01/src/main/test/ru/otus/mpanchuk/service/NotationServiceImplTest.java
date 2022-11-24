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
    private NotationDaoImpl notationDao = new NotationDaoImpl("src/main/test/ru/otus/mpanchuk/testNotation.csv");

    @BeforeEach
    void initNotation() {
        notationService = new NotationServiceImpl(notationDao);
    }

    @Test
    @DisplayName("Должен правильно возвращать результат тестирования")
    void shouldPassTest() {
        String testAns = "3";
        boolean ans = notationService.isAnswerRight("1", testAns);
        boolean act = true;
        Assertions.assertEquals(ans, act);
    }

    @Test
    @DisplayName("Должен провалить тестирование")
    void shouldFallTest() {
        String testAns = "2";
        boolean ans = notationService.isAnswerRight("1", testAns);
        boolean act = false;
        Assertions.assertEquals(ans, act);
    }
}