package com.qyt.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_comment")
@Table
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname; // 昵称
    private String email;
    private String content; // 评论内容
    private String avatar; // 头像地址
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; // 评论时间

    // 多个评论对应一篇博客
    @ManyToOne
    private Blog blog;

    // 一个评论对应多个回复
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    // 多个评论对应一个父评论
    @ManyToOne
    private Comment parentComment;

    private boolean adminComment;
}
