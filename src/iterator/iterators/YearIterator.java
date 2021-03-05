package iterator.iterators;

import iterator.Book;

import java.util.Comparator;
import java.util.List;

public class YearIterator extends BookIterator {

    public YearIterator(List<Book> bookList) {
        super(bookList);
        this.bookListCopy.sort(Comparator.comparing(Book::getYearOfPublication));
    }
}