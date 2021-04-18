package com.qyt.blog.service;

import com.qyt.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    // 保存分类类型
    Type saveType(Type type);

    // 通过id查询分类类型
    Type getType(Long id);

    // 通过name查询类型
    Type getTypeByName(String name);

    // 分页查询分类类型
    Page<Type> listType(Pageable pageable);

    // 查询所有数据
    List<Type> listType();

    // 查询分类前几条(size)数据
    List<Type> listTypeTop(Integer size);

    // 修改分类类型
    Type updateType(Long id, Type type);

    // 删除分类类型
    void deleteType(Long id);
}
