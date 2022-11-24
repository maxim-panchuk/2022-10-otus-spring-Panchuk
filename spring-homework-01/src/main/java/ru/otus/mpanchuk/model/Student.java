package ru.otus.mpanchuk.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String surname;

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }
}