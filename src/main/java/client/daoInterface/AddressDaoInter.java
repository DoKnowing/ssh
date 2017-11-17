package client.daoInterface;

import client.model.Province;

import java.util.List;
import java.util.Map;

public interface AddressDaoInter {
    List<Province> getProvinces();

    Map getCitiesByProvId(long ProvinceId);
}
