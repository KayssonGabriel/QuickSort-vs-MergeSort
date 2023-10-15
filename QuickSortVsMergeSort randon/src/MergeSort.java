import java.util.Arrays;

public class MergeSort {

    public MergeSort(int[] vetor, String nomeArq) {

//        System.out.println("Vetor: " + Arrays.toString(vetor));

        long inicio = System.nanoTime(); // Use System.nanoTime() to measure the start time

        mergeSort(vetor);

        long fim = System.nanoTime(); // Use System.nanoTime() to measure the end time

        long tempoExe = fim - inicio;

        System.out.println("hr, min, seg, miliSeg, microSeg, nanoSeg, picosSeg");



        // Convert nanoseconds to the appropriate time format
        long picosSeg = tempoExe % 1_000; // Obtenha picossegundos
        tempoExe /= 1_000; // Converta para nanossegundos

        int nanoSeg = (int) (tempoExe % 1_000); // Obtenha nanossegundos
        tempoExe /= 1_000; // Converta para microssegundos

        int microSeg = (int) (tempoExe % 1_000); // Obtenha microssegundos
        tempoExe /= 1_000; // Converta para milissegundos

        int miliSeg = (int) (tempoExe % 1_000); // Obtenha milissegundos
        tempoExe /= 1_000; // Converta para segundos

        int seg = (int) (tempoExe % 60); // Obtenha segundos
        tempoExe /= 60; // Converta para minutos

        int min = (int) (tempoExe % 60); // Obtenha minutos
        tempoExe /= 60; // Converta para horas

        int hr = (int) (tempoExe); // Obtenha horas

        System.out.printf("%02d:%02d:%02d:%03d:%03d:%03d:%03d%n", hr, min, seg, miliSeg, microSeg, nanoSeg, picosSeg);

//        System.out.println(tempoExe);

//        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
    }
    private void mergeSort(int[] vetor) {
        ordenacao(vetor, 0, vetor.length - 1);
    }

    private void ordenacao(int[] vetor, int comeco, int fim) {
        int meio = (comeco + fim) / 2;

        if (comeco < fim) {
            ordenacao(vetor, comeco, meio);
            ordenacao(vetor, meio + 1, fim);
        }

        int i = 0;
        int primeiro = comeco;
        int ultimo = meio + 1;
        int[] tmp = new int[fim - comeco + 1];

        while (primeiro <= meio && ultimo <= fim) {

            tmp[i++] = vetor[primeiro] < vetor[ultimo] ? vetor[primeiro++] : vetor[ultimo++];
        }

        while (primeiro <= meio) {

            tmp[i++] = vetor[primeiro++];

        }

        while (ultimo <= fim) {

            tmp[i++] = vetor[ultimo++];

        }

        i = 0;

        while (comeco <= fim) {

            vetor[comeco++] = tmp[i++];

        }
    }
}
