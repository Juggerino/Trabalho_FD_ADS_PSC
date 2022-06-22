package Model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controller.Conexao;

public class Piloto {
    
    private int idPiloto;
    private String nomePiloto;
  
    public Piloto(int idPiloto) {
    }

    public Piloto() {
    }

    public void piloto(int idPiloto, String nomePiloto) {
    this.idPiloto = idPiloto;
    this.nomePiloto = nomePiloto;
    
}
   
    public void setIdPiloto(int idPiloto) {
       this.idPiloto = idPiloto;
    }

    public int getIdPiloto() {
       return idPiloto;
    }

    public void setNomePiloto(String nomePiloto) {
       this.nomePiloto = nomePiloto;
    }

    public String getNomePiloto() {
       return nomePiloto;
    }

   public void visualizarPiloto(){
        
        String sql = "SELECT idPiloto,nomePiloto FROM piloto WHERE (nomePiloto = '"+getNomePiloto()+"');";
        
        ResultSet rs = Conexao.consultar(sql);
        try{

            if(rs.next()){
                setIdPiloto(rs.getInt("idPiloto"));
              
                System.out.println("\nId do Piloto : "+getIdPiloto()+"\nNome Piloto :"+getNomePiloto()+"");
            }else{
                System.out.println("Nao foi posivel cadastra!!");
            }
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e.toString());
        }
   }
}
