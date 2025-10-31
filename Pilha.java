// Implementa a Pilha usando lista encadeada LIFO
public class Pilha {
    private NoDePilha topo; // Referencia ao topo da pilha

    // Construtor
    public Pilha() {
        this.topo = null;
    }

    // verifica se a pilha ta vazia
    public boolean estaVazia() {
        return this.topo == null;
    }

    // Adiciona uma solicitação ao histórico (Push)
    public void adicionar(Solicitacao solicitacao) {
        NoDePilha novoNode = new NoDePilha(solicitacao);

        // O 'proximo' do novo nó aponta para o topo antigo
        novoNode.proximo = this.topo;
        // O novo nó se torna o novo topo
        this.topo = novoNode;

        System.out.println("Solicitação " + solicitacao.idSolicitacao + " adicionada ao histórico.");
    }

    // remove uma solicitação do histórico, se chama Pop
    public Solicitacao remover() {
        // Se a pilha estiver vazia, não há o que remover
        if (estaVazia()) {
            return null;
        }

        // pega a solicitação do topo
        Solicitacao solicitacaoRemovida = this.topo.solicitacao;

        // move o 'topo' para o próximo nó (o topo anterior)
        this.topo = this.topo.proximo;

        // a solicitação que foi removida
        return solicitacaoRemovida;
    }

    // Mmtodo para visualizar o histórico de solicitações
    public void verHistorico() {
        if (estaVazia()) {
            System.out.println("O histórico de solicitações está vazio.");
            return;
        }

        System.out.println("--- Histórico de Solicitações (Mais recente primeiro) ---");
        NoDePilha atual = this.topo; // Começa do topo

        // intera pela lista encadeada do topo até a base
        while (atual != null) {
            System.out.println("- " + atual.solicitacao.getInfo());
            atual = atual.proximo;
        }
        System.out.println("-------------------------------------------------------");
    }
}
