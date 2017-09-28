package model;

import java.sql.*;


public class ConnectionDao {
    public static Connection con;
    
    public static void abreConexao() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmatech", "root", "");
            System.out.println("Sucesso ao conectar");

        
        }catch(Exception erro){
            System.out.println("Falha ao conectar");
        }
        
    
    }
    
    public static void fechaConexao() throws Exception{
    
        try {
            con.close();
            System.out.println("Conexao encerada");
            
        } catch (Exception erro) {
            throw new Exception("Nao existem conexoes de banco de dados ativas" + erro.getMessage());
        }
    
    }
}
