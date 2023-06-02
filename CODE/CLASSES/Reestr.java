package Specialization.CODE.CLASSES;

import java.util.ArrayList;
import java.util.Iterator;

import Specialization.CODE.Animal_iterator;

public class Reestr implements Iterable<Animal>{
    int max_id_animals, max_id_types, max_id_sub_types;
    ArrayList<Type> types = new ArrayList<>();
    ArrayList<Sub_type> sub_types = new ArrayList<>();
    ArrayList<Animal> animals = new ArrayList<>();
    public int getMax_id_sub_types() {
        return max_id_sub_types;
    }
    public void setMax_id_sub_types(int max_id_sub_types) {
        this.max_id_sub_types = max_id_sub_types;
    }
    public int getMax_id_types() {
        return max_id_types;
    }
    public void setMax_id_types(int max_id_types) {
        this.max_id_types = max_id_types;
    }
    public int getMax_id_animals() {
        return max_id_animals;
    }
    public void setMax_id_animals(int count) {
        this.max_id_animals = count;
    }
    public ArrayList<Type> getTypes() {
        return types;
    }
    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }
    public ArrayList<Sub_type> getSub_types() {
        return sub_types;
    }
    public void setSub_types(ArrayList<Sub_type> sub_types) {
        this.sub_types = sub_types;
    }
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    @Override
    public Iterator<Animal> iterator() {
        return new Animal_iterator(animals);
    }

    // public String get_str_sub_type_id(int sel) {
    //     String str="";
    //     int ind = get_ind_of_id(sel);
    //     for (int i = 0; i < sub_types.size(); i++) {
    //         if (sub_types.get(i).getId()==animals.get(ind).getSub_type()) {
    //             str = sub_types.get(i).getName();}}
    //     return str;}
    
    // public int get_ind_of_id(int id) {
    //     int ind = -1;
    //     for (int i = 0; i < animals.size(); i++) {
    //         if (animals.get(i).getId()==id){ind = i;}}
    //     return ind;}

    // public String get_str_type_id(int sel) {
    //     String str="";
    //     int ind = get_ind_of_id(sel);
    //     for (int i = 0; i < types.size(); i++) {
    //         for (int n = 0; n < types.get(i).getSub_types().size(); n++) {
    //             if(types.get(i).getSub_types().get(n)==animals.get(ind).getSub_type()){
    //                 str = types.get(i).getName();}}}
    //     return str;}    
    
    // public int get_int_type_id(int sel) {
    //     int int_type = 0;
    //     int ind = get_ind_of_id(sel);
    //     for (int i = 0; i < types.size(); i++) {
    //         for (int n = 0; n < types.get(i).getSub_types().size(); n++) {
    //             if(types.get(i).getSub_types().get(n)==animals.get(ind).getSub_type()){
    //                 int_type = types.get(i).getId();}}}
    //     return int_type;}

    // public String animal_short_str(int sel) {
    //     Animal animal = new Animal();
    //     String str="";
    //     String gender = "";
    //     animal = this.animals.get(get_ind_of_id(sel));
    //     if (animal.getMan()) {gender = "муж.";}
    //     else {gender = "жен.";}
    //     str = "Id : "+animal.getId()+" "+get_str_sub_type_id(sel)+
    //     "("+get_str_type_id(sel)+") "+animal.getName()+" "+animal.color+" "+
    //     animal.getBirth_month()+"."+animal.getBirth_year()+" "+gender;
    //     return str;}

    // public ArrayList<String> get_all_reestr() {
    //     ArrayList<String> list = new ArrayList<>();
    //     for (int i = 0; i < types.size(); i++) {
    //         list.add("Тип : "+types.get(i).getName());
    //         for (int n = 0; n < types.get(i).getSub_types().size(); n++) {
    //             for (int k = 0; k < animals.size(); k++) {
    //                 if(types.get(i).getSub_types().get(n)==animals.get(k).getSub_type()){
    //                     list.add(animal_short_str(animals.get(k).getId()));}
    //             } 
    //         }            
    //     }
    //     return list;}

    // public ArrayList<String> get_animal_id(int id) {
    //     ArrayList<String> list = new ArrayList<>();
    //     Animal animal = new Animal();
    //     Boolean test = false;
    //     String gender = "";
    //     for (int i = 0; i < animals.size(); i++) {
    //         if (animals.get(i).getId()==id) {test = true; animal = animals.get(i);}}
    //     if (test){
    //         if (animal.getMan()){gender = "Мужской";}
    //         else {gender = "Женский";}
    //         list.add("\nИнформация по животному ID : "+id);
    //         list.add("Тип : "+get_str_type_id(id)+" Вид : "+get_str_sub_type_id(id));            
    //         list.add("Имя : "+animal.getName()+" Цвет : "+animal.getColor());
    //         list.add("Пол : "+gender);
    //         list.add("Возраст (ММ.ГГГГ) : "+animal.getBirth_month()+"."+animal.getBirth_year());
    //         list.add("Выполняемые команды : ");
    //         if (animal.getCommands().size()>0){
    //             for (int n = 0; n < animal.getCommands().size(); n++) {
    //                 list.add("    "+(n+1)+". "+animal.getCommands().get(n));}}
    //         else {list.add("    ОТСУТСТВУЮТ");}
                
    // }
    //     else {list.add("В реестре отсутствует животное с ID : "+id);}

    //     return list;
    // }
}
