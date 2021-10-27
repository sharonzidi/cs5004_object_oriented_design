package bookstoreexample;

import java.util.Objects;

/**
 * Represents the company's stock of a book.
 */
public class Stock {
    private static final double FIFTY_PERCENT_OFF = 0.5;
    private static final double TEN_PERCENT_OFF = 0.9;
    private Book book;
    private int quantity;
    private double retailPrice;

    /**
     * Constructor for the Stock class.
     * @param book The book for sale.
     * @param quantity The number of copies in stock.
     * @param retailPrice The retail price of the book.
     */
    public Stock(Book book, int quantity, double retailPrice) {
        this.book = book;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
    }

    /**
     * Gets the book.
     * @return The book.
     */
    public Book getBook() {
        return this.book;
    }

    /**
     * Gets the number of copies in stock.
     * @return The number of copies in stock.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Gets the price of the book after any daily discount has been applied.
     * @param day The day of purchase.
     * @return The price after and discount has been applied.
     */
    public double getPrice(DayOfWeek day) {
        switch (day) {
            case MONDAY:
                return this.retailPrice * TEN_PERCENT_OFF;
            case TUESDAY:
            case THURSDAY:
                return this.retailPrice * FIFTY_PERCENT_OFF;
            default:
                return this.retailPrice;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return getQuantity() == stock.getQuantity() &&
                Double.compare(stock.retailPrice, retailPrice) == 0 &&
                Objects.equals(getBook(), stock.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook(), getQuantity(), retailPrice);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "book=" + book +
                ", quantity=" + quantity +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
