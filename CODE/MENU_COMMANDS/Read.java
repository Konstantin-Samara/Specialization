package Specialization.CODE.MENU_COMMANDS;

import Specialization.CODE.View;

public class Read implements Option{
    View view;


    public Read(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Загрузить реестр.";
    }

    @Override
    public void execute() {
        view.read();      
    }
    
}
