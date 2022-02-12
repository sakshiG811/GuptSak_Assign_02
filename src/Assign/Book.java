package Assign;

public class Book {
    private String title;
    private boolean borrowed = false;

    /**
     * Constructor
     * @param title Constructor Method
     */
    public Book (String title){                                  /** Constructor */
    this.title = title;
    }

    public String getTitle(){
        return this.title;
    }              /** Getter */

    /**
     * Getter
     * @param b Getter Method
     */
    public boolean isBorrowed(boolean b){                        /** Getter*/
        return this.borrowed;
    }
    /**
     * Setter
     * @param b Setter Method
     */
    public void borrow(boolean b){
        this.borrowed = borrowed;
    }  /** Setter */
}
