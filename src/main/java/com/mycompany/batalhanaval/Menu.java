/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;
import java.util.*;
import Model.*;

/**
 *
 * @author Gabriel Mattos
 */
public class Menu
{
    public static List <Embarcacao> listaEmbarcacao = new ArrayList<>();
    
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        
        int i, j;
        char dir;
        
        listaEmbarcacao.add(new PortaAvioes());
        listaEmbarcacao.add(new NaviosTanque());
        listaEmbarcacao.add(new Contratorpedeiros());
        listaEmbarcacao.add(new Submarinos());
        
        String nome1, nome2;
        System.out.println("Informe o nome do jogador 1:");
        nome1=teclado.nextLine();
        System.out.println("Informe o nome do jogador 2:");
        nome2=teclado.nextLine();
        
        Jogador jogador1 = new Jogador(nome1);
        Jogador jogador2 = new Jogador(nome2);
        
        System.out.println("Jogador 1:\n");
        for(int k=0; k<4; k++)
        {
            System.out.println("Insira o "+listaEmbarcacao.get(k).getClass().getSimpleName()+":");
                    
            System.out.println("Digite a linha:");
            i=teclado.nextInt();
            System.out.println("Digite a coluna:");
            j=teclado.nextInt();
            teclado.nextLine();
            System.out.println("Digite a direcao:");
            dir=teclado.nextLine().charAt(0);
                    
            jogador1.inserirEmbarcacao(listaEmbarcacao.get(k), i, j, dir);
        }
        
        System.out.println("Jogador 2:\n");
        for(int k=0; k<4; k++)
        {
            System.out.println("Insira o "+listaEmbarcacao.get(k).getClass().getSimpleName()+":");
                    
            System.out.println("Digite a linha:");
            i=teclado.nextInt();
            System.out.println("Digite a coluna:");
            j=teclado.nextInt();
            teclado.nextLine();
            System.out.println("Digite a direcao:");
            dir=teclado.nextLine().charAt(0);
                    
            jogador2.inserirEmbarcacao(listaEmbarcacao.get(k), i, j, dir);
        }
        
        
        
        
        int opcao;
        do
        {
            System.out.println("1 – Começar a partida\n" +
                            "2 – Exibir recordista\n" +
                            "3 – Sair do jogo");
        
            opcao = teclado.nextInt();
            
        
        switch(opcao)
        {
            case 1:
                do
                {
                    System.out.println(jogador1.getNome()+" faz o ataque:");
                    jogador2.imprimirTabuleiroParaOponente();
                    System.out.println("Digite a linha:");
                    i=teclado.nextInt();
                    System.out.println("Digite a coluna:");
                    j=teclado.nextInt();
                    teclado.nextLine();
                    jogador2.recebeTiro(i, j);
                    jogador2.imprimirTabuleiroParaOponente();
                    
                    if(!jogador2.estaVivo())
                    {
                        continue;
                    }
                    
                    System.out.println(jogador2.getNome()+" faz o ataque:");
                    jogador1.imprimirTabuleiroParaOponente();
                    System.out.println("Digite a linha:");
                    i=teclado.nextInt();
                    System.out.println("Digite a coluna:");
                    j=teclado.nextInt();
                    teclado.nextLine();
                    jogador1.recebeTiro(i, j);
                    jogador1.imprimirTabuleiroParaOponente();
                }
                while(jogador1.estaVivo() && jogador2.estaVivo());
                
                if(!jogador1.estaVivo())
                {
                    System.out.println(jogador2.getNome()+" venceu!!");
                    jogador2.setNumVitorias();
                }
                else
                {
                    System.out.println(jogador1.getNome()+" venceu!!");
                    jogador1.setNumVitorias();
                }
                jogador1.imprimirTabuleiro();
                jogador2.imprimirTabuleiro();
                break;
                
            case 2:
                System.out.println("Pontuação:");
                System.out.println("1 - "+jogador1.getNome()+" -> "+jogador1.getNumVitorias());
                System.out.println("1 - "+jogador2.getNome()+" -> "+jogador2.getNumVitorias());
                break;
                
            case 3:
                break;
                
            
        }
    }while(opcao!=3);
        
    }
}
