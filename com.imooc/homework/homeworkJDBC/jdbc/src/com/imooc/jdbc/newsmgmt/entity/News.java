package com.imooc.jdbc.newsmgmt.entity;

import java.sql.Date;

public class News {
    //1、 属性：新闻id，标题，内容，创建时间。
    private Integer id;
    private String title;
    private String content;
    private Date create_time;
    // 2、 添加无参构造以及带参构造方法

    public News() {}

    public News(Integer id, String title, String content, Date create_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
    }

    //3、 get，set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    //4、 toString()方法
    @Override
    public String toString() {
        return "News [" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ']';
    }
}
