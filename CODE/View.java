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
// import Specialization.CODE.MENU_COMMANDS.New_commans;

import Specialization.CODE.VIEW_MODELS.Add;

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
    System.out.println("Yallo");
    Read command1 = new Read(this);
    Write command2 = new Write(this);
    Get_all_reestr command3 = new Get_all_reestr(this);
    Add_animal command4 = new Add_animal(this);
    Del_animal command5 = new Del_animal(this);
    Get_animal_id command6 = new Get_animal_id(this);
    // New_commans command8 = new New_commans(this);
    Close command7 = new Close(this);

    command_list.add(command1);
    command_list.add(command2);
    command_list.add(command3);
    command_list.add(command4);
    command_list.add(command5);
    command_list.add(command6);
    // command_list.add(command8);
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
// public void new_command() {
//     ArrayList<String> list = new ArrayList<>();
//     ArrayList<String> comand_list = new ArrayList<>();

//     int id;
//     get_all_reestr();
//     id = my_input("Введите ID животного для добавления команд : ", 1, p.reestr.getMax_id_animals());
//     list = p.get_animal_id(id);
//     for (int i = 0; i < list.size(); i++) {System.out.println(list.get(i));}
//     System.out.println("Введите список выполняемых команд(Enter-завершить) : ");
//     int count = 1;
//     String s1;
//     Boolean test = true;
//     while (test){
//         System.out.print((count++)+". : ");
//         scan = new Scanner(System.in);
//         s1 = scan.nextLine();
//         if (s1!="") {comand_list.add(s1);}
//         else {test = false;}}

//     System.out.println(p.new_command(Integer.valueOf(id)), comand_list);
//     list = p.get_animal_id(id);
//     for (int i = 0; i < list.size(); i++) {System.out.println(list.get(i));}
// }

public void get_all_reestr() {
    ArrayList<String> list = new ArrayList<>();
    list = p.get_all_reestr();
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));}}

public void add_animal() {
    Add add1 = new Add(this);
    ArrayList<String> list = new ArrayList<>();
    list = add1.add(this.p); 
    String str;
    System.out.println(list.toString());
    str = p.add_animal(list);
    System.out.println("\nЖивотное\n"+str+"\nуспешно добавлено в реестр.");
}
public String get_new_sub_type() {
    Boolean test = true;
    String new_sub_type = "";

    while (test) {
        test = false;
        System.out.print("\nУкажите название нового вида животных : ");
        scan = new Scanner(System.in);
        new_sub_type = scan.nextLine();
        for (int i = 0; i < p.reestr.getSub_types().size(); i++) {
            if (p.reestr.getSub_types().get(i).getName().equals(new_sub_type)){
                test = true;
                System.out.println("\nТакое название уже содержится в реестре видов,");
                System.out.println("Попробуйте еще раз.");}}}
    return new_sub_type;}

public void del_animal() {
    get_all_reestr();
    System.out.print("Введите ID животного для удаления из реестра : ");
    scan = new Scanner(System.in);
    String id = scan.nextLine();
    System.out.println(p.del_animal1(Integer.valueOf(id)));
    int sel = my_input("Вы уверены (1-Да/0-нет)", 0, 1);
    if (sel==1) {
        System.out.println(p.del_animal2(Integer.valueOf(id)));}
}

public void get_animal_id() {
    ArrayList<String> list = new ArrayList<>();
    int id;
    id = my_input("Введите ID животного : ", 1, p.reestr.getMax_id_animals());
    list = p.get_animal_id(id);
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));}}





}
