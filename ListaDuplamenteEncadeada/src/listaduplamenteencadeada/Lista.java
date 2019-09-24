/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplamenteencadeada;

/**
 *
 * @author Joao
 */
public class Lista {

    private Caixinha comeco;
    private Caixinha fim;
    private Caixinha cursor;
    private int contadorElem;

    /**
     *
     */
    public Lista() {
        this.comeco = new Caixinha();
        this.fim = new Caixinha();
        this.cursor = comeco;
        this.contadorElem = 0;
    }

    /**
     * insere um aluno dentro de uma caixa inserida pelo metodo. o metodo checa
     * se nao existe nenhum elemento na fila e se o cursor é o primeiro, se essas condições forem verdadeiras inserira no inicio da fila
     * se essas condicoes nao forem verdadeiras inserira na caixa anterior ao cursor
     * @param alunoP
     */
    public void inserirAntesDoAtual(Aluno alunoP) {
        if (comeco == null && fim == null) {
            this.inserirNaFrente(alunoP);
        }
        if (this.cursor.getAnterior() == null) {
            this.inserirNaFrente(alunoP);

        } else {
            Caixinha caixa = new Caixinha(alunoP);

            caixa.setAnterior(this.cursor.getAnterior());
            caixa.setProximo(this.cursor);
            this.cursor.getAnterior().setProximo(caixa);
            this.cursor.setAnterior(caixa);
            this.cursor = caixa;
            this.contadorElem++;
        }

    }

    /**
     insere um aluno dentro de uma caixa inserida pelo metodo. o metodo checa
     * se nao existe nenhum elemento na fila e se o cursor é o ultimo, se essas condições forem verdadeiras inserira no inicio da fila
     * se essas condicoes nao forem verdadeiras inserira na caixa anterior ao cursor
     * @param alunoP
     */
    public void inserirAposAtual(Aluno alunoP) {
        if (comeco == null && fim == null) {
            this.inserirNaFrente(alunoP);
        }
        if (this.cursor.getProximo() == null) {
            this.inserirNoFim(alunoP);
        } else {
            Caixinha caixa = new Caixinha(alunoP);
            caixa.setAnterior(cursor);
            caixa.setProximo(cursor.getProximo());
            this.cursor.getProximo().setAnterior(caixa);
            this.cursor.setProximo(caixa);
            this.cursor = caixa;
            this.contadorElem++;
        }
    }

    /**
     * insere um aluno dentro de uma caixa inserida pelo metodo. O metodo checa se a fila esta vazia inserindo no inicio e no fim se for verdadeiro
     * se nao for inserira no fim da fila, ou seja tornara o ultimo da fila seu anterior e sera o proximo desse elemento 
     * @param alunoP
     */
    public void inserirNoFim(Aluno alunoP) {
        Aluno aluno = new Aluno(alunoP.getNome(), alunoP.getIdade(), alunoP.getCurso());
        Caixinha caixa = new Caixinha(aluno);

        if (comeco == null && fim == null) {
            this.comeco = caixa;
            this.fim = caixa;
            this.cursor = caixa;
        } else {
            caixa.setAnterior(fim);
            fim.setProximo(caixa);
            this.fim = caixa;
            this.cursor = caixa;
        }
        this.contadorElem++;
    }

    /**
     *insere um aluno dentro de uma caixa inserida pelo metodo. O metodo checa se a fila esta vazia inserindo no inicio e no fim se for verdadeiro
     * se nao for inserira no inicio da fila, ou seja tornara o primeiro da fila seu proximo e sera o anterior desse elemento 
     * @param alunoP
     */
     
    public void inserirNaFrente(Aluno alunoP) {
        Aluno aluno = new Aluno(alunoP.getNome(), alunoP.getIdade(), alunoP.getCurso());
        Caixinha caixa = new Caixinha(aluno);

        if (comeco == null && fim == null) {
            this.comeco = caixa;
            this.fim = caixa;
            this.cursor = caixa;
        } else {
            caixa.setProximo(comeco);
            comeco.setAnterior(caixa);
            this.comeco = caixa;
            this.cursor = comeco;
        }
        this.contadorElem++;
    }

    /**
     * insere um aluno dentro de uma caixa inserida pelo metodo. O metodo checa se a lista esta vazia e se a posicao passada pelo metodo existe
     * se nao existir, inserirá na frente se for menor que 1 e inserira no fim se for maior que o numero de elementos
     * se existir usara a posicao passada para definir o anterior e o proximo da caixinha criada
     * @param pos
     * @param alunoP
     */
    public void inserirNaPosicao(int pos, Aluno alunoP) {
        if (comeco == null && fim == null) {
            this.inserirNaFrente(alunoP);
        } else if (pos >= this.contadorElem) {
            this.inserirNoFim(alunoP);
        } else if (pos <= 1) {
            this.inserirNaFrente(alunoP);
        } else {
            Caixinha caixaTemp = getPosicao(pos - 1);
            Aluno aluno = new Aluno(alunoP.getNome(), alunoP.getIdade(), alunoP.getCurso());
            Caixinha caixa = new Caixinha(aluno);

            caixa.setAnterior(caixaTemp);
            caixa.setProximo(caixaTemp.getProximo());
            caixaTemp.getProximo().setAnterior(caixa);
            caixaTemp.setProximo(caixa);
            cursor = caixa;
            this.contadorElem++;

        }
    }

