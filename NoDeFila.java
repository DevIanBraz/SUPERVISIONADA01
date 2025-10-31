// Nó da lista encadreada para a Fila
public class NoDeFila {
    Cliente cliente; // O dado armazenado
    NoDeFila proximo; // Aponteiro para o próximo nó

    // Construtor do Nó
    public NoDeFila(Cliente cliente) {
        this.cliente = cliente;
        this.proximo = null; //o próximo é nulo
    }
}
