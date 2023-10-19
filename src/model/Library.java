package model;

public class Library {

    private static final int MAX_PUBLICATIONS = 1000;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

//    public void addPubications(Publication publication) {
//        if (publicationsNumber < MAX_PUBLICATIONS) {
//            publications[publicationsNumber] = publication;
//            publicationsNumber++;
//        } else {
//            System.out.println("Maksymalna liczba publikacji została osiągnięta");
//        }
//    }

    public void addBook(Book book) {
        if (publicationsNumber < MAX_PUBLICATIONS) {
            publications[publicationsNumber] = book;
            publicationsNumber++;
        } else {
            System.out.println("Maksymalna liczba książek została osiągnięta");
        }
    }

    public void printBooks() {
        int countBooks = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Book)
                System.out.println(publications[i]);
            countBooks++;
            }
        if (countBooks == 0) {
            System.out.println("Brak książek");
        }
    }


    public void addMagazine(Magazine magazine) {
        if (publicationsNumber < MAX_PUBLICATIONS) {
            publications[publicationsNumber] = magazine;
            publicationsNumber++;
        } else {
            System.out.println("Maksymalna liczba magazynów została osiągnięta");
        }
    }


    public void printMagazines() {
        int countMagazines = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Magazine)
                System.out.println(publications[i]);
            countMagazines++;
        }
        if (countMagazines == 0) {
            System.out.println("Brak magazynów");
        }
    }
}
