package org.news.DataBase;

import java.sql.*;
import java.util.*;

public class TopicsDAOImple extends BaseDao implements TopicsDAO {
	public int getTotalCount()throws SQLException{
		int count = -1;
		String sql = "SELECT COUNT('ID') FROM Topics";
		count = this.executeCount(sql);
		System.out.println(count);
		return count;
	}
	
	public List<Topic> getPageTopicList(int pageNo, int pageSize){
		List<Topic> list = new ArrayList<Topic>();
		String sql = "SELECT * FROM Topics LIMIT ?, ?";
		try {
			ResultSet RS = this.executeQuery(sql,(pageNo-1)*pageSize,pageSize);
			while(RS.next()){
				list.add(new Topic(RS.getInt("ID"),RS.getString("TopicName")));
			}
			System.out.println("��ȡ����ID�����ݳɹ���");
		} catch (SQLException e) {
			System.out.println("ERROR---��ȡ����ID������ʧ�ܣ�");
			e.printStackTrace();
		}
		return list;
	}
}
