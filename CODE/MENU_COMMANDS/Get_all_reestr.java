package Specialization.CODE.MENU_COMMANDS;

import Specialization.CODE.View;

public class Get_all_reestr implements Option{
    View view;
    public Get_all_reestr(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Вывести весь реестр.";
    }

    @Override
    public void execute() {
        view.get_all_reestr();     
    }
    
}
