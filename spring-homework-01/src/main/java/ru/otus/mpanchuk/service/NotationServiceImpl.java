package ru.otus.mpanchuk.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mpanchuk.dao.NotationDao;

@Service
@Getter
public class NotationServiceImpl implements NotationService {

    private final NotationDao dao;

    @Autowired
    public NotationServiceImpl(NotationDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean isAnswerRight(String id, String answer) {
        return answer.equals(dao.getRightAnswerById(id));
    }
}