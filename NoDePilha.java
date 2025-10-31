// nó da lista encadeada para a Pilha
public class NoDePilha {
    Solicitacao solicitacao; // o dado armazenado
    NoDePilha proximo; //ponteiro para o próximo nó

    // Construtor do Nó
    public NoDePilha(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
        this.proximo = null; //o próximo é nulo
    }
}
