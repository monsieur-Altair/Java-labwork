
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TextCreator extends JFrame {
    private static String resultString="";
    DemoDialog dialogWindow;
    private JLabel[] labels;
    private JList<String> listOfWords;
    private JTextField textField;
    final String[] words={
            "Привет nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",
            "мир ",
            "помогите ",
            "я ",
            "не ",
            "люблю ",
            "джаву ",
            ". ",};

    public TextCreator(String str){
        super(str);
        setSize(680, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labels=new JLabel[2];
        labels[0]=new JLabel("Доступные слова");
        labels[1]=new JLabel("Итоговые фразы");

        listOfWords=new JList<String>(words);

        textField=new JTextField();

        setLayout(null);

        labels[0].setLocation(10,10);
        labels[1].setLocation(130,10);
        labels[0].setSize(300,40);
        labels[1].setSize(300,40);
        add(labels[0]);
        add(labels[1]);


        listOfWords.setSize(100,150);
        listOfWords.setLocation(10,45);
        add(listOfWords);

        textField.setSize(500,30);
        textField.setLocation(130,45);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setColumns(1);
        add(textField);

        listOfWords.addMouseListener(new ListListener());
    }

    public class ListListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
            String selectedString = listOfWords.getSelectedValue();
            resultString += selectedString;
            if(resultString.length()<100)
                textField.setText(resultString);
            else{
                dialogWindow=new DemoDialog(TextCreator.this, resultString);
                dialogWindow.setVisible(true);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }
}
