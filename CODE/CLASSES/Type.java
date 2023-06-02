package Specialization.CODE.CLASSES;

import java.util.ArrayList;

public class Type extends Sub_type{
    ArrayList<Integer> sub_types = new ArrayList<>();

    public ArrayList<Integer> getSub_types() {
        return sub_types;
    }

    public void setSub_types(ArrayList<Integer> sub_types) {
        this.sub_types = sub_types;
    }
    
}
