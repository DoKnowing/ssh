package client.model;

public class City {
    private long id;
    private String value;
    private Province province;


    public City(long id, String value){
        this.id=id;
        this.value=value;
    }

    public City(){
    }

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "\"id\":\"" + id +
                "\", \"value\":\"" + value +"\"";
    }
}
