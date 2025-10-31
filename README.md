Disciplina: Resolução de Problemas Estruturados;
Atividade: Supervisionada 01;

Academico:
Ian Carlo Araújo Braz

Objetivo
O objetivo deste trabalho foi desenvolver um programa em Java que simula um sistema de atendimento. O principal era construir as estruturas de dados do zero, sem utilizar as bibliotecas prontas (pra alegria da sala) de coleções do Java (como ArrayList, LinkedList, Stack, Queue).

o sistema é composto por duas estruturas principais, ambas implementadas com base em listas encadeadas:

Fila de Atendimento (FilaAtendimento.java): Gerencia a ordem de chegada dos clientes (Primeiro a Entrar, Primeiro a Sair - FIFO).

Pilha de Histórico (PilhaHistorico.java): Armazena um histórico de solicitações de serviço (Último a Entrar, Primeiro a Sair - LIFO).

Estrutura do Código
o projeto foi dividido nos seguintes arquivos:

Main.java: Classe principal que contém o menu interativo. Permite ao usuário testar as funcionalidades do sistema (adicionar cliente, atender cliente, visualizar fila, adicionar ao histórico). Utiliza a classe Scanner para ler a entrada do usuário.

NodeFila.java: Representa um "nó" (elemento) da fila. Esta classe armazena as informações do cliente (nome, id, motivo) e um ponteiro (proximo) que aponta para o próximo cliente na fila.

FilaAtendimento.java: Implementa a estrutura da Fila. Ela gerencia os ponteiros de frente (primeiro elemento) e tras (último elemento).

enqueue(): Adiciona um novo cliente ao final da fila (atualizando o ponteiro tras).

dequeue(): Remove o cliente do início da fila (atualizando o ponteiro frente).

estaVazia(): Verifica se o ponteiro frente é null.

NodePilha.java: Representa um "nó" (elemento) da pilha. Armazena as informações da solicitação (ID, descrição, data/hora) e um ponteiro (proximo) que aponta para o elemento abaixo dele na pilha.

PilhaHistorico.java: Implementa a estrutura da Pilha. Ela gerencia apenas o ponteiro do topo.

push(): Adiciona uma nova solicitação no topo da pilha. O novo nó aponta para o topo anterior.

pop(): Remove a solicitação do topo da pilha. O topo passa a ser o elemento proximo do nó removido.

estaVazia(): Verifica se o ponteiro topo é null.

Como Funciona (Explicação da Lógica)
A Pilha (Histórico)
a implementação da pilha (PilhaHistorico) nescessita apenas de um ponteiro de referência: topo.

Para empilhar (push):

Um novo NodePilha é criado com os dados da solicitação.

O ponteiro proximo do novo nó é configurado para apontar para o topo atual.

Aa referência do topo da pilha é atualizada para apontar para este novo nó.

Para desempilhar (pop):

Verifica-se se a pilha não está vazia (se topo não é null).

Salva-se a referência ao topo atual em uma variável temporária (para informar qual solicitação foi removida).

O topo da pilha é atualizado para ser o topo.proximo (o elemento que estava abaixo). O nó antigo é "esquecido" e será tratado pelo Garbage Collector do Java.

A Fila (Atendimento)
a implementação da fila (FilaAtendimento) requer dois ponteiros para um controle eficiente: frente e tras.

Para enfileirar (enqueue):

Um novo NodeFila é criado com os dados do cliente.

Caso especial (Fila Vazia): Se estaVazia() for verdadeiro, tanto a frente quanto o tras é atualizado para apontar para o novo nó.

Caso normal (Fila com elementos): O ponteiro proximo do nó tras atual é configurado para apontar para o novo nó. Em seguida, o tras é atualizado para ser esse novo nó.

Para desenfileirar (dequeue):

Verifica-se se a pilha não está vazia (se frente não é null).

Salva-se a referência ao nó da frente (para informar quem está sendo atendido).

O ponteiro frente é atualizado para aponttar para frente.proximo (o segundo elemento se torna o primeiro).

Caso especial (Esvaziamento da Fila): Se, após a atualização, a frente se tornar null (o que significa que só havia um elemento), devemos também atualizar o tras para null. Se caso isso não for feito, o ponteiro tras continuaria referenciando um elemento que já saiu da fila, causando inconsistência na estrutura.

Como Compilar e Rodar: 
Eu to rodando no InteliJ, mais facil.
