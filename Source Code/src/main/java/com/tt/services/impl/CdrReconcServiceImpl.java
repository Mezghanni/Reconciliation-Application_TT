package com.tt.services.impl;

import java.io.InputStream;

import com.tt.dao.CdrReconcDao;
import com.tt.domain.CdrTT;
import com.tt.services.CdrReconcService;

public class CdrReconcServiceImpl implements CdrReconcService {

	private CdrReconcDao cdrReconcDao;

	@Override
	public boolean createCdr(CdrTT cdrTT) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean parseCdr(InputStream cdrFile) {
		// TODO Auto-generated method stub
		return false;
	}

	public CdrReconcDao getCdrReconcDao() {
		return cdrReconcDao;
	}

	public void setCdrReconcDao(CdrReconcDao cdrReconcDao) {
		this.cdrReconcDao = cdrReconcDao;
	}

	public boolean SelectIntoOutfile(String filePath) {
		try {
			cdrReconcDao.SelectIntoOutfile(filePath);
			return true;
        }catch(Exception e){
        	return true;
        }
		
	}
	public Number Count() {
		try {
			return cdrReconcDao.Count();
			 
        }catch(Exception e){
        	return null;
        }
		
	}

}
