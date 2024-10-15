package model;

import java.util.Scanner;

public class Data{

    int dia, mes, ano;


    public Data(int dia, int mes, int ano) {
        if(!validarData(dia, mes, ano)){
            System.out.println("Digite uma data válida.");
            capturarData();
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

     boolean validarData(int dia, int mes, int ano){
        if (ano < 1900 || ano > 2100) {
            return false;
        }
        
        if (mes < 1 || mes > 12) {
            return false;
        }
       
        if (dia < 1 || dia > 31) {
            return false;
        }
        
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            return false;
        }
        
        if (mes == 2) {
            boolean bissexto = (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
            if (dia > 29 || (dia == 29 && !bissexto)) {
                return false;
            }
        }
        return true;
    }
    
    
    
    
    public int getDia(){
        return dia;

    }

    public void setDia(int dia){
        if(validarData(dia, this.mes, this.ano)){
            this.dia = dia;
        } else{
            throw new IllegalArgumentException("Dia inválido: " + dia + "/" + this.mes + "/"+ this.ano);
        }
    }

    public int getMes(){
        return mes;

    }

    public void setMes(int mes){
        if(validarData(this.dia, mes, this.ano)){
            this.mes = mes;
        } else{
            throw new IllegalArgumentException("Mês inválido: " + this.dia + "/" + mes + "/" + this.ano);
        }


    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(validarData(this.dia, this.mes, ano)){
            this.ano = ano;
        } else{
            throw new IllegalArgumentException("Ano inválido: " + this.dia + "/" + this.mes + "/" + ano);
        }
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }


    public static Data capturarData(){
        Scanner input = new Scanner(System.in);
    
        int dia, mes, ano;

        System.out.println("Digite a data no formato dd/mm/aaaa ! ");

        String[] partes = input.nextLine().split("/");

        if(partes.length !=3){
            System.out.println("FORMATO DE DATA INVÁLIDO! UTILIZE dd/mm/aaaa");
            partes = input.nextLine().split("/");

        }   

        dia = Integer.parseInt(partes[0]);
        mes = Integer.parseInt(partes[1]);
        ano = Integer.parseInt(partes[2]);


        return new Data(dia, mes, ano);
    }

}


