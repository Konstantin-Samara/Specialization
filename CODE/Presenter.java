package Specialization.CODE;

import java.util.ArrayList;

import Specialization.CODE.CLASSES.Animal;
import Specialization.CODE.CLASSES.Reestr;
import Specialization.CODE.CLASSES.Sub_type;
import Specialization.CODE.CLASSES.Type;

public class Presenter {
    View view = new View(this);
    public Reestr reestr = new Reestr();
    Models models = new Models(reestr);


    public void PressButton() {
        ArrayList<Type> types = new ArrayList<>();
        ArrayList<Sub_type> sub_types = new ArrayList<>();

                {Type type = new Type();

                Sub_type sub_type = new Sub_type();
                ArrayList<Integer> sub_types_int = new ArrayList<>();
                ArrayList<Integer> sub_types_int1 = new ArrayList<>();


                for (int index = 0; index < 3; index++) {sub_types_int.add(index+1);}
                type.setId(1); type.setName("Домашнее");type.setSub_types(sub_types_int);
                types.add(type);
                type = new Type();

                for (int index = 3; index < 6; index++) {sub_types_int1.add(index+1);}
                type.setId(2); type.setName("Вьючное");type.setSub_types(sub_types_int1);
                types.add(type);

                sub_type.setId(1);sub_type.setName("Хомяк");
                sub_types.add(sub_type);
                sub_type = new Sub_type();


                sub_type.setId(2);sub_type.setName("Кошка");
                sub_types.add(sub_type);
                sub_type = new Sub_type();

                sub_type.setId(3);sub_type.setName("Собака");
                sub_types.add(sub_type); 
                sub_type = new Sub_type();
            
                sub_type.setId(4);sub_type.setName("Лошадь");
                sub_types.add(sub_type);  
                sub_type = new Sub_type();
            
                sub_type.setId(5);sub_type.setName("Верблюд");
                sub_types.add(sub_type);  
                sub_type = new Sub_type();
            
                sub_type.setId(6);sub_type.setName("Осел");
                sub_types.add(sub_type);}

                Animal animal = new Animal();
                animal.setId(1);
                animal.setName("Хома");
                animal.setBirth_month(5);
                animal.setBirth_year(1995);
                animal.setColor("белый");
                animal.setSub_type(1);
                animal.setMan(false);
                reestr.getAnimals().add(animal);


                animal = new Animal();
                animal.setId(3);
                animal.setName("Саддам");
                animal.setBirth_month(7);
                animal.setBirth_year(2010);
                animal.setColor("коричневый");
                animal.setSub_type(5);
                animal.setMan(true);
                reestr.getAnimals().add(animal);

        reestr.setMax_id_animals(3);
        reestr.setTypes(types);
        reestr.setSub_types(sub_types);
        reestr.setMax_id_sub_types(6);
        reestr.setMax_id_types(2);
        view.main_menu();
    }

    public void read() {
        System.out.println("\nread-read");
    }

    public void write() {
        System.out.println("\nwrite-write");

    }

    public ArrayList<String> get_all_reestr() {
        return models.get_all_reestr();

    }

    public void close() {
        System.out.println("\nДо встречи!");

    }

    public void add_animal(ArrayList<String> list1) {

    }

    public void del_animal() {
        System.out.println("\nУдалить животное.");

    }

    public ArrayList<String> get_animal_id(int id) {
        return models.get_animal_id(id);

    }
    
}
