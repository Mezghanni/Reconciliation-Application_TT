package com.tt.dao;

import com.tt.commons.dao.GenericDao;
import com.tt.domain.CdrTT;


public interface CdrTTDao extends GenericDao<CdrTT, Long> {

	/**
	 * Load data Infile Mysql
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean LoadDataInfile(String filePath);
	
	/**
	 * Slect the table content into file
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean SelectIntoOutfile(String filePath);

	public Number Count();

	public void truncate();
}
