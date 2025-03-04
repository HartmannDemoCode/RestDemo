package dk.hartmanndemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Purpose:
 *
 * @author: Thomas Hartmann
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDTO{
    int id;
    String name;
    String breed;
    char gender;
    int age;
    public DogDTO(String name, String breed, char gender, int age){
        this.name = name;
        this. breed = breed;
        this.gender = gender;
        this.age = age;
    }
}
