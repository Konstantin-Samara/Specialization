package Specialization.CODE;

import java.util.ArrayList;
import java.util.Iterator;

import Specialization.CODE.CLASSES.Animal;

public class Animal_iterator implements Iterator<Animal>{
    private ArrayList<Animal> animals;
    private int id;

    public Animal_iterator(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public boolean hasNext() {
        return id<animals.size();
    }

    @Override
    public Animal next() {
        return animals.get(id++);
    }
    
}
