package com.company;

public class WriterInfo {
    public static String GetInfAboutStock(Stock st){
        return "\nТовар: "+st.getName()+"\nЦена: "+ st.getCost()+"\nПрисутствие на складе: "+st.getExist();
    }
}
