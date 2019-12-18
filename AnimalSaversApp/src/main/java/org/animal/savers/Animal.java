package org.animal.savers;

import java.time.LocalDate;

public class Animal {

    //private int animalId;
    private String name;
    private String owner;
    private String species;
    private String sex;
    private LocalDate birth;
    private LocalDate death;

    public Animal() {
    }

    public Animal(int animalId, String name, String saver, String species, String sex, LocalDate birth,
            LocalDate death) {
        //this.animalId = animalId;
        this.name = name;
        this.owner = saver;
        this.species = species;
        this.sex = sex;
        this.birth = birth;
        this.death = death;
    }

    /*public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaver() {
        return owner;
    }

    public void setSaver(String saver) {
        this.owner = saver;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    @Override
    public String toString() {
        return "Animal [ birth=" + birth + ", death=" + death + ", name=" + name + ", saver="
                + owner + ", sex=" + sex + ", species=" + species + "]";
    }
    
}