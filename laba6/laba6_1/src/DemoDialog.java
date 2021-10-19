import javax.swing.*;
import java.awt.*;

public class DemoDialog extends JDialog {

    private JTextArea textArea;

    public DemoDialog(TextCreator txtCrt ,String str){
        super(txtCrt,"Диалоговое окно",false);
        super.setSize(str.length()*7,100);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JPanel panel=new JPanel();

        textArea=new JTextArea();
        textArea.setLocation(10,10);
        textArea.setSize(600,30);
        textArea.setText(str);
        panel.add(new JScrollPane(textArea));
        setContentPane(panel);
    }
}
