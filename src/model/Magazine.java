package model;

import java.time.MonthDay;
import java.util.Objects;

public class Magazine extends Publication {
    public static final String TYPE = "Magazyn";
    private MonthDay monthDay;
    private String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(title, publisher, year);
        this.monthDay = MonthDay.of(month, day);
        this.language = language;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(monthDay, magazine.monthDay) &&
                Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),  monthDay.getMonthValue(), monthDay.getDayOfMonth(), language);
    }

    @Override
    public String toCsv() {
        return TYPE + ";" +
                getTitle() + ";" +
                getPublisher() + ";" +
                getYear()+ ";" +
                monthDay.getMonthValue() + ";" +
                monthDay.getDayOfMonth() + ";" +
                language + ";";

    }

}