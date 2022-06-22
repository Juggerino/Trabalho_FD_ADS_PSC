package View;

import java.util.Scanner;

import Controller.Controller;



public class Main {


 

   public static void main(String[] args) {
      int op = 1;

      Scanner sc = new Scanner(System.in);
      Controller c = new Controller();

      while(op != 0){
         
         System.out.println("Digite para \n1- Cadastrar \n2- Editar \n3- Excluir \n4- Listar \n0- Sair");
         op = sc.nextInt();

         switch(op){
            case 1:
               while(op != 0){
                  System.out.println("Digite um numero para \n1- Piloto \n2- Pista \n3- Corrida \n0- Sair");
                  op = sc.nextInt();

                  switch(op){
                     case 1: 
                        c.cadastraPiloto();
                     break;
                     case 2: 
                        c.cadastraPista();
                     break;
                     case 3: 
                        c.cadastraCorrida();
                     break;
                     case 0: 
                        
                     break;
                     default:
                     
                        System.out.println("\nOpcao invalida\n");
                  }
               }
               op = 1;
            break;   
            case 2:
               while(op != 0){
                  System.out.println("Digite um numero para \n1- Piloto \n2- Pista \n3- Corrida \n0- Sair");
                  op = sc.nextInt();

                  switch(op){
                     case 1: 
                        c.editarPiloto();
                     break;
                     case 2: 
                        c.editarPista();
                     break;
                     case 3: 
                        c.editarCorrida();
                     break;
                     case 0: 
                     
                     break;
                     default:
                  
                        System.out.println("\nOpcao invalida\n");
                  }
               }
               op = 1;
            break;
            case 3:
               while(op != 0){
                  System.out.println("Digite um numero para \n1- Piloto \n2- Pista \n3- Corrida \n0- Sair");
                  op = sc.nextInt();

                  switch(op){
                     case 1: 
                        c.excluirPiloto();
                     break;
                     case 2: 
                        c.excluirPista();
                     break;
                     case 3: 
                        c.excluirCorrida();
                     break;
                     case 0: 
                     
                     break;
                     default:
                  
                        System.out.println("\nOpcao invalida\n");
                  }
               }
               op = 1;
            break;
            case 4:
               while(op != 0){
                  System.out.println("Digite um numero para \n1- Piloto \n2- Pista \n3- Corrida \n0- Sair");
                  op = sc.nextInt();

                  switch(op){
                     case 1: 
                        c.listaPiloto();
                     break;
                     case 2: 
                        c.listarPistas();
                     break;
                     case 3: 
                        c.listaCorrida();
                     break;
                     case 0: 
                     
                     break;
                     default:
                  
                        System.out.println("\nOpcao invalida\n");
                  }
               }
               op = 1;
            break;
            case 0:

            break;
            default:
               System.out.println("\nOpcao invalida\n");
         }

      }

      
      //c.cadastraPista();
      //c.cadastraPiloto();
      //c.cadastraCorrida();
      //c.excluirPista();
      //c.excluirPiloto();
      //c.excluirCorrida();
      //c.editarPista();
      //c.editarPiloto();
      //c.editarCorrida();
      //c.listarPistas();
      //c.listaPiloto();
      //c.listaCorrida();
    
      
      
      
   
   }


   

}