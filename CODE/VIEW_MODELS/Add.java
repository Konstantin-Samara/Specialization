package Specialization.CODE.VIEW_MODELS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import Specialization.CODE.Presenter;
import Specialization.CODE.View;

public class Add {
    View v;
    public Add(View v) {
        this.v = v;
    }

    Scanner scan = new Scanner(System.in);

    public ArrayList<String> add(Presenter p) {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> id_sub_type_list = new ArrayList<>();
        int sel1,sel2,i;
        String s="";

        System.out.println("\nДобавляется новое животное с ID : "
        +(p.reestr.getMax_id_animals()+1));

        // Формируется тип и вид нового животного из существующего перечня
        // типов и видов, либо создаются новые типы и виды (проверяется отсутствие 
        // дублирования названий новых типов(видов) с содержащимися в реестре)

        System.out.println("\nВыберите тип нового животного :");
        for (i = 0; i < p.reestr.getTypes().size(); i++) {
            System.out.println((i+1)+". "+p.reestr.getTypes().get(i).getName());}
            System.out.println((i+1)+". Создать новый тип.");
        sel1 = v.my_input("\nВыберите пункт меню (1-"
        +(p.reestr.getTypes().size()+1)+") : ", 1, p.reestr.getTypes().size()+1);

        if (sel1!=p.reestr.getTypes().size()+1) /*если не новый тип */{   
            list.add(String.valueOf(sel1-1));/*добавляем индекс типа в список */
            list.add("") ;
            System.out.println("\nВыберите вид нового животного :");
            for (i = 0; i < p.reestr.getTypes().get(sel1-1).getSub_types().size(); i++) {
                int g = p.reestr.getTypes().get(sel1-1).getSub_types().get(i);
                for (int j = 0; j < p.reestr.getSub_types().size(); j++) {
                    if (p.reestr.getSub_types().get(j).getId()==g){
                        s = p.reestr.getSub_types().get(j).getName();
                        id_sub_type_list.add(p.reestr.getSub_types().get(j).getId());}}
                System.out.println((i+1)+". "+s);}            
            System.out.println((i+1)+". Создать новый вид.");
            sel2 = v.my_input("\nВыберите пункт меню (1-"
                +(p.reestr.getTypes().get(sel1-1).getSub_types().size()+1)+") : ",1, 
                p.reestr.getTypes().get(sel1-1).getSub_types().size()+1);
            if (sel2!=id_sub_type_list.size()+1){  /*если не новый вид */
                sel2 = id_sub_type_list.get(sel2-1);
                list.add(String.valueOf(sel2));/*добавляем ID вида в список */
                list.add("") ;}
            else {/*если новый вид */
                list.add(String.valueOf(p.reestr.getMax_id_sub_types()+1));
                list.add(v.get_new_sub_type()) ;}        
            }
        else{/*если новый тип (и, соответственно, вид) */
            Boolean test = true;
            String new_type = "";
            while (test) {
                test = false;
                System.out.print("\nУкажите название нового типа животных : ");
                scan = new Scanner(System.in);
                new_type = scan.nextLine();
                for (int j = 0; j < p.reestr.getTypes().size(); j++) {
                    if (p.reestr.getTypes().get(j).getName().equals(new_type)){
                        test = true;
                        System.out.println("\nТакое название уже содержится в реестре типов,");
                        System.out.println("Попробуйте еще раз.");}}}
            list.add(String.valueOf(p.reestr.getMax_id_types()+1));
            list.add(new_type) ;
            list.add(String.valueOf(p.reestr.getMax_id_sub_types()+1));
            list.add(v.get_new_sub_type()) ;}
        // Заполняются остальные поля
        System.out.print("Введите имя : ");   
        scan = new Scanner(System.in);
        String name = scan.nextLine();
        list.add(name);
        System.out.print("Введите цвет : ");   
        scan = new Scanner(System.in);
        String color = scan.nextLine();
        list.add(color);
        list.add(String.valueOf(v.my_input("Введите пол (1-муж/0-жен)", 0, 1)));
// Заполняется год и месяц рождения с проверкой - не позже текущего года&&месяца
        Calendar cal = new GregorianCalendar();
        int now_month = cal.get(Calendar.MONTH);
        int now_year = cal.get(Calendar.YEAR);
        int year=0;
        int month=0;
        Boolean test = true;
        while (test){
            test = false;
            year = v.my_input("Введите год рождения : ",2000,now_year);
            month = v.my_input("Введите месяц рождения : ",1,12);
            if ((year==now_year&&month>(now_month+1))){
                System.out.println("Дата рождения не может быть позже текущей,");
                System.out.println("Попробуйте еще раз.");
                test = true;}}    
        list.add(String.valueOf(year));
        list.add(String.valueOf(month));
// Заполняется список выполняемых команд
        System.out.println("Введите список выполняемых команд(Enter-завершить) : ");
        int count = 1;
        String s1;
        test = true;
        while (test){
            System.out.print((count++)+". : ");
            scan = new Scanner(System.in);
            s1 = scan.nextLine();
            if (s1!="") {list.add(s1);}
            else {test = false;}}
            return list;
        }
        
}
