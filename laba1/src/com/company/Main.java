package com.company;

/*public class Main {

    public static void main(String[] args) {
        Stock st1=new Stock();
        st1.Print();

        Stock st2=new Stock("Носки красные",10,true);
        String result = WriterInfo.GetInfAboutStock(st2);
        System.out.println(result+"\n-------------------------");
    }
}*/

/*import java.awt.*;
import java.awt.event.*;
public class Main extends Frame
        implements ActionListener,WindowListener{
    Button btn;
    Label lb;
    int count;
    public Main(){
        super("Фреймовое окно с кнопкой");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        btn=new Button("Нажмите кнопку");
        setSize(300,200);
        btn.addActionListener(this);
        lb=new Label("Здесь текстовое поле");
        count=0;
        add(btn);
        add(lb);
        setVisible(true);
        addWindowListener(this);
    }
    public void actionPerformed(ActionEvent ae)	{
        count++;
        lb.setText("Кнопка нажата  "+count+"  раз");
    }
    public void windowClosing(WindowEvent we){
        this.dispose();
    }
    public void windowActivated(WindowEvent we){};
    public void windowClosed(WindowEvent we){};
    public void windowDeactivated(WindowEvent we){};
    public void windowDeiconified(WindowEvent we){};
    public void windowIconified(WindowEvent we){};
    public void windowOpened(WindowEvent we){};

    public static void main(String args[])
    {
        Main bd=new Main();
    }
}*/

/*import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ItemListener,WindowListener{

    List lst;
    Checkbox chb;
    Choice ch;

    public Main(){
        super("Фреймовое окно");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(300,200);
        lst = new List (2, false );
        lst.add ("1 BSUIR");
        lst.add ("2 BSEU");
        lst.add ("3 BSU");
        chb=new Checkbox("Кнопка с независимой фиксацией");
        ch=new Choice();
        ch.add("Сюда переносятся строки со списка");
        ch.add("Сюда переносятся строки со списка");
        add(lst);
        add(ch);
        add(chb);
        setVisible(true);
        lst.addItemListener(this);
        addWindowListener(this);
    }
    public void itemStateChanged(ItemEvent ie){
        ch.addItem(lst.getSelectedItem());
    }

    public void windowClosing(WindowEvent we){
        this.dispose();
    }
    public void windowActivated(WindowEvent we){};
    public void windowClosed(WindowEvent we){};
    public void windowDeactivated(WindowEvent we){};
    public void windowDeiconified(WindowEvent we){};
    public void windowIconified(WindowEvent we){};
    public void windowOpened(WindowEvent we){};


    public static void main(String args[]){
        Main list=new Main();
    }
}*/

//import java.io.*; //импортирование пакета ввода-вывода
//import java.awt.*; //импортирование пакета awt 
//import java.awt.event.*; //импортирование пакета поддержки событий
//
//
//public class Main extends Frame{ //объявление класса Main
//
//    Button b1 = new Button("Add"); //создание кнопки с надписью "Add"
//    Choice ch1=new Choice(); //создание раскрывающегося списка 
//    TextField tf1 = new TextField(); //создание текстового поля (строк //ввода)
//    Label label1 = new Label("Enter your text here:"); //создание текстовой  
//    //строки
//    List l1 = new List(); //создание списка
//
//
//    public Main(){ //объявление конструктора класса        
//
//        setLayout(null); //отключение менеджера компоновки
//        setSize(600,400); //установка размеров фрейма
//        setTitle("This is my Frame"); //установка заголовка фрейма
//        setBackground(Color.cyan); //установка цвета заднего фона фрейма 
//        add(b1); //добавление кнопки к окну
//        b1.setBounds(220,200,84,24); //установка размеров кнопки
//        b1.setForeground(Color.black); //установка цвета переднего фона кнопки
//        b1.setBackground(Color.magenta); //установка цвета заднего фона кнопки  
//        add(ch1); //добавление раскрывающегося списка к окну      
//        ch1.setBounds(50,120,120,20); //установка размеров раскрывающегося 
////списка
//        add(tf1); //добавление текстового поля к окну
//        tf1.setBounds(200,80,120,20); //установка размеров текстового поля
//        add(label1); //добавление текстовой строки к окну
//        label1.setBounds(200,55,120,20); //установка размеров текстовой строки
//        add(l1); //добавление списка к окну
//        l1.setBackground(Color.white); //установка цвета заднего фона списка
//        l1.setBounds(350,120,200,216); //установка размеров списка
//        /*регистрация блока прослушивания событий типа WindowEvent*/
//        addWindowListener(new WindowClose());
//        /*регистрация блока прослушивания событий типа ActionEvent*/
//        b1.addActionListener(new ButtonAdd());
//    }
//    /*объявление класса-адаптера для обработки Window-событий*/
//    class WindowClose extends WindowAdapter {
//        /*метод, который вызывается при закрытии окна*/
//        public void windowClosing(WindowEvent we) {
//            setVisible(false); //фрейм-окно становится невидимым
//            dispose();
//        }
//    }
//    /*объявление класса для обработки Action-событий (класс ButtonAdd реализует интерфейс ActionListener)*/
//    class ButtonAdd implements ActionListener {
//        /*реализация метода,  который вызывается при наступлении action-события*/
//        public void actionPerformed(ActionEvent event) {
//            /*добавление текста из текстового поля в раскрывающийся список*/
//            ch1.add(tf1.getText());
//            /*добавление текста из текстового поля в список*/
//            l1.add(tf1.getText(),2);
//        }
//    }
//    static public void main(String args[]){ //объявление метода main()
//        Main MyFrame=new Main(); //создание экземпляра класса Main
//        MyFrame.setVisible(true); //выведение окна на экран дисплея
//    }
//}
//


/*import java.awt.*;
import java.awt.event.*;
public class Main
        extends Frame
        implements ActionListener,WindowListener{

    Menu file;
    MenuItem item1;

    public Main(){
        super("Фреймовое окно с меню");
        setSize(500,300);
//создать строку главного меню и добавить его во фрейм
        MenuBar mbar=new MenuBar();
        setMenuBar(mbar);
//создать элемент меню
        file=new Menu("File");
        mbar.add(file);
        item1=new MenuItem("DemoDialog");
        file.add(item1);
        item1.addActionListener(this);
        setVisible(true);
        addWindowListener(this);
    }
    public void actionPerformed(ActionEvent ae)	{
        DemoDialog d=new DemoDialog(this,"Диалоговое окно",false);
    }
    public void windowClosing(WindowEvent we){
        this.dispose();
    }
    public void windowActivated(WindowEvent we){};
    public void windowClosed(WindowEvent we){};
    public void windowDeactivated(WindowEvent we){};
    public void windowDeiconified(WindowEvent we){};
    public void windowIconified(WindowEvent we){};
    public void windowOpened(WindowEvent we){};


    public static void main(String args[])
    {
        Main f=new Main();
    }

    class DemoDialog extends Dialog implements ActionListener{
        Button btn;
        public DemoDialog(Main ff, String title,boolean b){
            super(ff,title,b);
            setLayout(new FlowLayout(FlowLayout.LEFT));
            btn=new Button("Закрыть");
            setSize(300,200);
            add(btn);
            btn.addActionListener(this);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
            dispose();
        }
    }
}*/




