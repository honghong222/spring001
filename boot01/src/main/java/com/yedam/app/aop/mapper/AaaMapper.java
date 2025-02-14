package com.yedam.app.aop.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;



@Service
public interface AaaMapper {
	@Insert("INSERT INTO tbl_aaa VALUES(#{values})")
	public int insert(String value);
}
