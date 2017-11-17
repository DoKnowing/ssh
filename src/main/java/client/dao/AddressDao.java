package client.dao;

import client.model.Province;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class AddressDao implements client.daoInterface.AddressDaoInter {

    @Override
    public List<Province> getProvinces(){

        List<Province> provinces=new LinkedList<Province>();
        provinces.add(new Province(1,"北京"));
        provinces.add(new Province(2,"广东"));
        provinces.add(new Province(3,"上海"));
        provinces.add(new Province(4,"天津"));
        provinces.add(new Province(5,"重庆"));
        provinces.add(new Province(6,"辽宁"));
        provinces.add(new Province(7,"江苏"));
        provinces.add(new Province(8,"湖北"));
        provinces.add(new Province(9,"四川"));
        provinces.add(new Province(10,"陕西"));
        provinces.add(new Province(11,"河北"));
        provinces.add(new Province(12,"山西"));
        provinces.add(new Province(13,"河南"));
        provinces.add(new Province(14,"吉林"));
        provinces.add(new Province(15,"黑龙江"));
        provinces.add(new Province(16,"内蒙古"));
        provinces.add(new Province(17,"山东"));
        provinces.add(new Province(18,"安徽"));
        provinces.add(new Province(19,"浙江"));
        provinces.add(new Province(20,"福建"));
        provinces.add(new Province(21,"湖南"));
        provinces.add(new Province(22,"广西"));
        provinces.add(new Province(23,"江西"));
        provinces.add(new Province(24,"贵州"));
        provinces.add(new Province(25,"云南"));
        provinces.add(new Province(26,"西藏"));
        provinces.add(new Province(27,"海南"));
        provinces.add(new Province(28,"甘肃"));
        provinces.add(new Province(29,"宁夏"));
        provinces.add(new Province(30,"青海"));
        provinces.add(new Province(31,"新疆"));
        provinces.add(new Province(32,"香港"));
        provinces.add(new Province(33,"澳门"));
        provinces.add(new Province(34,"台湾"));
        provinces.add(new Province(35,"海外"));
        return provinces;
    }

    @Override
    public Map getCitiesByProvId(long ProvinceId){
        Map cities= new HashMap<Integer,String>();
        cities.put("1","北京");
        cities.put("2","广东");
        cities.put("3","上海");
        cities.put("4","天津");
        cities.put("5","重庆");
        cities.put("6","辽宁");
        cities.put("7","江苏");
        cities.put("8","湖北");
        cities.put("9","四川");
        cities.put("10","陕西");
        cities.put("11","河北");
        cities.put("12","山西");
        cities.put("13","河南");
        cities.put("14","吉林");
        cities.put("15","黑龙江");
        cities.put("16","内蒙古");
        cities.put("17","山东");
        cities.put("18","安徽");
        cities.put("19","浙江");
        cities.put("20","福建");
        cities.put("21","湖南");
        cities.put("22","广西");
        cities.put("23","江西");
        cities.put("24","贵州");
        cities.put("25","云南");
        cities.put("26","西藏");
        cities.put("27","海南");
        cities.put("28","甘肃");
        cities.put("29","宁夏");
        cities.put("30","青海");
        cities.put("31","新疆");
        cities.put("32","香港");
        cities.put("33","澳门");
        cities.put("34","台湾");
        cities.put("35","海外");
        return cities;
    }
}
