package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.config;
import util.DBUtil;

public class ConfigDAO {
	public int getTotal(){
		int total =0;
		try (Connection c= DBUtil.getConnection();Statement s = c.createStatement();){
			String sql = "select count(*) from config";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				total = rs.getInt(1);
			}
		System.out.println("Total:"+total);	
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}
	public void add(config config){
		String sql = "insert into config values(null,?,?)";
		try (Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, config.key);
			ps.setString(2, config.value);
			ps.execute();
			ResultSet rs =ps.getGeneratedKeys();
			while(rs.next()){
				int id = rs.getInt(1);
				config.id = id;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update(config config){
		String sql = "update config set key_=?,value =? where id =?";
		try (Connection c= DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, config.key);
			ps.setString(2, config.value);
			ps.setInt(3, config.id);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void delete(int id){
		try (Connection c = DBUtil.getConnection();Statement s =c.createStatement()){
			String sql = "delete from config where id ="+id;
			s.execute(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public config get(int id){
		config config =null;
		String sql = "select * from config where id ="+id;
		try (Connection c = DBUtil.getConnection();Statement s =c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				config = new config();
                String key = rs.getString("key_");
                String value = rs.getString("value");
                config.key = key;
                config.value = value;
                config.id = id;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return config;
	}
	public List<config> list(){
		return list(0,Short.MAX_VALUE);
	}
	
	public List<config> list(int start,int end){
		List<config> list = new ArrayList<>();
		String sql ="select * from config order by id desc limit ?,?";
		try (Connection c = DBUtil.getConnection();PreparedStatement ps =c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				config config = new config();
				int id =rs.getInt(1);
				String key =rs.getString("key_");
				String value = rs.getString("value");
				config.id = id;
				config.key = key;
				config.value = value;
				list.add(config);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	public config getByKey(String key){
		config config =null;
		String sql = "select * from config where key_=?";
		try (Connection c = DBUtil.getConnection();PreparedStatement ps =c.prepareStatement(sql)){
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				config = new config();
				int id = rs.getInt(1);
                String value = rs.getString("value");
                config.id = id;
                config.value = value;
                config.key = key;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return config;
	
		
		
	}

}
