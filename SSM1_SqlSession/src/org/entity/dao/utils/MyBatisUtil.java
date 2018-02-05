package org.entity.dao.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	//��̬�����
	static{
		try{
			InputStream IS = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(IS);
			System.out.println("Factory�����ɹ���");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//����SQLSession
	public static SqlSession createSqlSession(){
		return factory.openSession();
	}
	//�ر�SQLSession
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null)
			sqlSession.close();
	}
}
