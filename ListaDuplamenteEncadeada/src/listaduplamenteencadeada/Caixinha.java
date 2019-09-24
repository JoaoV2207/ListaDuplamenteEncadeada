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
public class Caixinha {
private Aluno elemento;
 private Caixinha anterior;
    private Caixinha proximo;

    /**
     *
     * @param elemento
     * @param anterior
     * @param proximo
     */
    public Caixinha (Aluno elemento, Caixinha anterior, Caixinha proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    /**
     *
     * @param elemento
     */
    public Caixinha(Aluno elemento) {
        this.elemento = elemento;
    }

    /**
     *
     */
    public Caixinha() {

    }

    /**
     *
     * @return
     */
    public Aluno getElemento() {
        return this.elemento;
    }
    
    /**
     *
     * @param elemento
     */
    public void setElemento(Aluno elemento) {
        this.elemento = elemento;
    }

    /**
     *
     * @return
     */
    public Caixinha getAnterior() {
        return this.anterior;
    }

    /**
     *
     * @return
     */
    public Caixinha getProximo() {
        return this.proximo;
    }

    /**
     *
     * @param anterior
     */
    public void setAnterior(Caixinha anterior) {
        this.anterior = anterior;
    }

    /**
     *
     * @param proximo
     */
    public void setProximo(Caixinha proximo) {
        this.proximo = proximo;
    }
}
