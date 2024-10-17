package viewer;

import controller.*;
import java.util.Scanner;

public class SistemaBiblioteca extends Atendente {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Atendente  atendenteDiario = new Atendente();
        int n;

        atendenteDiario.menu();
        n = input.nextInt();

        do{
            switch (n) {
            case 1:           	
            	atendenteDiario.cadastrarLivro();
                break;
            case 2:
            	atendenteDiario.registarEmprestimo();               
                break;
            case 3:
            	atendenteDiario.registrarDevolucao();
                break;
            case 4:
            	atendenteDiario.verificarDisponibilidadeLivro();
                break;        
            default:
            System.out.println("FECHANDO SISTEMA...");
            
        }
        

        if (n != 5) { 
            System.out.println("\nDeseja acessar outra funcionalidade? Se sim, digite o número da mesma:  ");
            System.out.println("1) Cadastrar livros.");
            System.out.println("2) Registrar um empréstimo.");
            System.out.println("3) Registrar uma devolução.");
            System.out.println("4) Verificar disponibilidade do livro.");
            System.out.println("5) Sair.");
            n = input.nextInt();
        }
    }while(n==1 || n==2 || n==3 || n==4);
    

        input.close();
    }
            
        
    }


