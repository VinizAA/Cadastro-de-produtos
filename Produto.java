package cadastro;

public class Produto {
    public static int id;
    public static double valor;
    public static String descricao;
    public static int quantidade;

    // Construtor
    public Produto(int id, double valor, String descricao, int quantidade) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    // Métodos de acesso (getters e setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

