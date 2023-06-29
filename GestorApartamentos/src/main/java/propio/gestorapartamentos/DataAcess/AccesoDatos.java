
package propio.gestorapartamentos.DataAcess;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import propio.gestorapartamentos.DTO.Apartamento;
import propio.gestorapartamentos.DTO.Usuario;



public class AccesoDatos {
    
     
    
    public Connection conectarBD() throws IOException
    {
        Connection con = null;
        //Properties properties = new Properties();
        //String driver = "com.mysql.cj.jdbc.Driver";
        try {
            //properties.load(AccesoDatos.class.getClassLoader().getResourceAsStream("properties/application.properties"));

            //String url = properties.getProperty("url");
            //String password = properties.getProperty("password");
            //String user = properties.getProperty("user");

            
            String user="root", password="noruega80", url="jdbc:mysql://localhost:3306/etvmallorca";
            System.out.println(url);
            
            con = DriverManager.getConnection(url, user, password);

            //Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etvmallorca", "root", "noruega80");
            System.out.println("Estableciendo...");

            if (con != null) {
                JOptionPane.showMessageDialog(null, "Conectado satisfactoriamente");
            }
        } catch (HeadlessException |  SQLException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
        return con;
    }

    public ArrayList getMunicipios(int numId) throws IOException {
        ArrayList ListaApartamentos = new ArrayList<>();
       
        

        String sql = "SELECT * FROM allotjament WHERE id=?";
        try ( Connection connection = conectarBD();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, numId);
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()) {
                Apartamento apartamento = new Apartamento();
                
                apartamento.setId(rs.getInt(1));
                apartamento.setNom(rs.getString(2));
                apartamento.setDescripcio(rs.getString(3));
                apartamento.setNum_persones(rs.getInt(4));
                apartamento.setAdresa(rs.getString(5));
                apartamento.setId_municipi(rs.getInt(6));
                apartamento.setId_propietari(rs.getInt(7));
                apartamento.setDestacat(rs.getByte(8));
                apartamento.setPreu_per_nit(rs.getFloat(9));
                ListaApartamentos.add(apartamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ListaApartamentos;

    }
    
    public ArrayList getUsuarios() throws  SQLException
    {
        
        
        ArrayList usuarios = new ArrayList<>();
        String sql = "SELECT * FROM etvmallorca.usuari";
        
        try ( Connection connection = conectarBD();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setPassword(resultSet.getString("password"));
                usuarios.add(usuario);
                
                
            }
    }   catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    
}
