package Controller;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Model.Corrida;
import Model.Piloto;
import Model.Pista;

public class Controller{

    Pista p = new Pista();
    Piloto pl = new Piloto();
    Corrida c = new Corrida();
    Scanner scn = new Scanner(System.in);
 
    public  void cadastraPista(){

        System.out.println("Digite o nome da pista: ");
        p.setNomePista(scn.next());
     
        
        String sql = "INSERT INTO pista (nomePista) VALUES ('"+p.getNomePista()+"')";
        Conexao.executar(sql);

        p.visualizarPista();
    }

    public void cadastraPiloto(){
        
        System.out.println("\nDigite o nome do piloto: ");
        pl.setNomePiloto(scn.next());
        
        String sql = "INSERT INTO piloto (nomePiloto) VALUES ('"+pl.getNomePiloto()+"')";
        Conexao.executar(sql);

        pl.visualizarPiloto();
    } 
   
    public void cadastraCorrida(){

        System.out.println("\nDigite quantidades total de voltas do Piloto: ");
        c.setQtdVoltas(scn.nextInt());

        System.out.println("\nDigite o melhor tempo do piloto: ");
        c.setMelhorTempo(scn.nextInt());

        System.out.println("\nDigite a colocacao do piloto: ");
        c.setPosicao(scn.nextInt());

        System.out.println("\nDigite o id do piloto: ");
        pl.setIdPiloto(scn.nextInt());

        System.out.println("\nDigite o id da pista: ");
        p.setIdPista(scn.nextInt());

        
        String sql = "INSERT INTO corrida (qtdVotas,melhorTempo,posicao,idPiloto,idPista) VALUES ("+c.getQtdVoltas()+","+c.getMelhorTempo()+","+c.getPosicao()+","+p.getIdPista()+","+pl.getIdPiloto()+")";
        Conexao.executar(sql);

        int piloto = p.getIdPista();
        int pista = pl.getIdPiloto();
        c.visualizarCorrida(piloto,pista);
   
    }

    public void excluirPista(){

        System.out.println("Digite o nome da pista que desseja excluir :");
        p.setNomePista(scn.next());

        String sql = "DELETE from pista WHERE nomePista = '"+p.getNomePista()+"';";
        Conexao.executar(sql);


    }

    public void excluirPiloto(){

        System.out.println("Digite o nome da pista que desseja excluir :");
        pl.setNomePiloto(scn.next());

        String sql = "DELETE from piloto WHERE nomePiloto = '"+pl.getNomePiloto()+"';";
        Conexao.executar(sql);


    }

    public void excluirCorrida(){

        System.out.println("Digite o id da corrida :");
        c.setIdCorrida(scn.nextInt());

        System.out.println("Digite o id da Pista :");
        p.setIdPista(scn.nextInt());

        System.out.println("Digite o id da Piloto :");
        pl.setIdPiloto(scn.nextInt());

        String sql = "DELETE from corrida WHERE idCorrida = "+c.getIdCorrida()+" AND idPiloto = "+pl.getIdPiloto()+" AND idPista = "+p.getIdPista()+";";
        Conexao.executar(sql);


    }

    public void editarPista(){

        System.out.println("Digite o id da pista que desseja editar :");
        p.setIdPista(scn.nextInt());

        System.out.println("Digite o novo nome da pista :");
        p.setNomePista(scn.next());

        String sql = "UPDATE pista SET nomePista = '"+p.getNomePista()+"' WHERE idPista = "+p.getIdPista()+";";
        Conexao.executar(sql);

    }

    public void editarPiloto(){

        System.out.println("Digite o id do piloto que desseja editar :");
        pl.setIdPiloto(scn.nextInt());

        System.out.println("Digite o novo nome do piloto :");
        pl.setNomePiloto(scn.next());

        String sql = "UPDATE piloto SET nomePiloto = '"+pl.getNomePiloto()+"' WHERE idPiloto = "+pl.getIdPiloto()+";";
        Conexao.executar(sql);

    }

    public void editarCorrida(){

        System.out.println("Digite o id da corrida que desseja editar :");
        c.setIdCorrida(scn.nextInt());

        System.out.println("Digite o id do piloto :");
        pl.setIdPiloto(scn.nextInt());

        System.out.println("Digite o id da pista :");
        p.setIdPista(scn.nextInt());

        System.out.println("Digite a nova quantidade de voltas do piloto :");
        c.setQtdVoltas(scn.nextInt());

        System.out.println("Digite o novo melhor tempo do piloto :");
        c.setMelhorTempo(scn.nextInt());

        System.out.println("Digite a nova classificacao do piloto :");
        c.setPosicao(scn.nextInt());

        String sql = "UPDATE corrida SET qtdVotas = "+c.getQtdVoltas()+",melhorTempo = "+c.getMelhorTempo()+",posicao = "+c.getPosicao()+" WHERE idCorrida = "+c.getIdCorrida()+" AND idPiloto = "+pl.getIdPiloto()+" AND idPista = "+p.getIdPista()+";";
        Conexao.executar(sql);

    }

    public void listaPiloto(){

        String sql = "SELECT * FROM piloto;";
        
        ArrayList<String> piloto = new ArrayList<>();
        ResultSet rs = Conexao.consultar(sql);

            try{
                while ( rs.next() ) {
                
                    pl.setIdPiloto(rs.getInt("idPiloto"));
                    pl.setNomePiloto(rs.getString("nomePiloto"));
                
                    String resul = "\nId Piloto : "+pl.getIdPiloto()+"\nNome da Piloto : "+pl.getNomePiloto()+"\n";
                    piloto.add(resul);
                }
                System.out.println(piloto);
            }catch(Exception e){

                JOptionPane.showMessageDialog(null, e.toString());
            }
        
    }

    public void listarPistas(){
        
        String sql = "SELECT * FROM pista;";
        
        ArrayList<String> pista = new ArrayList<>();
        ResultSet rs = Conexao.consultar(sql);

            try{
                while ( rs.next() ) {
                
                    p.setIdPista(rs.getInt("idPista"));
                    p.setNomePista(rs.getString("nomePista"));
                
                    String resul = "\nId Pista : "+p.getIdPista()+"\nNome da Pista : "+p.getNomePista()+"\n";
                    pista.add(resul);
                }
                System.out.println(pista);
            }catch(Exception e){

                JOptionPane.showMessageDialog(null, e.toString());
            }
    }

    public void listaCorrida(){

        String sql = "SELECT * FROM corrida;";
        ResultSet rs = Conexao.consultar(sql);

        ArrayList<String> corrida = new ArrayList<>();
        try{
            while ( rs.next() ) {
                
                c.setIdCorrida(rs.getInt("idCorrida"));
                c.setQtdVoltas((rs.getInt("qtdVotas")));
                c.setMelhorTempo(((rs.getInt("melhorTempo"))));
                c.setPosicao((rs.getInt("posicao")));
                p.setIdPista((rs.getInt("idPista")));
                pl.setIdPiloto((rs.getInt("idPiloto")));
                
                String resul = "\nId Corrida : "+c.getIdCorrida()+"\nQuantidades de voltas do Piloto : "+c.getQtdVoltas()+"\nMelhor tempo de volta : "+c.getMelhorTempo()+"\nClassificacao do piloto : "+c.getPosicao()+"\nId da pista : "+p.getIdPista()+"\nId do Piloto : "+pl.getIdPiloto()+"\n";
                corrida.add(resul);
            }
            System.out.println(corrida);
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e.toString());
        }
    }


   
       
}