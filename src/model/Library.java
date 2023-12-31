package model;

import exception.PublicationAlreadyExistsException;
import exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {

    //private static final int INITIAL_CAPACITY = 1;
    //private int publicationsNumber;

    //zmieniony typ z private Publication[] publications = new Publication[INITIAL_CAPACITY];
    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    //zmieniony typ zwracany
    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Collection<Publication> getSortedPublications(Comparator<Publication> comparator) {
        ArrayList<Publication> list = new ArrayList<>(this.publications.values());
        list.sort(comparator);
        return list;
    }

    public Collection<LibraryUser> getSortedUsers(Comparator<LibraryUser> comparator) {
        ArrayList<LibraryUser> list = new ArrayList<>(this.users.values());
        list.sort(comparator);
        return list;
    }

    //dodany getter
    public Map<String, LibraryUser> getUsers() {
        return users;
    }


    //dodana metoda i rzucany nowy typ wyjątku
    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getPesel()))
            throw new UserAlreadyExistsException(
                    "Użytkownik ze wskazanym peselem już istnieje " + user.getPesel()
            );
        users.put(user.getPesel(), user);
    }

    //zmieniona logika
    public void addPublication(Publication publication) {
        if(publications.containsKey(publication.getTitle()))
            throw new PublicationAlreadyExistsException(
                    "Publikacja o takim tytule już istnieje " + publication.getTitle()
            );
        publications.put(publication.getTitle(), publication);
    }

    //zmieniona logika
    public boolean removePublication(Publication publication) {
        if(publications.containsValue(publication)) {
            publications.remove(publication.getTitle());
            return true;
        } else {
            return false;
        }
    }
}