package by.bstu.unittesting.model;

public class Basket {

    private String bookName;

    public Basket(String testData) {
        this.bookName = testData;
    }

    public void Book(String bookName){
        this.bookName = bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }
}
