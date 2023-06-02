package Specialization.CODE.VIEW_MODELS;

import java.util.ArrayList;
import java.util.Scanner;
import Specialization.CODE.Presenter;
import Specialization.CODE.View;

public class Add_Animal {
    View v;
    public Add_Animal(View v) {
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

        System.out.println("Выберите тип нового животного :");
        for (i = 0; i < p.reestr.getTypes().size(); i++) {
            System.out.println((i+1)+". "+p.reestr.getTypes().get(i).getName());}
            System.out.println((i+1)+". Создать новый тип.");
        sel1 = v.my_input("Выберите пункт меню (1-"
        +(p.reestr.getTypes().size()+1)+") : ", 1, p.reestr.getTypes().size()+1);

        if (sel1!=p.reestr.getTypes().size()+1) /*если не новый тип */{   
            list.add(String.valueOf(sel1-1));/*добавляем индекс типа в список */
            list.add("") ;
            System.out.println("Выберите вид нового животного :");
            for (i = 0; i < p.reestr.getTypes().get(sel1-1).getSub_types().size(); i++) {
                int g = p.reestr.getTypes().get(sel1-1).getSub_types().get(i);
                for (int j = 0; j < p.reestr.getSub_types().size(); j++) {
                    if (p.reestr.getSub_types().get(j).getId()==g){
                        s = p.reestr.getSub_types().get(j).getName();
                        id_sub_type_list.add(p.reestr.getSub_types().get(j).getId());}}
                System.out.println((i+1)+". "+s);}            
            System.out.println((i+1)+". Создать новый вид.");
            sel2 = v.my_input("Выберите пункт меню (1-"
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
        else{/*если новый вид */
            System.out.print("\nУкажите название нового типа животных : ");
            scan = new Scanner(System.in);
            String new_type = "";
            new_type = scan.nextLine();
            list.add(String.valueOf(p.reestr.getMax_id_types()+1));
            list.add(new_type) ;
            list.add(String.valueOf(p.reestr.getMax_id_sub_types()+1));
            list.add(v.get_new_sub_type()) ;}

            return list;
        }
        
}
