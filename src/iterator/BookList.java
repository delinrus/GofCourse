package iterator;

import iterator.iterators.AuthorIterator;
import iterator.iterators.BookIterator;
import iterator.iterators.NameIterator;
import iterator.iterators.YearIterator;

import java.util.ArrayList;
import java.util.List;

public class BookList implements BookCollection {
    List<Book> books = new ArrayList<>();

    @Override
    public BookIterator createIterator(IteratorType type) {
        if (type != null) {
            switch (type) {
                case AUTHOR_ITERATOR:
                    return new AuthorIterator(books);
                case YEAR_ITERATOR:
                    return new YearIterator(books);
                case NAME_ITERATOR:
                    return new NameIterator(books);
            }
        }
        return new BookIterator(books);
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }
}
