package main.java.it.prova.eserciziostreamandlambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static final List<PostaDiPaese> POSTA_DI_PAESI_LIST = new ArrayList<>();
    public static final List<Destinatario> DESTINATARI_LIST = new ArrayList<>();

    static {
        PostaDiPaese postaDiPaese = new PostaDiPaese("Posta Centrale", "Via Roma 1", LocalDate.of(2020, 1, 1), 30, null);
        Destinatario destinatario1 = new Destinatario("Mario", "Rossi", 30, "Via Milano 2", true, postaDiPaese);
        Destinatario destinatario2 = new Destinatario("Luigi", "Bianchi", 25, "Via Napoli 3", false, postaDiPaese);
        Destinatario destinatario3 = new Destinatario("Giovanni", "Verdi", 40, "Via Torino 4", true, postaDiPaese);
        Destinatario destinatario4 = new Destinatario("Anna", "Neri", 35, "Via Firenze 5", false, postaDiPaese);
        Destinatario destinatario5 = new Destinatario("Marco", "Gialli", 28, "Via Bologna 6", true, postaDiPaese);

        List<Destinatario> destinatariPostaDiPaese = new ArrayList<>();
        destinatariPostaDiPaese.add(destinatario1);
        destinatariPostaDiPaese.add(destinatario2);
        destinatariPostaDiPaese.add(destinatario3);
        destinatariPostaDiPaese.add(destinatario4);
        destinatariPostaDiPaese.add(destinatario5);
        postaDiPaese.setDestinatari(destinatariPostaDiPaese);

        PostaDiPaese postaDiPaese2 = new PostaDiPaese("Posta di Paese 2", "Via Roma 7", LocalDate.of(2019, 1, 1), 15, null);
        Destinatario destinatario6 = new Destinatario("Francesca", "Blu", 32, "Via Venezia 8", true, postaDiPaese2);
        Destinatario destinatario7 = new Destinatario("Alessandro", "Verdi", 29, "Via Genova 9", false, postaDiPaese2);
        Destinatario destinatario8 = new Destinatario("Chiara", "Gialli", 22, "Via Palermo 10", true, postaDiPaese2);
        Destinatario destinatario9 = new Destinatario("Simone", "Rossi", 27, "Via Roma 11", false, postaDiPaese2);
        Destinatario destinatario10 = new Destinatario("Elena", "Bianchi", 31, "Via Napoli 12", true, postaDiPaese2);

        List<Destinatario> destinatariPostaDiPaese2 = new ArrayList<>();
        destinatariPostaDiPaese2.add(destinatario6);
        destinatariPostaDiPaese2.add(destinatario7);
        destinatariPostaDiPaese2.add(destinatario8);
        destinatariPostaDiPaese2.add(destinatario9);
        destinatariPostaDiPaese2.add(destinatario10);
        postaDiPaese2.setDestinatari(destinatariPostaDiPaese2);

        PostaDiPaese postaDiPaese3 = new PostaDiPaese("Posta Centrale", "Via Milano 13, (MI)", LocalDate.of(2000, 1, 1), 50, null);
        Destinatario destinatario11 = new Destinatario("Luca", "Neri", 45, "Via Torino 14", true, postaDiPaese3);
        Destinatario destinatario12 = new Destinatario("Sara", "Blu", 38, "Via Firenze 15", false, postaDiPaese3);
        Destinatario destinatario13 = new Destinatario("Davide", "Gialli", 33, "Via Bologna 16", true, postaDiPaese3);
        Destinatario destinatario14 = new Destinatario("Martina", "Rossi", 26, "Via Venezia 17", false, postaDiPaese3);
        Destinatario destinatario15 = new Destinatario("Federico", "Verdi", 30, "Via Genova 18", true, postaDiPaese3);

        List<Destinatario> destinatariPostaDiPaese3 = new ArrayList<>();
        destinatariPostaDiPaese3.add(destinatario11);
        destinatariPostaDiPaese3.add(destinatario12);
        destinatariPostaDiPaese3.add(destinatario13);
        destinatariPostaDiPaese3.add(destinatario14);
        destinatariPostaDiPaese3.add(destinatario15);
        postaDiPaese3.setDestinatari(destinatariPostaDiPaese3);

        PostaDiPaese postaDiPaese4 = new PostaDiPaese("Posta di Paese 3", "Via Roma 19", LocalDate.of(2018, 1, 1), 5, null);
        Destinatario destinatario16 = new Destinatario("Giulia", "Neri", 24, "Via Napoli 20", true, postaDiPaese4);
        Destinatario destinatario17 = new Destinatario("Matteo", "Bianchi", 21, "Via Roma 21", false, postaDiPaese4);
        Destinatario destinatario18 = new Destinatario("Sofia", "Gialli", 36, "Via Torino 22", true, postaDiPaese4);
        Destinatario destinatario19 = new Destinatario("Alessia", "Blu", 29, "Via Firenze 23", false, postaDiPaese4);
        Destinatario destinatario20 = new Destinatario("Giorgio", "Verdi", 27, "Via Bologna 24", true, postaDiPaese4);

        List<Destinatario> destinatariPostaDiPaese4 = new ArrayList<>();
        destinatariPostaDiPaese4.add(destinatario16);
        destinatariPostaDiPaese4.add(destinatario17);
        destinatariPostaDiPaese4.add(destinatario18);
        destinatariPostaDiPaese4.add(destinatario19);
        destinatariPostaDiPaese4.add(destinatario20);
        postaDiPaese4.setDestinatari(destinatariPostaDiPaese4);

        // Aggiunta dei destinatari alla lista
        DESTINATARI_LIST.add(destinatario1);
        DESTINATARI_LIST.add(destinatario2);
        DESTINATARI_LIST.add(destinatario3);
        DESTINATARI_LIST.add(destinatario4);
        DESTINATARI_LIST.add(destinatario5);
        DESTINATARI_LIST.add(destinatario6);
        DESTINATARI_LIST.add(destinatario7);
        DESTINATARI_LIST.add(destinatario8);
        DESTINATARI_LIST.add(destinatario9);
        DESTINATARI_LIST.add(destinatario10);
        DESTINATARI_LIST.add(destinatario11);
        DESTINATARI_LIST.add(destinatario12);
        DESTINATARI_LIST.add(destinatario13);
        DESTINATARI_LIST.add(destinatario14);
        DESTINATARI_LIST.add(destinatario15);
        DESTINATARI_LIST.add(destinatario16);
        DESTINATARI_LIST.add(destinatario17);
        DESTINATARI_LIST.add(destinatario18);
        DESTINATARI_LIST.add(destinatario19);
        DESTINATARI_LIST.add(destinatario20);

        // Aggiunta delle poste alla lista
        POSTA_DI_PAESI_LIST.add(postaDiPaese);
        POSTA_DI_PAESI_LIST.add(postaDiPaese2);
        POSTA_DI_PAESI_LIST.add(postaDiPaese3);
        POSTA_DI_PAESI_LIST.add(postaDiPaese4);

    }

}
