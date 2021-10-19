import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Authorization extends JFrame{
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JRadioButton male;
    private JRadioButton female;
    private JCheckBox isStayedInSystem;
    private JButton logIn;
    private JTextField nameText;
    private JTextField passwordText;
    private ButtonGroup buttonGroup;
    private File file;
    private String sex;
    private boolean isStayed;

    public Authorization(){
        super("Авторизация");

        final int offset=100;
        final int size=50;
        isStayed=false;
        file=new File("inf.txt");

        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLayout(null);

        nameLabel=new JLabel("Имя:");
        nameLabel.setLocation(offset,0);
        nameLabel.setSize(size,size);
        add(nameLabel);

        passwordLabel=new JLabel("Пароль:");
        passwordLabel.setLocation(offset,25);
        passwordLabel.setSize(size,size);
        add(passwordLabel);

        male = new JRadioButton("Мужской");
        male.setLocation(offset+50,75);
        male.setSize(2*size,size/3);
        add(male);

        female=new JRadioButton("Женский");
        female.setLocation(offset+150,75);
        female.setSize(2*size,size/3);
        add(female);

        buttonGroup=new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        isStayedInSystem=new JCheckBox("Оставаться в системе");
        isStayedInSystem.setLocation(160,100);
        isStayedInSystem.setSize(4*size,size);
        add(isStayedInSystem);

        logIn=new JButton("Войти");
        logIn.setLocation(190,150);
        logIn.setSize(2*size,size/2);
        add(logIn);

        nameText=new JTextField();
        nameText.setLocation(150,18);
        nameText.setSize(3*size,(int)(size/2.3));
        add(nameText);

        passwordText=new JTextField();
        passwordText.setLocation(150,43);
        passwordText.setSize(3*size,(int)(size/2.3));
        add(passwordText);

        logIn.addActionListener(new ButtonActionListener());
        male.addActionListener(new FlagActionListener());
        female.addActionListener(new FlagActionListener());

        isStayedInSystem.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                isStayed=!isStayed;
            }
        });

    }


    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                try{
                    fileWriter.write("\nName: "+nameText.getText() +"\nPassword: "+passwordText.getText());
                    fileWriter.write("\nSex: "+sex+"\nIs stayed in the system: "+isStayed+"\n");
                } finally{
                    fileWriter.close();
                }
            }catch(IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            sex=(e.getSource() == male)?"M":"F";
        }
    }


    
}
