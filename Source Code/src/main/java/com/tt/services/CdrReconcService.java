package com.tt.services;

import java.io.InputStream;

import com.tt.domain.CdrTT;

public interface CdrReconcService {

	/**
	 * createCdr : persiste cdr to database
	 * 
	 * @param cdrTT
	 * @return true if success
	 */
	public boolean createCdr(CdrTT cdrTT);
	
	/**
	 * persist cdr file in database
	 * 
	 * @param cdrFile
	 * @return true if suceess
	 */
	public boolean parseCdr(InputStream cdrFile);
}
