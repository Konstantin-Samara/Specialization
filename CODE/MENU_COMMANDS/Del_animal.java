package Specialization.CODE.MENU_COMMANDS;

import Specialization.CODE.View;

public class Del_animal implements Option{
    View view;
    
    public Del_animal(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Удалить животное";
    }

    @Override
    public void execute() {
        view.del_animal();     
    }
    
}
