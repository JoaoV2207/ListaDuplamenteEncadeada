/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplamenteencadeada;

/**
 *
 * @author Bruno
 */
public class Lista {

    private Caixinha comeco;
    private Caixinha fim;
    private Caixinha cursor;
    private int contadorElem;

    public Lista() {
        this.comeco = new Caixinha();
        this.fim = new Caixinha();
        this.cursor = comeco;
        this.contadorElem = 0;
    }

    public void inserirAntesDoAtual(Aluno alunoP) {
   
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

    public void inserirAposAtual(Aluno alunoP) {
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

    public void inserirNaPosicao(int pos, Aluno alunoP) {
        if (comeco == null && fim == null) {
            this.inserirNaFrente(alunoP);
        } else if (pos >= this.contadorElem) {
            this.inserirNoFim(alunoP);
        } else if (pos <= this.contadorElem) {
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

    public void excluirAtual() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posicao não existe");
        } else {

            this.cursor.setElemento(null);

        }
    }

    public void excluirPrim() {
        if (this.comeco == null) {
            throw new IllegalArgumentException("Lista Vazia");
        } else {
            cursor = comeco.getProximo();
            this.comeco = comeco.getProximo();
            contadorElem--;
        }

    }

    public void excluirUlt() {
        if (this.fim == null) {
            throw new IllegalArgumentException("Lista Vazia");
        } else {
            cursor = fim.getAnterior();
            this.fim = fim.getAnterior();
            contadorElem--;
        }
    }

    public boolean Buscar(int ref) {
        irParaPrimeiro();
        return getPosicao(ref).getElemento() != null;
    }

    public Aluno acessaAtual() {
    System.out.println("Elemento Atual: " + cursor.getElemento());
        return cursor.getElemento();
    }

    public boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.contadorElem;
    }

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

    public void avancarKPosicoes(int k) {
        for (int i = 0; i < k; i++) {
            if (this.cursor.getProximo() != null) {
                this.cursor = this.cursor.getProximo();
            } else {
                throw new IllegalArgumentException("Impossivel avancar");
            }
        }
    }

    public void retrocederKPosicoes(int k) {
        for (int i = 0; i < k; i++) {
            if (this.cursor.getAnterior() != null) {
                this.cursor = this.cursor.getAnterior();
            } else {
                throw new IllegalArgumentException("Impossivel Retroceder");
            }
        }
    }

    public void irParaPrimeiro() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor = this.comeco;
    }

    public void irParaUltimo() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor = this.fim;
    }

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

