package com.kapp.view;

import java.io.File;
import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.web.servlet.view.InternalResourceView;

/**
 * Extends InternalResourceView to overwrite
 * the method checkResource()
 * 
 * @author Administrator
 *
 */
public class GenericResourceView extends InternalResourceView {
	
	private Logger logger = Logger.getLogger(GenericResourceView.class.getName());
	
	@Override  
    public boolean checkResource(Locale locale) {
//		logger.info("checkResource of GenericResourceView");
		boolean existed = false;
		
		//check absolute path
     File file = new File(this.getServletContext().getRealPath("/") + getUrl());
     if (file != null) {
    	 existed = file.exists();
     }
     
     if (existed) {
     logger.info("FileExisted is " + existed);
     }
     return existed;
    }

}
