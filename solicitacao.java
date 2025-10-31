// armazena os dados da solicitação na Pilha
public class Solicitacao {
    String idSolicitacao;
    String descricao;
    String dataHora;

    // Construtor para inicializar o objeto Solicitacao
    public Solicitacao(String idSolicitacao, String descricao, String dataHora) {
        this.idSolicitacao = idSolicitacao;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    // formata a saída de dados da solicitação
    public String getInfo() {
        return "Solicitação ID: " + this.idSolicitacao + " [" + this.dataHora + "] - " + this.descricao;
    }
}
