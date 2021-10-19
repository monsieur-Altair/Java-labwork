import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarTableModel extends AbstractTableModel {

    private int colnum=4;
    private int rownum;

    private String[] colNames ={
            "CarID",
            "CarName",
            "CarType",
            "CarVendor"};

    private ArrayList<String[]> ResultSets;

    public CarTableModel(ResultSet rs)
    {
        ResultSets=new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String[] row = {
                        rs.getString("CarID"),
                        rs.getString("CarName"),
                        rs.getString("CarType"),
                        rs.getString("CarVendor")};

                ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in CarTableModel");
        }
    }


    @Override
    public int getRowCount() {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = ResultSets.get(rowIndex);
        return row[columnIndex];
    }

    @Override
    public String getColumnName(int param){
        return colNames[param];
    }

}
