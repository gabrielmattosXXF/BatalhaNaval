/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Gabriel Mattos
 */
public class Tabuleiro
{
    private char[][] tabuleiro= new char[10][10];
    private int numEmbarcacoes=14;
    
    public Tabuleiro()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                tabuleiro[i][j]='*';
            }
        }
    }
    
    public void inserirEmbarcacao(Embarcacao nav, int i, int j, char dir) throws IndexOutOfBoundsException, Exception
    {
        int tam=nav.getTam();
        System.out.println(tam);
        
        switch(dir)
        {
            case 'd'://pode fazer a inserção de trás pra frente pra saber se a última posição é válida
                
                for(int k=tam-1; k>=0; k--)
                {
                    if(this.tabuleiro[i][j+k]=='E')
                    {
                        for(int l=tam-1; l>=0; l--)
                        {
                            if((j+l)!=(j+k))
                                this.tabuleiro[i][j+l]='*';
                        }
                        throw new Exception();
                    }
                    
                    this.tabuleiro[i][j+k]='E';
                }
                break;
                
            case 'e':
                
                for(int k=tam-1; k>=0; k--)
                {
                    if(this.tabuleiro[i][j-k]=='E')
                    {
                        for(int l=tam-1; l>=0; l--)
                        {
                            if((j-l)!=(j-k))
                                this.tabuleiro[i][j-l]='*';
                        }
                        throw new Exception();
                    }
                    
                    this.tabuleiro[i][j-k]='E';
                }
                break;
                
            case 'c':
                
                for(int k=tam-1; k>=0; k--)
                {
                    if(this.tabuleiro[i-k][j]=='E')
                    {
                        for(int l=tam-1; l>=0; l--)
                        {
                            if((i-l)!=(i-k))
                                this.tabuleiro[i-l][j]='*';
                        }
                        throw new Exception();
                    }
                    
                    this.tabuleiro[i-k][j]='E';
                }
                break;
                
            case 'b':
                
                for(int k=tam-1; k>=0; k--)
                {
                    if(this.tabuleiro[i+k][j]=='E')
                    {
                        for(int l=tam-1; l>=0; l--)
                        {
                            if((i+l)!=(i+k))
                                this.tabuleiro[i+1][j]='*';
                        }
                        throw new Exception();
                    }
                    
                    this.tabuleiro[i+k][j]='E';
                }
                break;
                
        }
    }
    
    public void imprimirTabuleiro()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                System.out.printf("%c ", tabuleiro[i][j]);
            }
                System.out.println("");
        }
    }
    
    public void imprimirTabuleiroParaOponente()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                if(tabuleiro[i][j]=='E' || tabuleiro[i][j]=='*')
                {
                    System.out.printf("%c ", '*');
                }
                else
                {
                    System.out.printf("%c ", tabuleiro[i][j]);
                }
                    
            }
                System.out.println("");
        }
    }
    
    public void recebeTiro(int i, int j)
    {
        if(tabuleiro[i][j]=='E')
        {
            tabuleiro[i][j]='D';
            numEmbarcacoes--;
            System.out.println("FOGO");
        }
        else
            System.out.println("AGUA");
    }
    
    public int retornaNumEmbarcacoes()
    {
        return numEmbarcacoes;
    }
}
