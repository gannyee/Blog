package com.gannyee.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by gannyee on 2017/5/7.
 */
@Entity
@Table(name = "tb_article", schema = "blog", catalog = "")
public class ArticleEntity {
    private int id;
    private String title;
    private byte[] content;
    private Integer userId;
    private Date pubDate;
    private UserEntity getAuthorByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 130)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true)
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "pub_date", nullable = true)
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (!Arrays.equals(content, that.content)) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return pubDate != null ? pubDate.equals(that.pubDate) : that.pubDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getGetAuthorByUserId() {
        return getAuthorByUserId;
    }

    public void setGetAuthorByUserId(UserEntity getAuthorByUserId) {
        this.getAuthorByUserId = getAuthorByUserId;
    }
}
