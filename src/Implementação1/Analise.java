package Implementação1;

public class Analise {
    static int vetor[] = new int[100];
    static int vetor2[] = new int[1000];
    static int vetor3[] = new int[10000];
    static long antes, depois, tempo, media=0;
    
    public static void main(String[] args) {
        
        System.out.println("N\tLinear\tBinária");
        long tlinear = analiseLinear(vetor);
        long tbinario = analiseBinaria(vetor);
        System.out.println("100\t"+tlinear+"\t"+tbinario);
        long tlinear2 = analiseLinear(vetor2);
        long tbinario2 = analiseBinaria(vetor2);
        System.out.println("1000\t"+tlinear2+"\t"+tbinario2);
        long tlinear3 = analiseLinear(vetor3);
        long tbinario3 = analiseBinaria(vetor3);
        System.out.println("10000\t"+tlinear3+"\t"+tbinario3);
        
}
    
    public static long analiseLinear(int vet[]){
        media=0;
        for(int j=0;j<10;j++){
            antes = System.nanoTime();
            buscaLinear(-1, vet);
            depois = System.nanoTime();
            media += depois - antes;
        }
        return(media/10);
    }
    
    public static long analiseBinaria(int vet[]){
        media=0;
        for(int j=0;j<10;j++){
            antes = System.nanoTime();
            buscaBinaria(-1, vet);
            depois = System.nanoTime();
            media += depois - antes;
        }
        return(media/10);
    }
    
    public static int buscaLinear(int elemento, int vet[]){
        int i=0;
        while( i < vet.length && vet[i] != elemento){
            i++;
        }
        return (i != vet.length)? i : -1;
    }


    public static int buscaBinaria(int elemento, int vet[]){
        int inicio = 0;
        int fim = vet.length-1;
        int meio;
        while( inicio < fim){
            meio = (inicio+fim)/2;
            if(vet[meio] < elemento){
                inicio = meio + 1;
            }else{
                fim = meio;
            }    
        }
        return (vet[fim]==elemento)? fim : -1;
    }

}
