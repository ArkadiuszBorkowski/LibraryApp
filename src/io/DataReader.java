package io;


import model.Book;
import model.LibraryUser;
import model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void close() {
        sc.close();
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public String getString() {
        return sc.nextLine();
    }

    public LibraryUser createLibraryUser() {
        printer.printLine("Imię");
        String firstName = sc.nextLine();
        printer.printLine("Nazwisko");
        String lastName = sc.nextLine();
        printer.printLine("Pesel");
        String pesel = sc.nextLine();
        return new LibraryUser(firstName, lastName, pesel);
    }

    public Book readAndCreateBook() {
        printer.printLine("Tytuł: ");
        String title = sc.nextLine();
        printer.printLine("Autor: ");
        String author = sc.nextLine();
        printer.printLine("Wydawnictwo: ");
        String publisher = sc.nextLine();
        printer.printLine("ISBN: ");
        String isbn = sc.nextLine();
        printer.printLine("Rok wydania: ");
        int releaseDate = getInt();
        printer.printLine("Ilość stron: ");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine("Tytuł: ");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo: ");
        String publisher = sc.nextLine();
        printer.printLine("Język: ");
        String language = sc.nextLine();
        printer.printLine("Rok wydania: ");
        int year = getInt();
        printer.printLine("Miesiąc: ");
        int month = getInt();
        printer.printLine("Dzień: ");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }
}