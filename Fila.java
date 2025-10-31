// Implementa a Fila (Queue) usando lista encadeada (FIFO - First-In, First-Out)
public class Fila {
    private NoDeFila frente; // Referência ao início da fila
    private NoDeFila tras; // Referência ao fim da fila

    // Construtor
    public Fila() {
        this.frente = null;
        this.tras = null;
    }

    // See a fila está vazia
    public boolean estaVazia() {
        return this.frente == null;
    }

    // Método para adicionar um cliente à fila (Enqueue)
    public void adicionar(Cliente cliente) {
        NoDeFila novoNode = new NoDeFila(cliente);

        // Se a fila está vazia, o novo nó é tanto a frente quanto o fim
        if (estaVazia()) {
            this.frente = novoNode;
            this.tras = novoNode;
        } else {
            // Se não, o nó antigo (tras) aponta para o novo nó
            this.tras.proximo = novoNode;
            // O novo nó se torna o fim (tras)
            this.tras = novoNode;
        }
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila.");
    }

    // próximo cliente (Dequeue)
    public Cliente atender() {
        // Se a fila estiver vazia, não há ninguém para atender
        if (estaVazia()) {
            return null;
        }

        // Pega o cliente da frente da fila
        Cliente clienteAtendido = this.frente.cliente;

        // Move a 'frente' para o próximo nó da lista
        this.frente = this.frente.proximo;

        // Se a fila ficou vazia após a remoção, o 'tras' também deve ser nulo.
        if (this.frente == null) {
            this.tras = null;
        }

        // retorna o cliente que foi atendido
        return clienteAtendido;
    }

    // visualizar a ordem de atendimento
    public void verFila() {
        if (estaVazia()) {
            System.out.println("A fila de atendimento está vazia.");
            return;
        }

        System.out.println("--- Fila de Atendimento Atual ---");
        NoDeFila atual = this.frente; // Começa do início
        int posicao = 1;

        // Itera pela lista encadeada do início ao fim
        while (atual != null) {
            System.out.println(posicao + ". " + atual.cliente.getInfo());
            atual = atual.proximo;
            posicao = posicao + 1;
        }
        System.out.println("---------------------------------");
    }
}
