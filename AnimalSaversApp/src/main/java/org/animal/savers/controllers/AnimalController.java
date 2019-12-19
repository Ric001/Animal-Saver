package org.animal.savers.controllers;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.animal.savers.models.Animal;
import org.animal.savers.services.AnimalMapper;
import org.apache.ibatis.session.SqlSession;

public class AnimalController implements AnimalMapper {

    private  SqlSession dbAccessor;
    private final static Logger LOG = Logger.getLogger(AnimalController.class.getName());

    public AnimalController(SqlSession dbSession) {
        this.dbAccessor = dbSession;
    }

    @Override
    public List<Animal> toListPets() {
        LOG.info("[ENTERING List<Animal> toListPets()]");

        final List<Animal> pets = dbAccessor.getMapper(AnimalMapper.class).toListPets();

        LOG.info(String.format("[RETURING FROM List<Animal> toListPets(): %s]", pets));
        return pets;
    }

    @Override
    public Animal getAnimalById(Integer id) {
        LOG.info("[ENTERING Animal getAnimalById(Integer id)]");
        if (Objects.isNull(id))
            return null;

        final Animal animal = dbAccessor.getMapper(AnimalMapper.class).getAnimalById(id);

        LOG.info(String.format("[RETURNING FROM Animal getAnimalById(Integer id): %s]", animal));
        return animal;

    }

    @Override
    public void addAnimal(Animal animal) {
        LOG.info("[ADDING %s To The PET Entity]");
        if (Objects.nonNull(animal))
            dbAccessor.getMapper(AnimalMapper.class).addAnimal(animal);
    }

    @Override
    public void editAnimal(Animal animal) {
        LOG.info("[EDITING %s animal]");
        dbAccessor.getMapper(AnimalMapper.class).editAnimal(animal);
    }

    @Override
    public void deleteAnimal(Integer animal) {
        LOG.info("[DELETING %s animal]");
        dbAccessor.getMapper(AnimalMapper.class).deleteAnimal(animal);
    }

}