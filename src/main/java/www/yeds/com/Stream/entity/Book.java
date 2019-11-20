package www.yeds.com.Stream.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream.entity
 * @ClassName: book
 * @author: yeds
 * @date: 2019/11/20 20:56
 * @version: V1.0
 */
@Data
public class Book {
    private int id;
    private String name;
    private double price;
    private LocalDate publishDate;

    public Book(int id, String name, double price, LocalDate publishDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
