import java.util.Arrays;

public class QuickSort {

    public QuickSort(int[] vetor, String nomeArq) {

        //        System.out.println("Vetor: " + Arrays.toString(vetor));

        long inicio = System.nanoTime(); // Use System.nanoTime() to measure the start time

        ordenacao(vetor, 0, vetor.length - 1);

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

    private void ordenacao(int[] vetor, int lEsquerdo, int lDireito) {

        if (lEsquerdo < lDireito) {
            int indicePivot = separacao(vetor, lEsquerdo, lDireito);
            try {
                ordenacao(vetor, lEsquerdo, indicePivot);
                ordenacao(vetor, indicePivot + 1, lDireito);
            } catch (StackOverflowError so) {
                System.out.print("");
            }
        }
    }

    private void troca(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;

    }

    private int separacao(int[] vetor, int lEsquerdo, int lDireito) {
        int meio = (int) (lEsquerdo + lDireito) / 2;
        int pivot = vetor[meio];
        int i = lEsquerdo - 1;
        int j = lDireito + 1;

        while (true) {
            do {
                i++;
            } while (vetor[i] < pivot);

            do {
                j--;
            } while (vetor[j] > pivot);

            if (i >= j)
                return j;

            troca(vetor, i, j);
        }
    }
}