
package Reportes;

import BaseDeDatos.*;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class Grafico {
    public static void Graficar (String fecha){
        Connection con;
        ConexionMySQL cn = new ConexionMySQL();
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql = "SELECT total FROM ventas WHERE fecha = ?";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            rs = ps.executeQuery();
            DefaultPieDataset dataset = new DefaultPieDataset();
            while (rs.next()) {                
                dataset.setValue(rs.getString("total"), rs.getDouble("total"));
            }
            JFreeChart jf = ChartFactory.createPieChart("Reporte de Venta", dataset);
            ChartFrame f = new ChartFrame("Total de ventas por día",jf);
            f.setSize(1000,500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
