/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author Gabriel Mattos
 */
public class Jogador
{
    private String nome;
    private Tabuleiro tabuleiroJogador;
    private int numVitorias=0;
    Scanner teclado = new Scanner(System.in);
    
    public Jogador(String nome)
    {
        this.nome="Comandante "+nome;
        tabuleiroJogador = new Tabuleiro();
    }
    
    public void inserirEmbarcacao(Embarcacao nav, int i, int j, char dir)
    {
        try
        {
            tabuleiroJogador.inserirEmbarcacao(nav, i, j, dir);
            tabuleiroJogador.imprimirTabuleiro();
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Não foi possivel inserir nessa posição. Embarcação sai do mada. Insira novamente.");
            System.out.println("Digite a linha:");
            i=teclado.nextInt();
            System.out.println("Digite a coluna:");
            j=teclado.nextInt();
            teclado.nextLine();
            System.out.println("Digite a direcao:");
            dir=teclado.nextLine().charAt(0);
            inserirEmbarcacao(nav, i, j, dir);
        }
        catch(Exception a)
        {
            System.out.println("Não foi possivel inserir nessa posição. Emcarcações sobrepostas. Insira novamente.");
            System.out.println("Digite a linha:");
            i=teclado.nextInt();
            System.out.println("Digite a coluna:");
            j=teclado.nextInt();
            teclado.nextLine();
            System.out.println("Digite a direcao:");
            dir=teclado.nextLine().charAt(0);
            inserirEmbarcacao(nav, i, j, dir);
        }
        
    }
    
    public void imprimirTabuleiro()
    {
        tabuleiroJogador.imprimirTabuleiro();
    }
    
    public void imprimirTabuleiroParaOponente()
    {
        tabuleiroJogador.imprimirTabuleiroParaOponente();
    }
    
    public void recebeTiro(int i, int j)
    {
        tabuleiroJogador.recebeTiro(i, j);
    }
    
    public boolean estaVivo()
    {
        if(tabuleiroJogador.retornaNumEmbarcacoes()==0)
        {
            return false;
        }
        else
            return true;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNumVitorias()
    {
        this.numVitorias++;
    }
    
    public int getNumVitorias()
    {
        return this.numVitorias;
    }
}
