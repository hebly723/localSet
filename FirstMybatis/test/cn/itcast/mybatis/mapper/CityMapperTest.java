package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.City;

public class CityMapperTest {
	private SqlSessionFactory sqlSessionFactory;
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建CityMapper对象，mybatis自动生成mapper代理对象
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		
		//调用CityMapper方法
		City city = cityMapper.findCityById(1);
		
		sqlSession.close();
		
		System.out.println(city);
	}
	
	@Test
	public void testFindCityByName() throws Exception{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建CityMapper对象，mybatis自动生成mapper代理对象
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		
		//调用CityMapper方法
		List<City> list = cityMapper.findCityByName("KIK");
		
		sqlSession.close();
		
		System.out.println(list);
	}
	
	@Test
	public void testInsertCity() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		City city = new City();
		city.setCountryCode("HHH");
		city.setName("WHH");
		city.setDistrict("KQS");
		city.setPopulation(13);
		//创建CityMapper对象，mybatis自动生成mapper代理对象
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		
		//调用CityMapper方法
		cityMapper.insertCity(city);
		
		sqlSession.close();
		
		System.out.println();
	}
	
	@Test
	public void testDeleteCity() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建CityMapper对象，mybatis自动生成mapper代理对象
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		
		//调用CityMapper方法
		cityMapper.deleteCity(4084);;
		
		sqlSession.close();
		
		System.out.println();
	}

}
