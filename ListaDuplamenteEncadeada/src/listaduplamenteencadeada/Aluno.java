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
public class Aluno {
    
 private String nome;
    private int idade;
    private String curso;

    /**
     *
     * @param nome
     * @param idade
     * @param curso
     */
    public Aluno(String nome, int idade, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    /**
     *
     */
    public Aluno() {

    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public int getIdade() {
        return idade;
    }

    /**
     *
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     *
     * @return
     */
    public String getCurso() {
        return curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
