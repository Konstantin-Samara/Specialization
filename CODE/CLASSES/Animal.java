package Specialization.CODE.CLASSES;

import java.util.ArrayList;

public class Animal {
    int id,sub_type,birth_month,birth_year;
    String name, color;
    Boolean man;
    ArrayList<String> commands = new ArrayList<>();
    
    public Animal() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getSub_type() {
        return sub_type;
    }
    public void setSub_type(int sub_type) {
        this.sub_type = sub_type;
    }
    public int getBirth_month() {
        return birth_month;
    }
    public void setBirth_month(int birth_month) {
        this.birth_month = birth_month;
    }
    public int getBirth_year() {
        return birth_year;
    }
    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Boolean getMan() {
        return man;
    }
    public void setMan(Boolean man) {
        this.man = man;
    }
    public ArrayList<String> getCommands() {
        return commands;
    }
    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
 
}
