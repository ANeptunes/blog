package com.qyt.blog.service;

import com.qyt.blog.pojo.Blog;
import com.qyt.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    // 根据id查询博客
    Blog getBlog(Long id);

    // 查询出带HTML格式的博客
    Blog getConvertBlog(Long id);

    // 根据搜索内容分页查询博客
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    // 分页查询所有博客
    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    // 根据搜索内容查询博客
    Page<Blog> listBlog(String query, Pageable pageable);

    // 分页查询所有已发布的博客
    Page<Blog> listPublishedBlogs(Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    // 获取浏览次数最多的文章
    List<Blog> listHotBlogTop(Integer size);

    // 对文章进行归档
    Map<String,List<Blog>> archiveBlog();

    // 返回博客的数量
    Long countBlog();

    // 保存博客
    Blog saveBlog(Blog blog);

    // 更新博客
    Blog updateBlog(Long id, Blog blog);

    // 删除博客
    void deleteBlog(Long id);
}