    /**
     *  o metodo exclui uma caixinha ja existente (checa se existe).
     * a caixinha excluida e a caixinha apontada pelo cursor, setando seu anterior como anterior da caixinha a sua frente e vice versa
     */
    public void excluirAtual() {
        Caixinha atual = acessaAtual();
        if (atual.getAnterior() != null) {
            Caixinha anteriorAtual = atual.getAnterior();
            Caixinha proximoAtual = atual.getProximo();

            anteriorAtual.setProximo(proximoAtual);
            proximoAtual.setAnterior(anteriorAtual);
            this.cursor = anteriorAtual;
            atual.setAnterior(null);
            atual.setProximo(null);
        } else {
            excluirPrim();
        }
    }

    /**
     *  o metodo exclui uma caixinha ja existente (checa se existe) 
     * a caixinha excluida e a primaira da lista se a lista nao estiver vazia, setando o proxmo como o comeco
     */
    public void excluirPrim() {
        if (this.comeco == null) {
            throw new IllegalArgumentException("Lista Vazia");
        } else {
            cursor = comeco.getProximo();
            this.comeco = comeco.getProximo();
            contadorElem--;
        }

    }

    /**
     * o metodo exclui uma caixinha ja existente (checa se existe) 
     * a caixinha excluida e a ultima da lista se a lista nao estiver vazia, setando o anterior como o fim
     */
    public void excluirUlt() {
        if (this.fim == null) {
            throw new IllegalArgumentException("Lista Vazia");
        } else {
            cursor = fim.getAnterior();
            this.fim = fim.getAnterior();
            contadorElem--;
        }
    }

    /**
     * Utiliza o metodo getPosicao para buscar um elemento listado
     * @param ref
     * @return boolean
     */
    public boolean Buscar(int ref) {
        irParaPrimeiro();
        return getPosicao(ref).getElemento() != null;
    }

    /**
     * Acessa a caixinha que o cursor tem apontado
     * @return Caixinha
     */
    public Caixinha acessaAtual() {
        System.out.println("Elemento Atual: " + cursor.getElemento());
        return cursor;
    }

    /**
     * checa se a posicao ja esta ocupada
     * @param posicao
     * @return boolean
     */
    public boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.contadorElem;
    }

    
    /**
     * Pega a posicao para ser usada posteriormente em uma caixinha temporaria
     * @param pos
     * @return boolean
     */
    private Caixinha getPosicao(int pos) {
        if (!this.posicaoOcupada(pos)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Caixinha atual = comeco;
        for (int i = 0; i < pos; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }
    //-Metodos do cursor-

    /**
     * avanca o cursor em relacao a um parametro em uma lista
     * @param k
     */
    public void avancarKPosicoes(int k) {
        for (int i = 0; i < k; i++) {
            if (this.cursor.getProximo() != null) {
                this.cursor = this.cursor.getProximo();
            } else {
                throw new IllegalArgumentException("Impossivel avancar");
            }
        }
    }

    /**
     * retorna o cursor em relacao a um parametro em uma lista
     * @param k
     */
    public void retrocederKPosicoes(int k) {
        for (int i = 0; i < k; i++) {
            if (this.cursor.getAnterior() != null) {
                this.cursor = this.cursor.getAnterior();
            } else {
                throw new IllegalArgumentException("Impossivel Retroceder");
            }
        }
    }

    /**
     * seta o cursor para o primeiro da lista, apos isso checa se ele e null para dar uma excessao
     */
    public void irParaPrimeiro() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor = this.comeco;
    }

    /**
     * seta o cursor para o ultimo da lista, apos isso checa se ele e null para dar uma excessao
     */
    public void irParaUltimo() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor = this.fim;
    }

    /**
     * imprime a lista selecionada em console
     * @param message
     */
    public void imprimeLista(String message) {
        irParaPrimeiro();
        StringBuilder mostraNaTela = new StringBuilder();
        try {
            mostraNaTela.append("[");
            while (this.cursor.getProximo() != null) {
                mostraNaTela.append(this.cursor.getElemento().getNome().toString());
                mostraNaTela.append(", ");
                this.cursor = this.cursor.getProximo();
            }
            mostraNaTela.append(this.fim.getElemento().getNome().toString());
            mostraNaTela.append("]");
            System.out.println(message + mostraNaTela);
        } catch (NullPointerException e) {

            System.out.println("Foi tentado acessar informação nula");
        }

    }
}
