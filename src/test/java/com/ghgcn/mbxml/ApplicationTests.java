package com.ghgcn.mbxml;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ghgcn.mbxml.domain.Author;
import com.ghgcn.mbxml.mapper.AuthorMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private AuthorMapper authorMapper;

	/**
	 * Insert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Rollback
	public void Insert() throws Exception {

		Author author = new Author();

		author.setAuthorBio("无可奈何花落去枯萎123 ");
		author.setAuthorEmail("qq@qq.com123");
		author.setAuthorPassword("test123123");
		author.setAuthorUsername("无可奈何花落去枯萎");

		authorMapper.add(author);
	}

	@Test
	@Rollback
	public void findById() throws Exception {

		Author author = authorMapper.findAuthor(1);
		System.out.println(author.toString());

	}

	@Test
	@Rollback
	public void findByAll() throws Exception {

		List<Author> authorList = authorMapper.findAuthorList();
		System.out.println(authorList.toString());

	}

	@Test
	@Rollback
	public void delete() throws Exception {

		authorMapper.delete(21);

	}
	
	@Test
	@Rollback
	public void update() throws Exception {

		Author author = authorMapper.findAuthor(2);
		
		author.setAuthorBio("我修改了");
		author.setAuthorEmail("test@test.qq.com");
		author.setAuthorPassword("testtestsetse");
		author.setAuthorUsername("魂牵梦萦载载");
		author.setRegisterTime(new Date());
		authorMapper.update(author);

	}

}