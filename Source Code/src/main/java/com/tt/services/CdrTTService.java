package com.tt.services;



import com.tt.domain.CdrTT;

public interface CdrTTService {

	/**
	 * createCdr : persiste cdr to database
	 * 
	 * @param cdrTT
	 * @return true if success
	 */
	public boolean createCdr(CdrTT cdrTT);
	
	/**
	 * Load data Infile Mysql
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean LoadDataInfile(String filePath);
	
	/**
	 * Select data into Outfile
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean SelectIntoOutfile(String filePath);
}
