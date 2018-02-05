package org.entity.dao.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	//静态代码块
	static{
		try{
			InputStream IS = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(IS);
			System.out.println("Factory建立成功！");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//创建SQLSession
	public static SqlSession createSqlSession(){
		return factory.openSession();
	}
	//关闭SQLSession
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null)
			sqlSession.close();
	}
}
