package org.animal.savers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            final InputStream inStream = new FileInputStream(resource);
            final SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inStream);
            final SqlSession session = sessionFactory.openSession();
            AnimalMapper animalMapper = session.getMapper(AnimalMapper.class);
            Animal animalI = new Animal();
            animalI.setName("Morly");
            animalMapper.addAnimal(animalI);
            session.commit();
            List<Animal> animals = session.getMapper(AnimalMapper.class).toListPets();
            session.close();
            System.out.println();
            printAnimals(animals);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals)
            System.out.println(animal);
    }
}
