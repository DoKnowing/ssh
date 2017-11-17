package client.model;

import java.util.List;

public class Province {
    private long id;
    private String value;
    private List<City> cityList;

    public Province(long id,String value){
        this.id=id;
        this.value=value;
    }

    public Province(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
