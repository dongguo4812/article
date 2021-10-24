package com.dongguo.dao;

import com.dongguo.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Dongguo
 * @date 2021/10/23 0023-11:57
 * @description: 评论的持久层接口
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
    //根据父id，查询子评论的分页列表
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}