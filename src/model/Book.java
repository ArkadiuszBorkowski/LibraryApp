package model;

import java.util.Objects;

public class Book extends Publication {
    // Pola
    private String author;
    private int pages;
    private String isbn;

    // Konstruktory
    public Book(String title, String author, int year, int pages, String publisher, String isbn) {
        super(title, publisher, year);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    // settery i gettery
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    @Override
//    public void printInfo() {
//        String info = getTitle() + "; " + author + "; " + getYear() + "; "
//                + pages + "; " + getPublisher() + "; " + isbn;
//        System.out.println(info);
//    }

    @Override
    public String toString() {
        return super.toString() + "; " + author + "; " + pages + "; " + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }
}