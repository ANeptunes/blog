package com.qyt.blog.pojo;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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
@Entity(name = "t_blog")
@Table
public class Blog {
    @Id
    @GeneratedValue // 生成策略(自动生成)
    private Long id;
    private String title; // 博客标题
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content; // 博客内容
    private String firstPicture; // 首页图片地址
    private String flag; // 标记
    private Integer views; // 浏览次数
    private boolean appreciation;  // 赞赏是否开启
    private boolean shareStatement; // 转载声明是否开启
    private boolean commentStatus; // 评论是否开启
    private boolean published; // 是否发布还是保存的状态
    private boolean recommend; // 是否推荐
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; // 发布时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime; // 更新时间

    // 多篇博客对应一个类型
    @ManyToOne
    private Type type;

    // 多篇博客对应多个标签
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    // 多篇博客对应一个用户
    @ManyToOne
    private User user;

    // 一篇博客对应多个评论
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private String tagIds;

    private String description;

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }
}
