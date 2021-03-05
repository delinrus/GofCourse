package iterator.iterators;

import iterator.Book;

import java.util.Comparator;
import java.util.List;

public class NameIterator extends BookIterator {

    public NameIterator(List<Book> bookList) {
        super(bookList);
        this.bookListCopy.sort(Comparator.comparing(Book::getName));
    }
}