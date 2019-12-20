package org.animal.savers;

import java.time.LocalDate;
import java.util.List;

import org.animal.savers.controllers.AnimalController;
import org.animal.savers.models.Animal;
import org.animal.savers.services.SqlSessionManager;
import org.apache.ibatis.session.SqlSession;

public class App {
    public static void main(String[] args) {
        final String route = "mybatis-config.xml";
        final SqlSession session = SqlSessionManager.manager().openSession(route);
        final AnimalController controller = new AnimalController(session);
        final Animal animal = new Animal("golden", "Rowan", "fish","m", LocalDate.now());
        new App().runTests(controller, animal);
        session.close();
        System.exit(0);
    }    

    private void runTests(AnimalController controller, Animal animal) {
        toListPets(controller);
        addAnimals(controller, animal);
        getAnimalById(controller, 13);
        animal.setName("Pick");
        animal.setAnimalId(13);
        updateAnimal(controller, animal);
        getAnimalById(controller, 13);
        deleteAnimal(controller,13);
        toListPets(controller);
    }

    private void toListPets(final AnimalController controller) {
        System.out.println("\n[########### LISTING ALL THE EXISTING PETS: ###########]");
        List<Animal> animals = controller.toListPets();
        System.out.println("PETS LIST: ");
        for (Animal animal : animals) 
            System.out.println(animal);
    }

    private void addAnimals(final AnimalController controller, final Animal animal) {
        System.out.println("[########### ADDING AN ANIMAL: ##########]");
        controller.addAnimal(animal);
    }

    private void updateAnimal(final AnimalController controller, final Animal animal) {
        System.out.println("[######## UPDATING AN ANIMAL: ########]");
        controller.editAnimal(animal);

    }

    private void deleteAnimal(final AnimalController controller, final Integer animal) {
        System.out.println("[######### DELETING AN ANIMAL: #######]");
        controller.deleteAnimal(animal);
    }

    private void getAnimalById(final AnimalController controller, final Integer id) {
        System.out.println("[####### GETTING ANIMAL BY ID: ########]");
        System.out.println(controller.getAnimalById(id));
    }
}
