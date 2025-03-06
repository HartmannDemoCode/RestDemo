package dk.hartmanndemo.controllers;

import dk.hartmanndemo.dtos.DogDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Purpose:
 *
 * @author: Thomas Hartmann
 */
public class DogController {

    private static List<DogDTO> dogs = new ArrayList(Arrays.asList(
            null,
            new DogDTO(1, "Fido", "Labrador", 'M', 4),
            new DogDTO(2, "Benjamin", "Danish Swedish Farm Dog", 'M', 2),
            new DogDTO(3, "Hannah", "Danish Swedish Farm Dog", 'F', 7)
    ));

    public DogDTO getById(int id) throws Exception{
        try{
            dogs.get(id);
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return dogs.get(id);
    }

    public List<DogDTO> getAll(){
        return new ArrayList(dogs);
    }

    public DogDTO setDog(int id, DogDTO dog){
        dogs.set(id, dog);
        return dog;
    }


    public DogDTO create(DogDTO dog){
        int id = dogs.size() + 1;
        dog.setId(id);
        dogs.add(dog);
        return dogs.get(id);
    }

}
