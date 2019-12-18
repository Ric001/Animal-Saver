package org.animal.savers;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface AnimalMapper {
    @Select("SELECT * FROM PET")
    List<Animal> toListPets();

    @Select("INSERT INTO PET(NAME, OWNER) VALUES (#{name}, #{owner})")
    void addAnimal(Animal animal);
}