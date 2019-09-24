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
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
    Aluno aluno1 = new Aluno("Lulinha", 50, "Sistemas");
    Aluno aluno2 = new Aluno("Dilminha", 45, "Economia");
    Aluno aluno3 = new Aluno("Aecinho", 30, "Quimica");
    Aluno aluno4 = new Aluno("Morinho", 1, "Direito");
    Aluno aluno5 = new Aluno("Carlinhos", 1, "Producao");
    Aluno aluno6 = new Aluno("Bolsinho", 1, "Medicina");
    Aluno aluno7 = new Aluno("Manuzinha", 1, "Historia");
    Aluno aluno8 = new Aluno("Marininha", 1, "Geologia");
    Aluno aluno9 = new Aluno("Eneazinho", 1, "Engenharia Nuclear");
    Aluno aluno10 = new Aluno("Trumpzinho", 1, "Engenharia de Petróleo");
    
    Lista alunos = new Lista();
    alunos.inserirNaFrente(aluno1);
        alunos.inserirNaFrente(aluno2);
        alunos.inserirNaPosicao(1, aluno3);
        alunos.inserirNoFim(aluno4);
        alunos.inserirAntesDoAtual(aluno5);
        alunos.excluirPrim();
        alunos.inserirNoFim(aluno6);
        alunos.inserirNaFrente(aluno7);
        alunos.inserirNoFim(aluno8);
        alunos.inserirNaFrente(aluno9);
        alunos.inserirAntesDoAtual(aluno3);
        alunos.inserirNoFim(aluno9);

        alunos.inserirAposAtual(aluno8);
        alunos.inserirNoFim(aluno7);
        alunos.inserirNoFim(aluno6);
        alunos.inserirNoFim(aluno5);
    
    alunos.imprimeLista("Lista");
    
        // TODO code application logic here
    }
    
}
