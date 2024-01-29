package k24.bookstore.model;

public class Book {

    private String title, author, publicationYear, isbn, price;

    public Book(){
        super();
    }


    public Book(String title, String author, String publicationYear, String isbn, String price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public String getAuthor() {
        return author;
    }



    public void setAuthor(String author) {
        this.author = author;
    }



    public String getPublicationYear() {
        return publicationYear;
    }



    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }



    public String getIsbn() {
        return isbn;
    }



    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    public String getPrice() {
        return price;
    }



    public void setPrice(String price) {
        this.price = price;
    }

}
