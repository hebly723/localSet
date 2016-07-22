package cn.itcast.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.City;

//dao接口实现类
public class CityDaoImpl implements CityDao {

	private SqlSessionFactory sqlSessionFactory;
	public CityDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	//需要在dao实现类中注入sqlsessionfactory
	//这里通过构造方法注入
	@Override
	public City findCityById(int ID) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		City city = sqlSession.selectOne("test.findCityById", ID);
		
		//释放资源
		sqlSession.close();
		return city;
	}

	@Override
	public void insertCity(City city) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("test.insertCity", city);
		
		sqlSession.commit();
		
		sqlSession.close();
	}

	@Override
	public void deleteCity(int ID) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("test.deleteCity", ID);
		
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	@Override
	public List<City> findCityByName(String Name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<City> list = sqlSession.selectOne("test.findCityById", Name);
		
		//释放资源
		sqlSession.close();
		return list;
	}

}
