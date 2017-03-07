package com.ghgcn.mbxml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ghgcn.mbxml.domain.Author;

@Mapper
public interface AuthorMapper {
	
	public int add(Author author);
	
	public int update(Author author);
	
	
	public int delete(@Param("id")int id);
	
	public Author findAuthor(@Param("id")int id);
	
	public List<Author> findAuthorList();
}
