package cadastro;

public class Perecível {
    public static int id_perecivel;
    private double valor_perecivel;
    private String descricao_perecivel;
    private int dia, mes, ano;

    // Construtor
    public Perecível(int id_perecivel, double valor_perecivel, String descricao_perecivel, int dia, int mes, int ano) {
        this.id_perecivel = id_perecivel;
        this.valor_perecivel = valor_perecivel;
        this.descricao_perecivel = descricao_perecivel;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Métodos de acesso (getters e setters)
    public int getIdperecivel() {
        return id_perecivel;
    }

    public void setIdperecivel(int id_perecivel) {
        this.id_perecivel = id_perecivel;
    }

    public double getValorperecivel() {
        return valor_perecivel;
    }

    public void setValorperecivel(double valor_perecivel) {
        this.valor_perecivel = valor_perecivel;
    }

    public String getDescricaoperecivel() {
        return descricao_perecivel;
    }

    public void setDescricaoperecivel(String descricao_perecivel) {
        this.descricao_perecivel = descricao_perecivel;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
