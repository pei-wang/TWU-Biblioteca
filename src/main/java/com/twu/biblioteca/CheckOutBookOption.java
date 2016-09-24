package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class CheckOutBookOption extends Option{

    private BibliotecaApp bibliotecaApp;
    private Console console;

    public CheckOutBookOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    @Override
    public void execute() {
        String checkoutBookName = console.getNextString();
        List<Book> booksAfterCheckout = new ArrayList<Book>();
        // TODO: 9/22/16 check if the list can directly remove item
        List<Book> beforeCheckout = bibliotecaApp.getBooks();
        for (Book book : beforeCheckout) {
            if (!checkoutBookName.equals(book.getName())){
                booksAfterCheckout.add(book);
            }else {
                bibliotecaApp.getCheckedOutBooks().add(book);
            }
        }
        bibliotecaApp.setBooks(booksAfterCheckout);
        if(beforeCheckout.size()>booksAfterCheckout.size()){
            console.println("Thank you!Enjoy the book");
        }else{
            console.println("That book is not available.");
        }
    }
}
