package com.tt.ui.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;


import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import com.tt.services.impl.CdrReconcServiceImpl;
import com.tt.services.impl.CdrTTServiceImpl;
import com.tt.services.impl.CdrTiersServiceImpl;

/**
 * Helper util to assist in user interface
 * 
 * @author Arthur Vin
 */
public class UIUtils implements Serializable {
	private static final long serialVersionUID = 7872083365595569634L;

	private CdrTTServiceImpl cdrTTService;
	private CdrTiersServiceImpl cdrTiersService ;
	private CdrReconcServiceImpl cdrReconcService ;


	private int viewLoadCount = 0;
	private String inFiles="F:\\Var\\InFiles\\";
	private String sqlInFiles="F:/Var/InFiles/";
	//private String outFiles="F:\\Var\\OutFiles\\";
	private String sqlOutFiles="F:/Var/OutFiles/";
	
	private String nbrTT=null;
	private String nbrTiers=null;
	private String nbrMatched;
	
	DefaultStreamedContent csvFileTT;
	DefaultStreamedContent csvFileTiers;
	DefaultStreamedContent csvFileReconc;
	
	
	
	public void greetOnViewLoad(ComponentSystemEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();

		if (viewLoadCount < 1 && !context.isPostback()) {
			String firstName = (String) event.getComponent().getAttributes().get("firstName");
			String lastName = (String) event.getComponent().getAttributes().get("lastName");

			FacesMessage message = new FacesMessage(String.format("Welcome to your account %s %s", firstName, lastName));
			context.addMessage("growlMessages", message);

			viewLoadCount++;
		}
	}

	public String getInFiles() {
		return inFiles;
	}

	public void setInFiles(String inFiles) {
		this.inFiles = inFiles;
	}

	
	public void cdrTTUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			saveFile(event.getFile().getFileName(), event.getFile().getInputstream());
			cdrTTService.LoadDataInfile(sqlInFiles + event.getFile().getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cdrTiersUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			saveFile(event.getFile().getFileName(), event.getFile().getInputstream());
			cdrTiersService.LoadDataInfile(sqlInFiles + event.getFile().getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveFile(String fileName, InputStream in) {
		try {
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(inFiles + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DefaultStreamedContent getCsvFileTT() {
		try {
			cdrTTService.SelectIntoOutfile(sqlOutFiles+"CdrTT.txt");
			InputStream stream;
			stream = new FileInputStream(new File(sqlOutFiles+"CdrTT.txt"));
			csvFileTT=new DefaultStreamedContent(stream,"application/txt","CdrTT.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvFileTT;
	}

	public DefaultStreamedContent getCsvFileTiers() {
		try {
			cdrTiersService.SelectIntoOutfile(sqlOutFiles+"CdrTiers.txt");
			InputStream stream;
			stream = new FileInputStream(new File(sqlOutFiles+"CdrTiers.txt"));
			csvFileTiers=new DefaultStreamedContent(stream,"application/txt","CdrTiers.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvFileTiers;
	}

	public DefaultStreamedContent getCsvFileReconc() {
		try {
			cdrReconcService.SelectIntoOutfile(sqlOutFiles+"CdrReconc.txt");
			InputStream stream;
			stream = new FileInputStream(new File(sqlOutFiles+"CdrReconc.txt"));
			csvFileReconc=new DefaultStreamedContent(stream,"application/txt","CdrReconc.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvFileReconc;
	}
	
	public void truncateCdrTT(){
		cdrTTService.truncate();
	}
	public void truncateCdrTiers(){
		cdrTiersService.truncate();
	}
	
	public void truncateAll(){
		cdrTTService.truncate();
		cdrTiersService.truncate();
	}
	
	
	public CdrTTServiceImpl getCdrTTservice() {
		return cdrTTService;
	}

	public void setCdrTTService(CdrTTServiceImpl cdrTTservice) {
		this.cdrTTService = cdrTTservice;
	}

	public CdrTiersServiceImpl getCdrTiersService() {
		return cdrTiersService;
	}

	public void setCdrTiersService(CdrTiersServiceImpl cdrTiersService) {
		this.cdrTiersService = cdrTiersService;
	}

	public CdrReconcServiceImpl getCdrReconcService() {
		return cdrReconcService;
	}

	public void setCdrReconcService(CdrReconcServiceImpl cdrReconcService) {
		this.cdrReconcService = cdrReconcService;
	}

	public String getNbrTT() {
		setNbrTT(String.valueOf(cdrTTService.Count()));
		return nbrTT;
	}

	public void setNbrTT(String nbrTT) {
		this.nbrTT = nbrTT;
	}

	public String getNbrTiers() {
		setNbrTiers(String.valueOf(cdrTiersService.Count()));
		return nbrTiers;
	}

	public void setNbrTiers(String nbrTiers) {
		this.nbrTiers = nbrTiers;
	}

	public String getNbrMatched() {
		setNbrMatched(String.valueOf(cdrReconcService.Count()));
		return nbrMatched;
	}

	public void setNbrMatched(String nbrMatched) {
		this.nbrMatched = nbrMatched;
	}

	
}
