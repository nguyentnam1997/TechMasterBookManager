package entities;

public class Book {
    private static int autoId = 0;
    private int id;
    private String name;
    private String topic;
    private String author;
    private int countBook;

    public Book(String name, String topic, String author, int countBook) {
        this.id = ++autoId;
        this.name = name;
        this.topic = topic;
        this.author = author;
        this.countBook = countBook;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", author='" + author + '\'' +
                ", countBook=" + countBook +
                '}';
    }
}
