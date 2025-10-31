// armazenar os dados do cliente na Fila
public class Cliente {
    String nome;
    String idCliente;
    String motivo;

    // inicializa o objeto Cliente
    public Cliente(String nome, String idCliente, String motivo) {
        this.nome = nome;
        this.idCliente = idCliente;
        this.motivo = motivo;
    }

    // formatar a saída de dados do cliente
    public String getInfo() {
        return "Cliente: " + this.nome + " (ID: " + this.idCliente + ") - Motivo: " + this.motivo;
    }

    public String getNome() {
        return this.nome;
    }
}
