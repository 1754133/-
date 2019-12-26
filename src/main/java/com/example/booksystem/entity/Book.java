package com.example.booksystem.entity;

public class Book {
    private int id;
    //书名
    private String name;
    //出版社
    private String press;
    //作者
    private String author;
    //书架号
    private String shelfId;
    //简介
    private String synopsis;
    //类型编号
    private int typeid;
    //剩余数量
    private int remain;

    public Book(){}

    public Book(int id, String name, String press, String author, String synopsis, int typeid, int remain) {
        this.id = id;
        this.name = name;
        this.press = press;
        this.author = author;
        this.synopsis = synopsis;
        this.typeid = typeid;
        this.remain = remain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}
