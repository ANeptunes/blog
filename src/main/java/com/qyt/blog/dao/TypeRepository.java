package com.qyt.blog.dao;

import com.qyt.blog.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {

    // 通过名称查询分类
    Type findByName(String name);

    // 查询分类数量前几名的数据
    @Query("select t from t_type t")
    List<Type> findTypeTop(Pageable pageable);

}
