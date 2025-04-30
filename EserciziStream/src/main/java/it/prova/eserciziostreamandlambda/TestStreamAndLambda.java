package main.java.it.prova.eserciziostreamandlambda;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class TestStreamAndLambda {

    /// 1) tutte le poste il cui indirizzo contenga “(MI)”;
    /// 2) tutte le poste che sono state aperte dopo il primo marzo 2019 (non usate codice deprecato!!!);
    /// 3) la lista di indirizzi delle poste il cui numero dipendenti sia superiore a 20;
    /// 4) la lista di indirizzi di destinatari di poste con almeno 10 dipendenti;
    /// 5) la lista di destinatari possessori di conto corrente ma appartenenti a poste con numero
    /// dipendenti compreso tra 50 e 100;
    /// 6) la lista delle età dei destinatari delle poste che contengano nel campo denominazione la stringa
    /// ‘Centrale’ e siano state aperta almeno dal primo gennaio 2000.

    public static void main(String[] args){
        List<Destinatario> destinatariMock = MockData.DESTINATARI_LIST;
        List<PostaDiPaese> postaDiPaeseMock = MockData.POSTA_DI_PAESI_LIST;

        // 1) tutte le poste il cui indirizzo contenga “(MI)”;
        System.out.println("Voglio tutte le poste il cui indirizzo contenga “(MI)");
        List<PostaDiPaese> posteConIndirizzoMI = postaDiPaeseMock.stream()
                .filter(p -> p.getIndirizzoSede().contains("(MI)")) //Per controllare se l'indirizzo contiene Mi uso toUpperCase prima del contains
                .toList();
        posteConIndirizzoMI.forEach(p -> System.out.println(
                "Tutte le poste che contengono MI nel loro indirizzo:\n"
                + p.getIndirizzoSede() + "\nDenominazione: " + p.getDenominazione() + "\nDataApertura: "
                + p.getDataApertura() + "\nNumeroDipendenti: "  + p.getNumeroDipendenti()));

        System.out.println("\n");

        // 2) tutte le poste che sono state aperte dopo il primo marzo 2019 (non usate codice deprecato!!!);
        System.out.println("Voglio tutte le poste che sono state aperte dopo il primo marzo 2019\n");
        List<PostaDiPaese> posteAperteDopoMarzo2019 = postaDiPaeseMock.stream()
                .filter(p -> p.getDataApertura().isAfter(LocalDate.of(2019, 3, 1)))
                .toList();
        posteAperteDopoMarzo2019.forEach(p -> System.out.println(
                "Tutte le poste che sono state aperte dopo il primo marzo 2019:\n"
                        + p.getIndirizzoSede() + "\nDenominazione: "
                        + p.getDenominazione() + "\nDataApertura: " + p.getDataApertura() + "\nNumeroDipendenti: "
                        + p.getNumeroDipendenti()));

        System.out.println("\n");

        // 3) la lista di indirizzi delle poste il cui numero dipendenti sia superiore a 20;
        System.out.println("Voglio gli indirizzi di tutte le poste con più di 20 dipendenti\n");
        List<String> indirizziPosteConDipendentiSuperiore20 = postaDiPaeseMock.stream()
                .filter(p -> p.getNumeroDipendenti() > 20)
                .map(PostaDiPaese::getIndirizzoSede)
                .toList();
        System.out.println("Indirizzi di tutte le poste con più di 20 dipendenti:\n");
        indirizziPosteConDipendentiSuperiore20.forEach(p -> System.out.println(p));

        System.out.println("\n");

        // 4) la lista di indirizzi di destinatari di poste con almeno 10 dipendenti;
        System.out.println("Voglio gli indirizzi di tutti i destinatari di poste con almeno 10 dipendenti\n");
        List<String> indirizziDestinatariConPosteConDipendentiSuperiore10 = destinatariMock.stream()
                .filter(d -> d.getPostaDiPaese().getNumeroDipendenti() >= 10)
                .map(Destinatario::getIndirizzo)
                .toList();
        System.out.println("Indirizzi di tutti i destinatari di poste con almeno 10 dipendenti:\n");
        indirizziDestinatariConPosteConDipendentiSuperiore10.forEach(p -> System.out.println(p));

        System.out.println("\n");

        // 5) la lista di destinatari possessori di conto corrente ma appartenenti a poste con numero
        //compreso tra 50 e 100
        System.out.println("Voglio gli indirizzi di tutti i destinatari possessori di conto corrente ma appartenenti a poste con numero dipendenti compreso tra 50 e 100\n");
        List<String> indirizziDestinatariPossessoriDiContoCorrenteEAppartenentiAPosteConNumeroDipendentiTra50E100 = destinatariMock.stream()
                .filter(d -> d.isPossessoreDiContoCorrente() && d.getPostaDiPaese().getNumeroDipendenti() >= 50
                        && d.getPostaDiPaese().getNumeroDipendenti() <= 100)
                .map(Destinatario::getIndirizzo)
                .toList();
        System.out.println("Indirizzi di tutti i destinatari possessori di conto corrente e appartenenti a poste con numero dipendenti compreso tra 50 e 100:\n");
        indirizziDestinatariPossessoriDiContoCorrenteEAppartenentiAPosteConNumeroDipendentiTra50E100.forEach(p -> System.out.println(p));

        System.out.println("\n");

        // 6) la lista delle età dei destinatari delle poste che contengano nel campo denominazione la stringa
        //‘Centrale’ e siano state aperta almeno dal primo gennaio 2000.

        System.out.println("Voglio le età di tutti i destinatari delle poste che contengano nel campo denominazione la stringa ‘Centrale’ e siano state aperta almeno dal primo gennaio 2000\n");

        List<Integer> etaDestinatariDellePosteConDenominazioneCentraleEDataAperturaDopo2000 = destinatariMock.stream()
                .filter(d -> d.getPostaDiPaese().getDenominazione().contains("Centrale") && d.getPostaDiPaese().getDataApertura().isAfter(LocalDate.of(2000, 1, 1)))
                .map(Destinatario::getEta)
                .toList();
        System.out.println("Età di tutti i destinatari delle poste che contengono nel campo denominazione la stringa ‘Centrale’ e sono state aperta dopo il primo gennaio 2000:\n");
        etaDestinatariDellePosteConDenominazioneCentraleEDataAperturaDopo2000.forEach(p -> System.out.println(p));

        System.out.println("\n");

        // 7) Calcolare la somma totale del numero totale di dipendenti di tutte le poste
        System.out.println("Voglio la somma totale del numero totale di dipendenti di tutte le poste\n");
        int sommaTotaleDipendenti = postaDiPaeseMock.stream()
                .mapToInt(posta -> posta.getNumeroDipendenti())
                .sum();
        System.out.println("La somma totale del numero totale di dipendenti di tutte le poste è: " + sommaTotaleDipendenti);

        System.out.println("\n");

        // 8) Estrarre la lista con solo i cognomi dei dipendenti di tutte le poste
        System.out.println("Voglio la lista con solo i cognomi dei dipendenti di tutte le poste\n");

        List<String> cognomiDipendentiDiTutteLePoste = destinatariMock.stream()
                .map(destinatario -> destinatario.getCognome()).toList();
        System.out.println("Cognomi dei dipendenti di tutte le poste:\n");
        cognomiDipendentiDiTutteLePoste.forEach(p -> System.out.println(p));

        System.out.println("\n");

        // 9) Verificare ed estrarre se esiste un destinatario con età maggiore di 60 anni in tutte le poste.
        System.out.println("Voglio verificare ed estrarre se esiste un destinatario con età maggiore di 60 anni in tutte le poste\n");
        Destinatario esisteUnDestinatarioConEtaMaggioreDi60 = destinatariMock.stream()
                .filter(destinatario -> destinatario.getEta() > 60).findAny().orElse(null);
        //utilizzo Optional.ofNullable per evitare NullPointerException
        Optional.ofNullable(esisteUnDestinatarioConEtaMaggioreDi60).ifPresentOrElse
                (d -> System.out.println("Esiste un destinatario con età maggiore di 60 anni: "
                        + d.getNome() + " " + d.getCognome()),
                        () -> System.out.println("Non esiste un destinatario con età maggiore di 60 anni"));

        System.out.println("\n");

        //10) Calcolare il numero di poste che abbiano clienti che non possiedono conti correnti
        System.out.println("Voglio calcolare il numero di poste che abbiano clienti che non possiedono conti correnti\n");
        long numeroPosteConClientiSenzaContoCorrente = postaDiPaeseMock.stream()
                .filter(p -> p.getDestinatari().stream()
                        .anyMatch(destinatario -> !destinatario.isPossessoreDiContoCorrente()))
                .count();
        System.out.println("Il numero di poste che hanno clienti che non possiedono conti correnti è: " + numeroPosteConClientiSenzaContoCorrente);

        System.out.println("\n");

        //11) Raggruppare in una java.util.Map le poste per numero dipendenti.
        Map<Integer , List<PostaDiPaese>> posteRaggruppatePerNumeroDipendenti = postaDiPaeseMock.stream()
                .collect(groupingBy(p -> p.getNumeroDipendenti()));
        System.out.println("Raggruppamento delle poste per numero dipendenti:\n");
        posteRaggruppatePerNumeroDipendenti.forEach((k, v) -> {
            System.out.print("Numero dipendenti: " + k + " ");
            v.forEach(p -> System.out.print("Posta: " + p.getDenominazione() + "\n"));
        });
    }
}
