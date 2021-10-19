import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;


public class InsertTable extends JFrame{
    private JPanel myPanel;
    private JLabel carID;
    private JLabel carName;
    private JLabel carType;
    private JLabel carVendor;
    private JTextField carIDText;
    private JTextField carNameText;
    private JTextField carTypeText;
    private JComboBox carVendorCombo;
    private JButton sendButton;
    private JTable carTable;

    private DBconnection dbConnection;
    private java.sql.ResultSet resultSet;
    private java.sql.Statement stmt;

    private String[] arr={"Nissan-LTD",
            "Opel-Corporation",
            "Citroen-Company",
            "Volvo-Corporation",
            "Mazda-Company"};
    private void createUIComponents() {  }

    public InsertTable(String name){
        super(name);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(myPanel);
        this.pack();

        this.setSize(600,400);

        try{
            dbConnection=new DBconnection();
            dbConnection.init();
            Connection conn= dbConnection.getMyConnection();
            stmt=conn.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }


        resultSet=getResultFromCars();
        carVendorCombo=new JComboBox(arr);
        carTable.setModel(new CarTableModel(resultSet));
        this.addWindowListener(new WindowCloser());

    }

    public ResultSet getResultFromCars()
    {
        ResultSet rs = null;
        try
        {
            rs = stmt.executeQuery("SELECT * FROM db6.car");
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return rs;
    }

    public class WindowCloser implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosing(WindowEvent e) {
            try
            {
                stmt.close();
                dbConnection.close(resultSet);
            }
            catch (SQLException exception)
            {
                System.out.println(exception);
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}

        @Override
        public void windowActivated(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e) {}
    }

    public static void main(String[] args) {

        JFrame insertTable=new InsertTable("Вставка таблицы");
        insertTable.setVisible(true);
    }



}
