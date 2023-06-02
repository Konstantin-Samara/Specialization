package Specialization.CODE.MENU_COMMANDS;

import Specialization.CODE.View;

public class Get_animal_id implements Option{
    View view;
    public Get_animal_id(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Найти животное по ID.";
    }

    @Override
    public void execute() {
        view.get_animal_id();        
    }
    
}
