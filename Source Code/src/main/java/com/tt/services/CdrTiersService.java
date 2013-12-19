package com.tt.services;


import com.tt.domain.CdrTiers;

public interface CdrTiersService {

	/**
	 * createCdr : persiste cdr to database
	 * 
	 * @param cdrTT
	 * @return true if success
	 */
	public boolean createCdr(CdrTiers cdrTiers);
	
	/**
	 * Load data Infile Mysql
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean LoadDataInfile(String filePath);
}
