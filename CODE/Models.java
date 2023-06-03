package Specialization.CODE;

import java.util.ArrayList;

import Specialization.CODE.CLASSES.Animal;
import Specialization.CODE.CLASSES.Reestr;
import Specialization.CODE.CLASSES.Sub_type;
import Specialization.CODE.CLASSES.Type;

public class Models {
    Reestr r;

    public Models(Reestr reestr) {
        this.r = reestr;
    }

public String get_str_sub_type_id(int sel) {
    String str="";
    int ind = get_ind_of_id(sel);
    for (int i = 0; i < r.getSub_types().size(); i++) {
        if (r.getSub_types().get(i).getId()==r.getAnimals().get(ind).getSub_type()) {
            str = r.getSub_types().get(i).getName();}}
    return str;}

public int get_ind_of_id(int id) {
    int ind = -1;
    for (int i = 0; i < r.getAnimals().size(); i++) {
        if (r.getAnimals().get(i).getId()==id){ind = i;}}
    return ind;}

public String get_str_type_id(int sel) {
    String str="";
    int ind = get_ind_of_id(sel);
    for (int i = 0; i < r.getTypes().size(); i++) {
        for (int n = 0; n < r.getTypes().get(i).getSub_types().size(); n++) {
            if(r.getTypes().get(i).getSub_types().get(n)==r.getAnimals().get(ind).getSub_type()){
                str = r.getTypes().get(i).getName();}}}
    return str;} 

public int get_int_type_id(int sel) {
    int int_type = 0;
    int ind = get_ind_of_id(sel);
    for (int i = 0; i < r.getTypes().size(); i++) {
        for (int n = 0; n < r.getTypes().get(i).getSub_types().size(); n++) {
            if(r.getTypes().get(i).getSub_types().get(n)==r.getAnimals().get(ind).getSub_type()){
                int_type = r.getTypes().get(i).getId();}}}
    return int_type;}

public String animal_short_str(int sel) {
    Animal animal = new Animal();
    String str="";
    String gender = "";
    animal = r.getAnimals().get(get_ind_of_id(sel));
    if (animal.getMan()) {gender = "муж.";}
    else {gender = "жен.";}
    str = "Id : "+animal.getId()+" "+get_str_sub_type_id(sel)+
    "("+get_str_type_id(sel)+") "+animal.getName()+" "+animal.getColor()+" "+
    animal.getBirth_month()+"."+animal.getBirth_year()+" "+gender;
    return str;}

public ArrayList<String> get_all_reestr() {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < r.getTypes().size(); i++) {
        list.add("Тип : "+r.getTypes().get(i).getName());
        for (int n = 0; n < r.getTypes().get(i).getSub_types().size(); n++) {
            for (int k = 0; k < r.getAnimals().size(); k++) {
                if(r.getTypes().get(i).getSub_types().get(n)==r.getAnimals().get(k).getSub_type()){
                    list.add(animal_short_str(r.getAnimals().get(k).getId()));}
            } 
        }            
    }
    return list;}

public ArrayList<String> get_animal_id(int id) {
    ArrayList<String> list = new ArrayList<>();
    Animal animal = new Animal();
    Boolean test = false;
    String gender = "";
    for (int i = 0; i < r.getAnimals().size(); i++) {
        if (r.getAnimals().get(i).getId()==id) {test = true; animal = r.getAnimals().get(i);}}
    if (test){
        if (animal.getMan()){gender = "Мужской";}
        else {gender = "Женский";}
        list.add("\nИнформация по животному ID : "+id);
        list.add("Тип : "+get_str_type_id(id)+" Вид : "+get_str_sub_type_id(id));            
        list.add("Имя : "+animal.getName()+" Цвет : "+animal.getColor());
        list.add("Пол : "+gender);
        list.add("Возраст (ММ.ГГГГ) : "+animal.getBirth_month()+"."+animal.getBirth_year());
        list.add("Выполняемые команды : ");
        if (animal.getCommands().size()>0){
            for (int n = 0; n < animal.getCommands().size(); n++) {
                list.add("    "+(n+1)+". "+animal.getCommands().get(n));}}
        else {list.add("    ОТСУТСТВУЮТ");}}
    else {list.add("В реестре отсутствует животное с ID : "+id);}
    return list;}
public String add_animal(ArrayList<String> list1) {
    Animal animal = new Animal();
    animal.setId(r.getMax_id_animals()+1);
    animal.setSub_type(Integer.valueOf(list1.get(2)));
    animal.setName(list1.get(4));
    animal.setColor(list1.get(5));
    if (Integer.valueOf(list1.get(6))==1) {animal.setMan(true);}
    else {animal.setMan(false);}
    animal.setBirth_year(Integer.valueOf(list1.get(7)));
    animal.setBirth_month(Integer.valueOf(list1.get(8)));
    ArrayList<String> comands = new ArrayList<>();
    for (int i = 9; i < list1.size(); i++) {comands.add(list1.get(i));}
    animal.setCommands(comands);
    r.getAnimals().add(animal);
    r.setMax_id_animals(r.getMax_id_animals()+1);
    if (!list1.get(1).equals("")){
        r.setMax_id_sub_types(r.getMax_id_sub_types()+1);
        r.setMax_id_types(r.getMax_id_types()+1);
        Sub_type new_sub_type = new Sub_type();
        new_sub_type.setId(r.getMax_id_sub_types());
        new_sub_type.setName(list1.get(3));
        r.getSub_types().add(new_sub_type);
        Type new_type = new Type();
        new_type.setName(list1.get(1));
        new_type.setId(Integer.valueOf(list1.get(0)));
        new_type.getSub_types().add(Integer.valueOf(list1.get(2)));
        r.getTypes().add(new_type);}
    else {
        if (!list1.get(3).equals("")){
            Sub_type new_sub_type = new Sub_type();
            r.setMax_id_sub_types(r.getMax_id_sub_types()+1);
            new_sub_type.setId(r.getMax_id_sub_types());
            new_sub_type.setName(list1.get(3));
            r.getSub_types().add(new_sub_type);
            int a = Integer.valueOf(list1.get(0));
            int b = Integer.valueOf(list1.get(2));
            r.getTypes().get(a).getSub_types().add(b);}
        }
    return animal_short_str(r.getMax_id_animals());
    



    
}

}
