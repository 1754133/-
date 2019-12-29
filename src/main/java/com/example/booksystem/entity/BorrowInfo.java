package com.example.booksystem.entity;

import java.util.Date;

public class BorrowInfo {
    private int id;
    private int bookId;
    private int userId;
    private String borrowDate;
    private String shReturnDate;
    private boolean renew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getShReturnDate() {
        return shReturnDate;
    }

    public void setShReturnDate(String shReturnDate) {
        this.shReturnDate = shReturnDate;
    }

    public boolean isRenew() {
        return renew;
    }

    public void setRenew(boolean renew) {
        this.renew = renew;
    }
}
