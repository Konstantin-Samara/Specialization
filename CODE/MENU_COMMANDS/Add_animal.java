package Specialization.CODE.MENU_COMMANDS;

import Specialization.CODE.View;

public class Add_animal implements Option{
    View view;
    
    public Add_animal(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Добавить животное.";
    }

    @Override
    public void execute() {
        view.add_animal();        
    }
    
}
