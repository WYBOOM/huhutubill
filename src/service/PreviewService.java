package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.record;
import gui.panel.CatagoryPanel;

public class PreviewService {
	CategoryDAO catagoryDAO = new CategoryDAO();
	RecordDAO recordDAO = new RecordDAO();
	 public List<record> getRecordByCategory(int cid){
	        List<record> rs = recordDAO.list(cid);
	        Collections.sort(rs, (r1,r2)->r1.getDate().compareTo(r2.getDate()));
	        return rs;
	

} public List<record> getRecord() {
    List<record> rs = recordDAO.list();
    return rs;
}}
