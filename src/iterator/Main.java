package iterator;

import iterator.iterators.AuthorIterator;
import iterator.iterators.NameIterator;
import iterator.iterators.YearIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s1 = "ABD";
        String s2 = "BBBB";

        List<Book> books = new ArrayList<>();
        books.add(new Book("Jane Austen", "Pride and Prejudice", 1813));
        books.add(new Book("Harper Lee", "To Kill a Mockingbird", 1960));
        books.add(new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925));
        books.add(new Book("Gabriel García Márquez", "One Hundred Years of Solitude", 1967));
        books.add(new Book("Jean Rhy", "Wide Sargasso Sea", 1966));
        books.add(new Book("Aldous Huxley", "Brave New World", 1932));
        books.add(new Book("Dodie Smith", "I Capture The Castle", 1948));
        books.add(new Book("Charlotte Bronte", "Jane Eyre", 1847));
        books.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 1866));
        books.add(new Book("Donna Tartt", "The Secret History", 1992));
        books.add(new Book("Jack London", "The Call of the Wild", 1903));

     //   Iterator<Book> iterator = new AuthorIterator(books);
      //  Iterator<Book> iterator = new NameIterator(books);
        Iterator<Book> iterator = new YearIterator(books);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
      //  books.forEach(System.out::println);
    }
}
