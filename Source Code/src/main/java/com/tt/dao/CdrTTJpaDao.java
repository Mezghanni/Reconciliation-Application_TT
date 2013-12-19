package com.tt.dao;



import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.tt.commons.dao.GenericJpaDao;
import com.tt.domain.CdrTT;

public class CdrTTJpaDao extends GenericJpaDao<CdrTT, Long> implements CdrTTDao {

	public CdrTTJpaDao() {
		super(CdrTT.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Load data Infile Mysql
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean LoadDataInfile(String filePath){
		Assert.notNull(filePath);
		Query query=getEntityManager()
				.createNativeQuery("LOAD DATA LOCAL INFILE  :filePath INTO TABLE CDR_TT"
						+ " FIELDS TERMINATED BY  ',' ENCLOSED BY  '' LINES TERMINATED BY  '\n' IGNORE 1 LINES (anbr, bnbr,date,heure,dure) ;" )
						.setParameter("filePath", filePath);
		try {
		query.executeUpdate();
		}catch(NoResultException e){
			return false;
		}
		return true;
	}
	
	/**
	 * Slect the table content into file
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean SelectIntoOutfile(String filePath){
		Assert.notNull(filePath);
		Query query=getEntityManager()
				.createNativeQuery("SELECT * FROM CDR_TT INTO OUTFILE :filePath "
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

	@Override
	public Number Count() {
		Query q = getEntityManager().createNativeQuery("SELECT count(*) FROM  CDR_TT ");
		Number result = (Number) q.getSingleResult ();
		
		return result;
	}

	@Override
	public void truncate() {
		Query q = getEntityManager().createNativeQuery("TRUNCATE TABLE CDR_TT ");
		q.executeUpdate();
		
	}

}
