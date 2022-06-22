package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class Conexao{

    private static final String url = "jdbc:mysql://localhost:3306/bd_trabalho?zeroDateTimeBehavior=convertToNull";
    private static final String user = "root";   
    private static final String senha = "";
    private static final String driver = "com.mysql.jdbc.Driver";
    
   
    

    public static void executar(String query) {
         
        try{

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, senha);
            Statement st = conn.createStatement();
            st.execute(query);
            conn.close();

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e.toString());

        }
                
    }

    public static ResultSet consultar(String query){

        try{

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, senha);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }

    
}

