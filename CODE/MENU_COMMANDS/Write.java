package Specialization.CODE.MENU_COMMANDS;

import Specialization.CODE.View;

public class Write implements Option{
    public Write(View view) {
        this.view = view;
    }

    View view;
    
    @Override
    public String discription() {
        return "Сохранить текущее состояние реестра.";
    }

    @Override
    public void execute() {
        view.write();    
    }
    
}
