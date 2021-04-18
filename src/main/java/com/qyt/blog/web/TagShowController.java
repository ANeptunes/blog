package com.qyt.blog.web;

import com.qyt.blog.pojo.Tag;
import com.qyt.blog.service.BlogService;
import com.qyt.blog.service.TagService;
import com.qyt.blog.vo.BlogQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TagShowController {

    @Resource
    private TagService tagService;

    @Resource
    private BlogService blogService;

    /**
     * 返回分类页面
     *
     * @return 返回分类页面
     */
    @GetMapping("/tags/{id}")
    public String tags(@PathVariable Long id, @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        List<Tag> tags = tagService.listTagTop(Integer.MAX_VALUE);
        if (id == 0) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(id, pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
