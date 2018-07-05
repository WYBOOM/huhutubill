package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.catagory;
import entity.record;

public class CategoryService {
	CategoryDAO categoryDao = new CategoryDAO();
	RecordDAO recordDao = new RecordDAO();
	
	public List<catagory> list(){
		List<catagory> list = new ArrayList<catagory>();
		list = categoryDao.list();
		for (catagory catagory : list) {
			List<record> r =recordDao.list(catagory.id);
			catagory.recordNumber =r.size();
		}
		Collections.sort(list,(c1,c2)->c2.recordNumber-c1.recordNumber);
		return list;
	}
	public void add(String name){
		catagory c = new catagory();
		c.setName(name);
		categoryDao.add(c);	
	}
	public void update(int id,String name){
		catagory c = categoryDao.get(id);
		c.setName(name);
		categoryDao.update(c);
		
	}
	public void delete(int id){
		categoryDao.delete(id);
	}

}
