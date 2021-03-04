package iterator;

public class Book {
    private final String author;
    private final String name;
    private final int yearOfPublication;

    public Book(String author, String name, int yearOfPublication) {
        this.author = author;
        this.name = name;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return name + " by " + author + " (" + yearOfPublication + ")";
    }
}
