package model;

public class Livro {
    private String titulo, autor;
    private int quantidadePg, anoPublicacao, isbn;
    private boolean emprestado;
    private Data dataEmp, dataDev;

    public Livro(String autor, String titulo, int quantidadePg, int anoPublicacao, int isbn, boolean emprestado, Data dataEmp, Data dataDev){
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadePg = quantidadePg;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.emprestado = emprestado;
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
    }

    public String getTitulo(){
        return titulo;
    }
        
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getAnoPublicacao(){
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao){      
        this.anoPublicacao = anoPublicacao;
    }
    
    public int getQuantidadePg(){
        return quantidadePg;
    }

    public void setQuantidadePg(int quantidadePg){
        this.quantidadePg =  quantidadePg;
    }
    
    public int getIsbn(){
        return isbn;
    }

    public void setIsbn(int isbn){
        this.isbn = isbn;
    }

    public boolean isEmprestado(){
        return emprestado;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    public Data getDataEmp(){
        return dataEmp;
    }

    public void setDataEmp(Data dataEmp){
        this.dataEmp = dataEmp;
    }

    public Data getDataDev(){
        return dataDev;
    }

    public void setDataDev(Data dataDev){
        this.dataDev= dataDev;
    }

    public String toString(){
        return String.format("Livro: %s, Autor: %s, ISBN: %d, Emprestado: %s", titulo, autor, isbn, emprestado ? "SIM" : "NÃO");
    }
}  

