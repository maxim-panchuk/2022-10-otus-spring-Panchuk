package ru.otus.mpanchuk.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notation {

    @CsvBindByPosition(position =  0)
    private String id;

    @CsvBindByPosition(position =  1)
    private String question;

    @CsvBindByPosition(position =  2)
    private String answers;

    @CsvBindByPosition(position = 3)
    private String rightAns;

    @Override
    public String toString() {
        return question + " " + answers;
    }
}