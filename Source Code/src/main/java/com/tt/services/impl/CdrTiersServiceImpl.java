package com.tt.services.impl;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.tt.dao.CdrTiersDao;
import com.tt.domain.CdrTiers;
import com.tt.services.CdrTiersService;

public class CdrTiersServiceImpl implements CdrTiersService {
	
	private CdrTiersDao cdrTiersDao;

	/**
	 * createCdr : persiste cdr to database
	 * 
	 * @param cdrTT
	 * @return true if success
	 */
	public boolean createCdr(CdrTiers cdrTiers) {

		try {
			
			cdrTiersDao.save(cdrTiers);
			
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

			cdrTiersDao.LoadDataInfile(filePath);

		} catch(Exception e) {
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);

			return false;
		}

		return true;
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

	public CdrTiersDao getCdrTiersDao() {
		return cdrTiersDao;
	}

	public void setCdrTiersDao(CdrTiersDao cdrTiersDao) {
		this.cdrTiersDao = cdrTiersDao;
	}

	public void SelectIntoOutfile(String filePath) {
		try {
			cdrTiersDao.SelectIntoOutfile(filePath);
		
        }catch(Exception e){
        	
        }
	}

	public Number Count() {
		try {
			return cdrTiersDao.Count();
			 
        }catch(Exception e){
        	return null;
        }
	}

	public void truncate() {
		cdrTiersDao.truncate();
		
	}



}
