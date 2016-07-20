package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;






import java.util.List;

//import javax.annotation.Resources;
import org.apache.ibatis.io.Resources;

//import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;

import cn.itcast.mybatis.po.City;

public class MybatisFirst {
	//根据ID查询用户的信息，得到一条记录的结果

	@Test
	public void findUserByIdTest() throws IOException
	{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
				build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的ID，等于namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne结果是与 映射文件中所匹配的resultType类型的对象
		City city = sqlSession.selectOne("test.findUserById", 1);
		
		System.out.println(city);
		
		sqlSession.close();
	}
	@Test
	public void findUserByNameTest() throws IOException
	{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
				build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的ID，等于namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne结果是与 映射文件中所匹配的resultType类型的对象
		List<City> list = sqlSession.selectList("test.findCityByName", "Kik");
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() throws IOException
	{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
				build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		City city = new City();
		city.setCountryCode("GBT43243214");
		city.setName("One4321412");
		city.setPopulation(234);
		city.setDistrict("QEW1432143214");
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的ID，等于namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne结果是与 映射文件中所匹配的resultType类型的对象
		/*List<City> list = */
//		尝试用trycatch捕捉异常，这样就能知道insert是否成功
//		try{
		sqlSession.insert("test.insertCity", city);
//		}catch(Exception e)
//		{
//			System.out.println("Wrong");
//		}
		System.out.println(city.getID());
		//提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
}
