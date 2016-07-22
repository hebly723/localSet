package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.City;

public class CityDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;

	//此方法在执行其他方法之前执行
	@Before
	public void setUp() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().
						build(inputStream);
		
	}

	@Test
	public void testFindCityById() throws Exception {
		//创建citydao的对象
		CityDao cityDao = new CityDaoImpl(sqlSessionFactory);
		//调用citydao的方法
		City city = cityDao.findCityById(2);
		
		System.out.println(city);
	}

//	@Test
//	public void testInsertCity() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteCity() {
//		fail("Not yet implemented");
//	}

}
