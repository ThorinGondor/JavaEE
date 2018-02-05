package org.entity.dao.main;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.entity.dao.user.*;
import org.entity.dao.utils.*;

public class MainRun {
	private static Logger log = Logger.getLogger(MainRun.class);
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		List<User> list0 = new ArrayList<User>();
		List<Provider> list1 = new ArrayList<Provider>();
		sqlSession = MyBatisUtil.createSqlSession();
		
		list0 = sqlSession.getMapper(UserMapper.class).getUserList();
		list1 = sqlSession.getMapper(ProviderMapper.class).getProviderList();  // π”√UserMapperReflect interfaceµƒ”≥…‰
		for(User buff:list0){
			log.debug(buff.getID()+" === "+buff.getUserName()+" === "+buff.getUserRole());
		}
		for(Provider buff:list1){
			log.debug(buff.getID()+" === "+buff.getProName()+" === "+buff.getProContact());
		}
		
		MyBatisUtil.closeSqlSession(sqlSession);
	}

}
