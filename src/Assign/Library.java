package Assign;


public class Library {
    private static final String OPENING_TIME = "9 am";
    private static final String CLOSING_TIME = "5 pm";
    private String address;
    private Book [] books = new Book[50];
    private int totalBooks = 0;

    /**
     * Library Method
     * @param address method for address.
     */
    public Library(String address) {                                /** Getter */
        this.address = address;
    }

    /**
     * addBook Method
     * @param book method for adding new Books.
     */
    public void addBook(Book book){                                 /** add books to the list */
        books[totalBooks] = book;
        totalBooks++;
    }


    public static void printHours(){                                /** prints libraries hours */
        System.out.println("Library open from " + OPENING_TIME + " - " + CLOSING_TIME);
    }


    public void printAddress(){                                     /** prints libraries addresses */
        System.out.println(this.address);
    }

    /**
     * BookBorrow Method
     * @param title method for when book is borrowed.
     */
    public void BookBorrow(String title){                           /** method for when borrowing book */
        boolean found = false;
        boolean borrowed = false;
        for(int i = 0; i < totalBooks; i++){
            if(books[i].getTitle().equals(title)){
                found = true;
                if(books[i].isBorrowed(false)){
                    borrowed = true;
                } else {
                    books[i].borrow(true);
                    System.out.println("This book is now borrowed!" + title);
                    return;
                }
            }
        }
        if(!found){                                                  /** if book not found, print the output */
            System.out.println("This book is not available!");
            return;
        }
        if(found && borrowed){                                       /** if book found and borrowed, print the output */
            System.out.println("This book has been borrowed!");
        }

    }

    
    public void printAvailBooks(){                                  /** method to check available books */
        if(totalBooks == 0){
            System.out.println("Sorry, no books available!");       /** if total books = 0, print the output */
            return;
        }
        for(int i = 0; i < totalBooks; i++){
            if(!books[i].isBorrowed(false)){
                System.out.println(books[i].getTitle());
            }
        }
    }

    /**
     * returnBook Method
     * @param title method for when returning the book.
     */
    public void returnBook(String title){                           /** method for when returning the book */
        for(int i = 0; i < totalBooks; i++){
            if(books[i].getTitle().equals(title)){
                books[i].isBorrowed(false);
                System.out.println("You have returned " + title);   /** when returned, print the output */
                return;
            }
        }
    }
    /**
     * Main Method
     * @param args The command line arguments.
     */
    public static void main(String[] args){
        Library LibraryOne = new Library("120 Queen St.");   /** Library one address */
        Library LibraryTwo = new Library("228 College St."); /** Library two address */


        LibraryOne.addBook(new Book("The DaVinci Code"));       /** adding books to collection */
        LibraryOne.addBook(new Book("Le Petit Prince"));
        LibraryOne.addBook(new Book("A Tale of Two Cities"));
        LibraryOne.addBook(new Book("The Lord of the Rings"));

        printHours();                                               /** prints library hours */
        System.out.println();

        System.out.println("Library Addresses: ");
        LibraryOne.printAddress();                                  /** prints library one address */
        LibraryTwo.printAddress();                                  /** prints library two address */
        System.out.println();

        System.out.println("Borrowing: ");                          /** borrowing a book from library one */
        LibraryOne.BookBorrow("The Lord of the Rings");
        System.out.println();


        LibraryOne.BookBorrow("The Lord of the Rings");         /** borrowing a book again from library one */
        System.out.println();
        LibraryTwo.BookBorrow("The Lord of the Rings");         /** borrowing a book from library two */
        System.out.println();

        System.out.println("Books in Library 1: ");                 /** prints available books in library one */
        LibraryOne.printAvailBooks();
        System.out.println();

        System.out.println("Books in Library 2: ");                 /** prints available books in library two */
        LibraryTwo.printAvailBooks();
        System.out.println();

        System.out.println("Returning: ");                          /** returning a book to library one */
        LibraryOne.returnBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books in Library 1: ");                 /** prints available books in library one again */
        LibraryOne.printAvailBooks();
    }
}
