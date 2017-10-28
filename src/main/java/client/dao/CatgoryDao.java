package client.dao;

import client.model.Catgory;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 16:31
 * @explain:
 */
public class CatgoryDao {

    public List<Catgory> getCatgories(){
        List<Catgory> catgories=new LinkedList<Catgory>();
        for(int i=0;i<3;i++){
            Catgory catgory=new Catgory();
            catgory.setName(""+i);
            catgory.setTitle(""+i);
            catgories.add(catgory);
        }
        return catgories;
    }

    public Catgory getCategoryById(int catgoryId) {
        Catgory catgory=new Catgory();
        catgory.setName("cateName");
        catgory.setTitle("CateTitle");
        return catgory;
    }
}
