package org.animal.savers.services;

import java.util.List;

import org.animal.savers.models.Animal;

public interface AnimalMapper {
   
    List<Animal> toListPets();

    Animal getAnimalById(Integer id);

    void addAnimal(Animal animal);
    
    void editAnimal(Animal animal);
    
    void deleteAnimal(Integer animal);

}