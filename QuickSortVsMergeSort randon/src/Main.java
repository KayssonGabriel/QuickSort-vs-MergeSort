import java.util.Random;
import java.util.Stack;

public class Main {

    public static QuickSort qs;
    public static MergeSort ms;

    public static void main(String[] args) {
        System.out.println("Iniciando...");

        int[] vetor1 = gerarVetorAleatorio(5000000);

        int[] vetor2 = vetor1.clone();

        System.out.println("Vetor pronto!!!");

        System.out.println("Quick Sort (Caso Medio) Pronto!!");
        qs = new QuickSort(vetor1, "Quick Sort (Caso Medio)");
        System.out.println();

        System.out.println("Merge Sort (Caso Medio) Pronto!!");
        ms = new MergeSort(vetor2, "Merge Sort (Caso Medio)");
        System.out.println();

        melhorCaso(vetor1);
        System.out.println();
        piorCaso(vetor1);
        System.out.println();

        System.out.println("Programa finalizado!!");
    }

    public static void melhorCaso(int[] vetor) {
        System.out.println("Melhor Caso Quick Sort Pronto!...");
        qs = new QuickSort(vetor.clone(), "Quick Sort (Melhor caso)");
        System.out.println();

        System.out.println("Melhor Caso Merge Sort Pronto!...");
        ms = new MergeSort(vetor.clone(), "Merge Sort (Melhor caso)");
        System.out.println();
    }

    public static void piorCaso(int[] vetor) {
        Stack<Integer> pilha = new Stack<>();

        for (int numero : vetor)
            pilha.push(numero);

        for (int i = 0; i < vetor.length; i++)
            vetor[i] = pilha.pop();

        System.out.println("Pior Caso Quick Sort Pronto!...");
        qs = new QuickSort(vetor.clone(), "Quick Sort (Pior caso)");
        System.out.println();

        System.out.println("Pior caso Merge Sort Pronto!...");
        ms = new MergeSort(vetor.clone(), "Merge Sort (Pior caso)");
        System.out.println();
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt();
        }

        return vetor;
    }
}