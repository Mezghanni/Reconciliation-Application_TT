package com.tt.dao;

import com.tt.commons.dao.GenericDao;
import com.tt.domain.CdrTiers;

public interface CdrTiersDao extends GenericDao<CdrTiers, Long> {

	/**
	 * Load data Infile Mysql
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean LoadDataInfile(String filePath);

	public boolean SelectIntoOutfile(String filePath);

	public Number Count();

	public void truncate();
}
