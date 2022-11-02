package ru.otus.mpanchuk.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @CsvBindByPosition(position =  0)
    private String question;

    @CsvBindByPosition(position =  1)
    private String answers;

    @Override
    public String toString() {
        return question + " " + answers;
    }
}
