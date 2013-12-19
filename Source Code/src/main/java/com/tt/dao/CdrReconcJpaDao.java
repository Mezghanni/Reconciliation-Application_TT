package com.tt.dao;


import java.util.List;

import javax.persistence.Query;

import org.springframework.util.Assert;

import com.tt.commons.dao.GenericJpaDao;
import com.tt.domain.CdrReconc;

public class CdrReconcJpaDao extends GenericJpaDao<CdrReconc, Long> implements CdrReconcDao {

	public CdrReconcJpaDao() {
		super(CdrReconc.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean SelectIntoOutfile(String filePath) {
		Assert.notNull(filePath);
		Query query=getEntityManager()
				.createNativeQuery("SELECT * FROM reconcil_tab INTO OUTFILE :filePath "
							+" FIELDS TERMINATED BY  ',' ENCLOSED BY  '' LINES TERMINATED BY  '\r\n'"
						 ).setParameter("filePath", filePath);
		try {
		@SuppressWarnings("rawtypes")
		List results = query.getResultList();
		if (results.isEmpty()) return true;
		}catch(Exception e){
			return true;
		}
		return true;
	}

	public Number Count(){
		Query q = getEntityManager().createNativeQuery("SELECT count(*) FROM  `reconcil_tab` ");
		Number result = (Number) q.getSingleResult ();
		System.out.println(result);
		
		return result;
		
	}
}
