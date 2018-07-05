package service;

import java.util.Date;

import dao.RecordDAO;
import entity.catagory;
import entity.record;

public class RecordService {
	RecordDAO recordDao = new RecordDAO();
	public void add(int spend,catagory c ,String comment,Date date){
		record r = new record();
		r.spend =spend;
		r.cid = c.id;
		r.comment = comment;
		r.date = date;
		recordDao.add(r);
		
	}
}
