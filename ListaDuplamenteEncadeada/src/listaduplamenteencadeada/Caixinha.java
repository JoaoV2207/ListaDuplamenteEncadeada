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


    public Caixinha (Aluno elemento, Caixinha anterior, Caixinha proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public Caixinha(Aluno elemento) {
        this.elemento = elemento;
    }

    public Caixinha() {

    }

    

    public Aluno getElemento() {
        return this.elemento;
    }
    
    public void setElemento(Aluno elemento) {
        this.elemento = elemento;
    }

    public Caixinha getAnterior() {
        return this.anterior;
    }

    public Caixinha getProximo() {
        return this.proximo;
    }

    public void setAnterior(Caixinha anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Caixinha proximo) {
        this.proximo = proximo;
    }
}
