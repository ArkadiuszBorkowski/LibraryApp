package io;

import model.*;

import java.util.Collection;

//public class ConsolePrinter {
//    public void printBooks(Collection<Publication> publications) {
//        int counter = 0;
//        for (Publication publication : publications) {
//            if(publication instanceof Book) {
//                printLine(publication.toString());
//                counter++;
//            }
//        }
//        if (counter == 0)
//            printLine("Brak książek w bibliotece");
//    }

public class ConsolePrinter {
    public void printBooks(Collection<Publication> publications) {
        long counter = publications.stream()
                .filter(publication -> publication instanceof Book)
                .map(Publication::toString)
                .peek(this::printLine)
                .count();
        if (counter == 0) {
            printLine("Brak książek w bibliotece");
        }

    }

//    public void printMagazines(Collection<Publication> publications) {
//        int counter = 0;
//        for (Publication publication : publications) {
//            if(publication instanceof Magazine) {
//                printLine(publication.toString());
//                counter++;
//            }
//        }
//        if (counter == 0)
//            printLine("Brak magazynów w bibliotece");
//    }

    public void printMagazines(Collection<Publication> publications) {
        long counter = publications.stream()
                .filter(publication -> publication instanceof Magazine)
                .map(Publication::toString)
                .peek(this::printLine)
                .count();
        if (counter == 0) {
            printLine("Brak magazynów w bibliotece");
        }
    }

    public void printUsers(Collection<LibraryUser> users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }

    public void printUsersAlternative(Collection<LibraryUser> users) {
        users.stream()
                .map(LibraryUser::toString)
                .forEach(this::printLine);
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}