package com.tt.dao;

import com.tt.commons.dao.GenericDao;
import com.tt.domain.CdrReconc;

public interface CdrReconcDao extends GenericDao<CdrReconc, Long> {

	boolean SelectIntoOutfile(String filePath);
	public Number Count();

}
