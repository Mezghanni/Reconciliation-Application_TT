package com.tt.services.impl;


import java.util.ResourceBundle;





import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.tt.dao.CdrTTDao;
import com.tt.domain.CdrTT;
import com.tt.services.CdrTTService;


public class CdrTTServiceImpl implements CdrTTService {

	private CdrTTDao cdrTTDao;

	/**
	 * createCdr : persiste cdr to database
	 * 
	 * @param cdrTT
	 * @return true if success
	 */
	public boolean createCdr(CdrTT cdrTT) {

		try {

			cdrTTDao.save(cdrTT);

		} catch(Exception e) {
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);

			return false;
		}

		return true;
	}

	/**
	 * Load data Infile Mysql
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean LoadDataInfile(String filePath){
		try {

			cdrTTDao.LoadDataInfile(filePath);

		} catch(Exception e) {
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);

			return false;
		}

		return true;
	}
	/**
	 * Select data into Outfile
	 * 
	 * @param filePath
	 * @return true if sucess
	 */
	public boolean SelectIntoOutfile(String filePath){
		
        try {
			cdrTTDao.SelectIntoOutfile(filePath);
			return true;
        }catch(Exception e){
        	return true;
        }
	}

	protected FacesMessage constructErrorMessage(String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}

	protected FacesMessage constructInfoMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}

	protected FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected ResourceBundle getMessageBundle() {
		return ResourceBundle.getBundle("message-labels");
	}

	public CdrTTDao getCdrTTDao() {
		return cdrTTDao;
	}

	public void setCdrTTDao(CdrTTDao cdrTTDao) {
		this.cdrTTDao = cdrTTDao;
	}

	public Number Count() {
		try {
			return cdrTTDao.Count();
			 
        }catch(Exception e){
        	return null;
        }
	}

	public void truncate() {
		cdrTTDao.truncate();
	}




}
