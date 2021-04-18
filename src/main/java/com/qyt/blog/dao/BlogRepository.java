package com.qyt.blog.dao;

import com.qyt.blog.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from t_blog b where b.published = true")
    Page<Blog> findPublishedBlogs(Pageable pageable);

    @Query("select b from t_blog b where b.recommend = true")
    List<Blog> findRecommendBlogTop(Pageable pageable);

    @Query(value = "select * from t_blog b order by b.views DESC limit ?1",nativeQuery = true)
    List<Blog> findHotBlogTop(Integer size);


    @Query("select b from t_blog b where b.title like ?1 or b.description like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update t_blog b set b.views=b.views+1 where b.id = ?1")
    int updateViews(Long id);

    //    @Query("select function('date_format',b.updateTime,'%Y %m') as date from t_blog b group by date order by date desc")
    @Query(value = "select date_format(b.update_time,'%Y %m') as date from t_blog b group by date order by date DESC", nativeQuery = true)
    List<String> findGroupByYearAndMonth();

    @Query(value = "select * from t_blog b where date_format(b.update_time,'%Y %m') = ?1", nativeQuery = true)
    List<Blog> findByDate(String date);
}
