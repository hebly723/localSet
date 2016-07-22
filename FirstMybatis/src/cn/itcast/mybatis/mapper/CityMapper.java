package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.City;

//mapper接口,相当于dao接口， 用户管理
public interface CityMapper {
	//根据ID查询用户的信息
	public City findCityById(int ID) throws Exception;
	
	//根据姓名查询用户信息
	public List<City> findCityByName(String Name)throws Exception;
	
	//添加用户信息
	public void insertCity(City city)throws Exception;
	
	//删除用户信息
	public void deleteCity(int ID) throws Exception;

}
