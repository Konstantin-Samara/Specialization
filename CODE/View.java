package Specialization.CODE;

import java.util.ArrayList;
import java.util.Scanner;

import Specialization.CODE.MENU_COMMANDS.Add_animal;
import Specialization.CODE.MENU_COMMANDS.Close;
import Specialization.CODE.MENU_COMMANDS.Del_animal;
import Specialization.CODE.MENU_COMMANDS.Get_all_reestr;
import Specialization.CODE.MENU_COMMANDS.Get_animal_id;
import Specialization.CODE.MENU_COMMANDS.Option;
import Specialization.CODE.MENU_COMMANDS.Read;
import Specialization.CODE.MENU_COMMANDS.Write;
import Specialization.CODE.VIEW_MODELS.Add_Animal;

public class View {
    Presenter p;
    Scanner scan = new Scanner(System.in);

    
    public View(Presenter presenter) {
        this.p = presenter;
    }

    public int my_input (String str, int n1, int n2) {
        int inp = 0;
        boolean test = true;
        while (test) {
            scan = new Scanner(System.in);
            System.out.print(str);
            try { inp = scan.nextInt();test = false;} 
            catch (Exception e) { 
                System.out.println("Вы ввели не число, попробуйте еще раз.");}
            if (!test)   { 
                if (inp>=n1&&inp<=n2) 
                    test = false;
                else {
                    test = true; 
                    System.out.println("Число от "+n1+" до "+n2+". попробуйте еще раз.");}}}
        return inp;}

public void main_menu() {
    int sel = 0;
    ArrayList<Option> command_list = new ArrayList<>();
    Read command1 = new Read(this);
    Write command2 = new Write(this);
    Get_all_reestr command3 = new Get_all_reestr(this);
    Add_animal command4 = new Add_animal(this);
    Del_animal command5 = new Del_animal(this);
    Get_animal_id command6 = new Get_animal_id(this);
    Close command7 = new Close(this);

    command_list.add(command1);
    command_list.add(command2);
    command_list.add(command3);
    command_list.add(command4);
    command_list.add(command5);
    command_list.add(command6);
    command_list.add(command7);

    while (sel!=command_list.size()) {
        System.out.println();
        for (int index = 1; index <= command_list.size() ; index++) {
            System.out.println(index+". "+command_list.get(index-1).discription());}
        sel = my_input("Выберите пункт меню (1-"+command_list.size()+") : ",
            1,command_list.size());
        command_list.get(sel-1).execute();}
}

public void read() {
    p.read();
}

public void write() {
    p.write();
}

public void close() {
    scan.close();
    p.close();
}

public void get_all_reestr() {
    ArrayList<String> list = new ArrayList<>();
    list = p.get_all_reestr();
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));}}

public void add_animal() {
    Add_Animal add1 = new Add_Animal(this);
    ArrayList<String> list = new ArrayList<>();
    list = add1.add(this.p); 
    System.out.println(list.toString());
    p.add_animal(list);
}
public String get_new_sub_type() {
    System.out.print("\nУкажите название нового вида животных : ");
    scan = new Scanner(System.in);
    String new_sub_type = "";
    new_sub_type = scan.nextLine();
    return new_sub_type;}

public void del_animal() {
    p.del_animal();
}

public void get_animal_id() {
    ArrayList<String> list = new ArrayList<>();
    int id;
    id = my_input("Введите ID животного : ", 1, p.reestr.getMax_id_animals());
    list = p.get_animal_id(id);
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));}}



}
