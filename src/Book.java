public class Book {
    private int BookId;
    private String Title;
    private String Author;
    private String Category;
    private int NoOfCopies;
//    private boolean Available;

    public Book(int bookId, String title, String author, String category, int noOfCopies, boolean availability ) {
        BookId = bookId;
        Title = title;
        Author = author;
        Category = category;
        NoOfCopies = noOfCopies;
//        Available = availability;

    }

    public Book(int bookId, String title, String author, String category,  int noOfCopies) {
        BookId = bookId;
        Title = title;
        Author = author;
        Category = category;
        NoOfCopies = noOfCopies;
//        Available = true;
    }


    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
    public int getNoOfCopies() {
        return NoOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        NoOfCopies = noOfCopies;
    }

//    public boolean isAvailable() {
//        return Available;
//    }
//
//    public void setAvailability(boolean availability) {
//        Available = availability;
//    }
}
