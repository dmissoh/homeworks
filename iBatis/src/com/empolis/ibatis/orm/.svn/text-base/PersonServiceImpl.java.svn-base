package com.empolis.ibatis.orm;

import com.ibatis.sqlmap.client.SqlMapClient;

public class PersonServiceImpl implements IPersonService {

	protected SqlMapClient sqlMap = null;

	public void setSqlMapClient(SqlMapClient sqlMap) {
		this.sqlMap = sqlMap;
	}

	public Person getPerson(long personId) throws Exception {
		return (Person) sqlMap.queryForObject("personManagement.getPerson", personId);
	}

	public void executeChangeName(long personId) throws Exception {
		sqlMap.update("personManagement.executeChangeName", personId);
	}
}