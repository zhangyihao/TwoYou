package com.zhangyihao.twoyou.dao;

import java.util.List;

import com.zhangyihao.twoyou.entity.Comment;

public interface CommentsDao {
	void add(Comment comment);
	void delete(Comment comment);
	Comment get(Integer id);
	List<Comment> getByImage(Integer imgId);
	List<Comment> getByParentId(Integer parentId);
}
