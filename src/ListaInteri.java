import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListaInteri {

    public static List<Integer> generaListaOrdinata(int n) {
        List<Integer> lista = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            lista.add(rand.nextInt(101));
        }

        Collections.sort(lista);
        return lista;
    }

    public static List<Integer> combinaListe(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> listaMescolata = new ArrayList<>(lista);
        Collections.shuffle(listaMescolata);
        nuovaLista.addAll(listaMescolata);
        return nuovaLista;
    }

    public static void stampaValori(List<Integer> lista, boolean posizionePari) {
        for (int i = 0; i < lista.size(); i++) {
            if (posizionePari && i % 2 == 0) {
                System.out.println("Posizione pari " + i + ": " + lista.get(i));
            } else if (!posizionePari && i % 2 != 0) {
                System.out.println("Posizione dispari " + i + ": " + lista.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di elementi (N): ");
        int n = scanner.nextInt();

        List<Integer> listaOrdinata = generaListaOrdinata(n);
        System.out.println("Lista ordinata: " + listaOrdinata);

        List<Integer> listaCombinata = combinaListe(listaOrdinata);
        System.out.println("Lista combinata: " + listaCombinata);

        System.out.print("Vuoi stampare i valori in posizione pari (true) o dispari (false)? ");
        boolean posizionePari = scanner.nextBoolean();

        stampaValori(listaCombinata, posizionePari);

        scanner.close();
    }
}
