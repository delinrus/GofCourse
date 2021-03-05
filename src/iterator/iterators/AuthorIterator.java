package iterator.iterators;

import iterator.Book;

import java.util.Comparator;
import java.util.List;

public class AuthorIterator extends BookIterator {

    public AuthorIterator(List<Book> bookList) {
        super(bookList);
        this.bookListCopy.sort(Comparator.comparing(Book::getAuthor));
    }

}
