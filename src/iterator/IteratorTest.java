package iterator;

import iterator.iterators.BookIterator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IteratorTest {

    BookCollection books = new BookList();

    {
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
    }

    private void testHelper(BookIterator iterator, String expected) {
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append("\n");
        }
        assertEquals(expected, sb.toString());
    }

    @Test
    public void defaultIterator() {
        testHelper(books.createIterator(null),
                "Pride and Prejudice by Jane Austen (1813)\n" +
                        "To Kill a Mockingbird by Harper Lee (1960)\n" +
                        "The Great Gatsby by F. Scott Fitzgerald (1925)\n" +
                        "One Hundred Years of Solitude by Gabriel García Márquez (1967)\n" +
                        "Wide Sargasso Sea by Jean Rhy (1966)\n" +
                        "Brave New World by Aldous Huxley (1932)\n" +
                        "I Capture The Castle by Dodie Smith (1948)\n" +
                        "Jane Eyre by Charlotte Bronte (1847)\n" +
                        "Crime and Punishment by Fyodor Dostoevsky (1866)\n" +
                        "The Secret History by Donna Tartt (1992)\n" +
                        "The Call of the Wild by Jack London (1903)\n");
    }

    @Test
    public void AuthorIteratorTest() {
        testHelper(books.createIterator(IteratorType.AUTHOR_ITERATOR),
                "Brave New World by Aldous Huxley (1932)\n" +
                        "Jane Eyre by Charlotte Bronte (1847)\n" +
                        "I Capture The Castle by Dodie Smith (1948)\n" +
                        "The Secret History by Donna Tartt (1992)\n" +
                        "The Great Gatsby by F. Scott Fitzgerald (1925)\n" +
                        "Crime and Punishment by Fyodor Dostoevsky (1866)\n" +
                        "One Hundred Years of Solitude by Gabriel García Márquez (1967)\n" +
                        "To Kill a Mockingbird by Harper Lee (1960)\n" +
                        "The Call of the Wild by Jack London (1903)\n" +
                        "Pride and Prejudice by Jane Austen (1813)\n" +
                        "Wide Sargasso Sea by Jean Rhy (1966)\n");
    }

    @Test
    public void YearIteratorTest() {
        testHelper(books.createIterator(IteratorType.YEAR_ITERATOR),
                "Pride and Prejudice by Jane Austen (1813)\n" +
                        "Jane Eyre by Charlotte Bronte (1847)\n" +
                        "Crime and Punishment by Fyodor Dostoevsky (1866)\n" +
                        "The Call of the Wild by Jack London (1903)\n" +
                        "The Great Gatsby by F. Scott Fitzgerald (1925)\n" +
                        "Brave New World by Aldous Huxley (1932)\n" +
                        "I Capture The Castle by Dodie Smith (1948)\n" +
                        "To Kill a Mockingbird by Harper Lee (1960)\n" +
                        "Wide Sargasso Sea by Jean Rhy (1966)\n" +
                        "One Hundred Years of Solitude by Gabriel García Márquez (1967)\n" +
                        "The Secret History by Donna Tartt (1992)\n");
    }

    @Test
    public void NameIteratorTest() {
        testHelper(books.createIterator(IteratorType.NAME_ITERATOR),
                "Brave New World by Aldous Huxley (1932)\n" +
                        "Crime and Punishment by Fyodor Dostoevsky (1866)\n" +
                        "I Capture The Castle by Dodie Smith (1948)\n" +
                        "Jane Eyre by Charlotte Bronte (1847)\n" +
                        "One Hundred Years of Solitude by Gabriel García Márquez (1967)\n" +
                        "Pride and Prejudice by Jane Austen (1813)\n" +
                        "The Call of the Wild by Jack London (1903)\n" +
                        "The Great Gatsby by F. Scott Fitzgerald (1925)\n" +
                        "The Secret History by Donna Tartt (1992)\n" +
                        "To Kill a Mockingbird by Harper Lee (1960)\n" +
                        "Wide Sargasso Sea by Jean Rhy (1966)\n");
    }
}