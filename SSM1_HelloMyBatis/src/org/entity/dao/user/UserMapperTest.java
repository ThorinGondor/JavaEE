package org.entity.dao.user;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.log4j.Logger;

public class UserMapperTest {
	private static Logger logger = Logger.getLogger(UserMapperTest.class);
	public static void main(String[] args) throws IOException, SQLException {
		//(1)��ȡȫ�������ļ���"myBatis-config.xml"
		String resources = "mybatis-config.xml";
		InputStream IS = Resources.getResourceAsStream(resources);
		
		//(2)����SQLSessionFactory���󣬸ö��������ɶ������ļ��Ķ�ȡ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(IS);
		
		//(3)����SQLSession���󣬴˶�����Ե���mapper�ļ��������ݲ�����������ע��Ҫ��mapper�ļ����뵽mybatis-config.xml������Ч
		int count = 0;
		String username = null;
		String roleName = null;
		List<User> list0 = new ArrayList<User>();
		List<Provider> list1 = new ArrayList<Provider>();
		
		SqlSession sqlSession = factory.openSession();
		
		count = sqlSession.selectOne("org.entity.dao.user.UserMapper.count");
		logger.debug("UserMapperTest count--->"+count);
		username = sqlSession.selectOne("org.entity.dao.user.UserMapper.userName");
		logger.debug("UserMapperTest username--->"+username);
		roleName = sqlSession.selectOne("org.entity.dao.user.UserMapper.roleName");
		logger.debug("UserMapperTest rolename--->"+roleName);
		list0 = sqlSession.selectList("org.entity.dao.user.UserMapper.userList");
		list1= sqlSession.selectList("org.entity.dao.user.UserMapper.providerList");
		System.out.println("ID"+"\t"+"userName"+"\t"+"userRole");
		for(User buff:list0){
			System.out.println(buff.getID()+"\t"+buff.getUserName()+"\t\t"+buff.getUserRole());
			logger.debug("UserMapperTest userList===>"+buff.getID()+" --- "+buff.getUserName()+" --- "+buff.getUserRole());
		}
		for(Provider buff:list1){
			System.out.println(buff.getID()+"\t"+buff.getProName()+"\t\t"+buff.getProContact());
			logger.debug("UserMapperTest providerList===>"+buff.getID()+" --- "+buff.getProName()+" --- "+buff.getProContact());
		}
		logger.debug("*****************************************************************************************");
		
		//(4)�ر�SqlSession����
		sqlSession.close();
	}

}
