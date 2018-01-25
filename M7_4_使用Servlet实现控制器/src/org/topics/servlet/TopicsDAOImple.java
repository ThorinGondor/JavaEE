package org.topics.servlet;

import java.sql.*;
import java.util.*;

public class TopicsDAOImple extends BaseDAO implements TopicsDAO{
	public TopicsDAOImple(Connection conn) {
		super(conn);
	}
    //��ȡ��������Topics
	public List<Topic> getAllTopics(){
		List<Topic> list = new ArrayList<Topic>();
		ResultSet RS = null;
		String sql = "SELECT * FROM Topics";
		try {
			RS = this.executeQuery(sql);
			System.out.println("��ȡ���ݳɹ���");
			while(RS.next()){	
				list.add(new Topic(RS.getInt("ID"),RS.getString("TopicName")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int deleteTopics(int ID){
		int result = -1;
		String sql = "DELETE FROM Topics WHERE ID = ?";
		try {
			result = this.executeUpdate(sql, ID);
			if(result!=-1)
				System.out.println("ɾ�����ݿ�ָ�����ݳɹ���");
			else
				System.out.println("�������ID�Ų����ڣ�");
		} catch (SQLException e) {
			System.out.println("ERROR---ɾ�����ݿ�ָ������ʧ�ܣ�");
			e.printStackTrace();
		}
		return result;
	}
}
