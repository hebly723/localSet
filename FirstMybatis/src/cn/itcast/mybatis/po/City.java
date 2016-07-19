package cn.itcast.mybatis.po;

public class City {
	//属性名要和数据库表的字段对应
	private int ID;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;

	@Override
	public String toString() {
		return "City [ID=" + ID + ", Name=" + Name + ", CountryCode="
				+ CountryCode + ", District=" + District + ", Population="
				+ Population + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}
	
}
