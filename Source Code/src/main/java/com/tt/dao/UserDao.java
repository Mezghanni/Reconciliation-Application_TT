package com.tt.dao;

import com.tt.commons.dao.GenericDao;
import com.tt.domain.UserEntity;

/**
 * Data access object interface to work with User entity database operations.
 * 
 * @author Arthur Vin
 */
public interface UserDao extends GenericDao<UserEntity, Long> {

	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String userName);
	
	/**
	 * Queries user by username
	 * 
	 * @param userName
	 * @return User entity
	 */
	UserEntity loadUserByUserName(String userName);
}
