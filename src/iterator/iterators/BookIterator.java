package iterator.iterators;

import iterator.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookIterator implements Iterator<Book> {

    protected final List<Book> bookListCopy;
    private int index = 0;

    public BookIterator(List<Book> bookList) {
        this.bookListCopy = new ArrayList<>(bookList);
    }

    @Override
    public boolean hasNext() {
        return (index < bookListCopy.size());
    }

    @Override
    public Book next() {
        return bookListCopy.get(index++);
    }
}
