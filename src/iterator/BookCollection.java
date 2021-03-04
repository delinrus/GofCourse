package iterator;

import iterator.iterators.BookIterator;

public interface BookCollection {
    BookIterator createIterator(IteratorType type);
    void add(Book book);
}
