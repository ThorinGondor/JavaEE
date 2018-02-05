package org.entity.dao.user;

import java.util.List;

public interface UserMapper {
	public int count();
	public String getUserName();
	public String getRoleName();
	public List<User> getUserList();
	public List<Provider> getProviderList();
}
