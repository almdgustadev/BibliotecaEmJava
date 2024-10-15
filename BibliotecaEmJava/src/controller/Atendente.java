package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Atendente  {
	Scanner input = new Scanner(System.in);
    private ArrayList<Livro> livros = new ArrayList<>();
    
    public void menu(){
        System.out.println("***************************************");
        System.out.println("--BEM VINDO A BIBILIOTECA--");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Qual menu você deseja acessar? ");
        System.out.println();
        System.out.println("1.Cadastrar livro.");
        System.out.println("2.Registrar um empréstimo.");
        System.out.println("3.Registrar uma devolução.");
        System.out.println("4.Verificar disponibilidade do livro.");
        System.out.println("5.Sair.");
    }
    
    public void cadastrarLivro(){
       int n, quantidadeLivros = 0; 
       
        System.out.println("---CADASTRO DE LIVROS---");
        System.out.println("Para cadastrar um livro é necessário do título do livro, nome do autor, quantidade de páginas, ano de publicação e ISBN.");
        System.out.println("Quantos livros deseja cadastrar?");
        
        n = input.nextInt();
        input.nextLine();
        
        for(int i=0 ; i<n ; i++){

            Livro novoLivro = new Livro("", "", 0, 0, 0, false, null, null);

            
            System.out.print("Nome do livro: ");
            String titulo = input.nextLine();
            while (titulo.isEmpty()) {
                System.out.println("Título não pode ficar em branco.");
                titulo = input.nextLine();                
            }
            novoLivro.setTitulo(titulo);

            System.out.print("Nome do autor: ");
            String autor = input.nextLine();
            while (autor.isEmpty()) {
                System.out.println("Autor não pode ficar em branco.");
                autor = input.nextLine();                            
            }
            novoLivro.setAutor(autor);

            System.out.print("Quantidade de páginas: ");
            int quantidadePg = input.nextInt();
            while (quantidadePg <= 0) {
                System.out.println("Quantidade de páginas deve ser maior que zero.");
                quantidadePg = input.nextInt();                            
            }
            novoLivro.setQuantidadePg(quantidadePg);
            input.nextLine();

            System.out.print("Ano de publicação: ");
            int anoPublicacao = input.nextInt();
            while (anoPublicacao <= 1900 || anoPublicacao > 2100) {
                System.out.println("O ano digitado é inválido tente de 1900 ate 2100.");
                anoPublicacao = input.nextInt();                            
            }
            novoLivro.setAnoPublicacao(anoPublicacao);
            input.nextLine();

            System.out.print("ISBN: ");
            int isbn = input.nextInt();
            while (isbn <= 0) {
                System.out.println("O ISBN deve ser maior que zero.");
                isbn = input.nextInt();                            
            }
            novoLivro.setIsbn(isbn);
            input.nextLine();

            livros.add(novoLivro);

            System.out.println("CADASTRO REALIZADO COM SUCESSO!");
            
            quantidadeLivros++;

        }
    }

    public void mostrarLivroDisponiveis(){
        System.out.println("LIVROS DISPONÍVEIS PARA EMPRÉSTIMO:");
        for(Livro livro : livros){
            if (!livro.isEmprestado()) {
                System.out.println("\nTítulo: " + livro.getTitulo() + " - " + livro.getIsbn() + " - DISPONÍVEL");
            }

        }

    }
   
    public boolean verificarLivrosDisponiveis(){
        for(Livro livro: livros){
            if (!livro.isEmprestado()) {
                return true;
                
            }
        }
        return false;


    }

    public void registarEmprestimo(){
        if (!verificarLivrosDisponiveis()) {
            System.out.println("\nNÃO HÁ LIVROS PARA SEREM EMPRESTADOS!");
            return;          
        }

        if(livros.isEmpty()){
            System.out.println("Não existe livros cadastrado!");
        }

        mostrarLivroDisponiveis();

       
        
        System.out.println("\nDigite o ISBN do livro desejado: ");
        int isbn = input.nextInt();

        Livro livroSelecionado = null;  
        for(Livro livro: livros){
            if (livro.getIsbn() == isbn){
                livroSelecionado = livro;
                break; 
            }
        }
        
        if(livroSelecionado == null){
            System.out.println("LIVRO NÃO ENCONTRADO!");
        }

        if (livroSelecionado.isEmprestado()) {
            System.out.println("O LIVRO JÁ ESTÁ EMPRESTADO!");    
            return;
        }
             
        System.out.println("Informe a data de empréstimo: ");
        Data dataEmprestimo = Data.capturarData();
        livroSelecionado.setDataEmp(dataEmprestimo);
        
        input.nextLine();

        Data dataDevolucao;
        
        do{
            System.out.println("Informe a data de devolução: ");
            dataDevolucao = Data.capturarData();
           
            if (dataDevolucao.getAno() < dataEmprestimo.getAno() || 
            (dataDevolucao.getAno()==dataEmprestimo.getAno() && dataDevolucao.getMes() < dataEmprestimo.getMes()) ||
            (dataDevolucao.getAno()==dataEmprestimo.getAno() && dataDevolucao.getMes() == dataEmprestimo.getMes() && 
            dataDevolucao.getDia()<= dataEmprestimo.getDia())) {
                System.out.println("A DATA DE DEVOLUÇÃO DEVE SER POSTERIOR A DE EMPRÉSTIMO!");
                
            }else{
                
                break;
            }
        }while(true);
        
        livroSelecionado.setDataDev(dataDevolucao);
        livroSelecionado.setEmprestado(true);
        System.out.println("EMPRÉSTIMO REGISTRADO!");
    }


}