package Model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controller.Conexao;

public class Corrida extends Piloto {

    private int idCorrida;
    private int qtdVoltas;
    private int melhorTempo;
    private int posicao;
    Pista p = new Pista();
    	

    public Corrida(int idCorrida, int qtdVoltas, int melhorTempo,int posicao,int idPiloto) {
        super(idPiloto);
        this.idCorrida = idCorrida;
        this.qtdVoltas = qtdVoltas;
        this.melhorTempo = melhorTempo;
        this.posicao = posicao;
    }
    
    public Corrida() {
    }

    public void setIdCorrida(int idCorrida) {
        this.idCorrida = idCorrida;
    }
    
    public int getIdCorrida() {
        return idCorrida;
    }

    public void setQtdVoltas(int qtdVoltas) {
        this.qtdVoltas = qtdVoltas;
    }

    public int getQtdVoltas() {
        return qtdVoltas;
    }

    public void setMelhorTempo(int melhorTempo) {
        this.melhorTempo = melhorTempo;
    }

    public int getMelhorTempo() {
        return melhorTempo;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

   public void visualizarCorrida(int piloto,int pista){
    
    
    String sql = "SELECT idCorrida,qtdVotas,melhorTempo,posicao,idPista,idPiloto FROM corrida WHERE (idPista = "+pista+") AND (idPiloto = "+piloto+");";
        
    ResultSet rs = Conexao.consultar(sql);

    try{
        if(rs.next()){
            setIdCorrida(rs.getInt("idCorrida"));
            setQtdVoltas(rs.getInt("qtdVotas"));
            setMelhorTempo(rs.getInt("melhorTempo"));
            setPosicao((rs.getInt("posicao")));
            p.setIdPista(rs.getInt("idPista"));
            setIdPiloto(rs.getInt("idPiloto"));
            
            System.out.println("\nId Corrida : "+getIdCorrida()+"\nQuantidades de voltas :"+getQtdVoltas()+"\nMelhor tempo : "+getMelhorTempo()+"\nClassificacao : "+getPosicao()+"\nId Piloto : "+getIdPiloto()+"\nId Pista : "+p.getIdPista());
        }else{
            System.out.println("Nao foi posivel cadastra!!");
        }
    }catch(Exception e){

        JOptionPane.showMessageDialog(null, e.toString());
    }
   }
    
   
}
