package com.company;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        ArrayList<Staff> staff_array = new ArrayList<>(5);
        staff_array.add(new Doctor("Чередниченко", "Михаил", 50, 1000, "Травматолог"));

        Intern in1=new Intern("Мельников", "Максим", 24, "БГМУ");
        staff_array.add(in1);

        ArrayList<Intern> interns_array = new ArrayList<>(5);
        interns_array.add(new Intern("Кротов","Иван",25,"БГМУ"));
        interns_array.add(new Intern("Молотов","Геннадий",24,"БГМУ"));

        SeniorDoctor seniorDoctor = new SeniorDoctor("Менко", "Петр", 56, 1800, "Терапевт");
        seniorDoctor.setInterns(interns_array);
        staff_array.add(seniorDoctor);

        for(var per:staff_array){
            per.print();
            System.out.print("\n");
        }

    }
}
