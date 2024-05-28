import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {

    private Map<String, String> contatti;

    public RubricaTelefonica() {
        this.contatti = new HashMap<>();
    }

    public void aggiungiContatto(String nome, String telefono) {
        contatti.put(nome, telefono);
        System.out.println("Contatto aggiunto: " + nome + " - " + telefono);
    }

    public void rimuoviContatto(String nome) {
        if (contatti.containsKey(nome)) {
            contatti.remove(nome);
            System.out.println("Contatto rimosso: " + nome);
        } else {
            System.out.println("Contatto non trovato: " + nome);
        }
    }

    public String cercaNomePerNumero(String telefono) {
        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            if (entry.getValue().equals(telefono)) {
                return entry.getKey();
            }
        }
        return "Numero di telefono non trovato.";
    }

    public String cercaNumeroPerNome(String nome) {
        return contatti.getOrDefault(nome, "Nome non trovato.");
    }

    public void stampaContatti() {
        if (contatti.isEmpty()) {
            System.out.println("Rubrica vuota.");
        } else {
            System.out.println("Rubrica telefonica:");
            for (Map.Entry<String, String> entry : contatti.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        RubricaTelefonica rubrica = new RubricaTelefonica();

        rubrica.aggiungiContatto("Mario Rossi", "1234567890");
        rubrica.aggiungiContatto("Luigi Bianchi", "0987654321");

        rubrica.stampaContatti();

        System.out.println("Numero di Mario Rossi: " + rubrica.cercaNumeroPerNome("Mario Rossi"));
        System.out.println("Nome del numero 0987654321: " + rubrica.cercaNomePerNumero("0987654321"));

        rubrica.rimuoviContatto("Luigi Bianchi");
        rubrica.stampaContatti();

        System.out.println("Nome del numero 0987654321: " + rubrica.cercaNomePerNumero("0987654321"));
    }
}
