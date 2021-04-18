package com.qyt.blog.service;

import com.qyt.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    // 保存标签
    Tag saveTag(Tag tag);

    // 通过id查询标签
    Tag getTag(Long id);

    // 通过name查询标签
    Tag getTagByName(String name);

    // 分页查询标签
    Page<Tag> listTag(Pageable pageable);

    // 获取所有的标签
    List<Tag> listTag();

    List<Tag> listTag(String ids);

    // 查询标签前几条(size)数据
    List<Tag> listTagTop(Integer size);

    // 修改标签
    Tag updateTag(Long id, Tag tag);

    // 删除标签
    void deleteTag(Long id);
}
