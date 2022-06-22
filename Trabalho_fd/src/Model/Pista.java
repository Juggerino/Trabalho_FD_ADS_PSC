package Model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controller.Conexao;

public class Pista {
    
    private int idPista;
    private String nomePista;
    
    public Pista() {
    }

    public void pista(int idPista, String nomePista) {
    this.idPista = idPista;
    this.nomePista = nomePista;
    
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public int getIdPista() {
        return idPista;
    }

    public void setNomePista(String nomePista) {
        this.nomePista = nomePista;
    }

    public String getNomePista() {
        return nomePista;
    }

    
    public void visualizarPista(){
        String sql = "SELECT idPista,nomePista FROM pista WHERE (nomePista = '"+getNomePista()+"');";
   
        
        ResultSet rs = Conexao.consultar(sql);
        try{

            if(rs.next()){
                
                setIdPista((rs.getInt("idPista")));

                System.out.println("\nId do Pista : "+getIdPista()+"\nNome Pista :"+getNomePista());
            }else{
                System.out.println("Nao foi posivel cadastra!!");
            }
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    


}
