package com.osm.controllers.iofunc;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileIO {
	@SuppressWarnings("unused")
	private static Logger logger=Logger.getLogger(FileIO.class);
	
	public boolean saveFile(HttpServletRequest request, String path, MultipartFile file,String newFileName){
		if (!file.isEmpty()) {
            try {
                String uploadsDir = "/uploads"+path;
                String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
                
                System.out.println("Real Path to Uploads =>"+realPathtoUploads);
                
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdirs();
                }else{
                	System.out.println("Another same name file already exist...try to overwrite");
                }
                
                String orgName = null;
                
                if(newFileName != ""){
                	orgName = newFileName;
                }else{
                	orgName = file.getOriginalFilename();
                }
                
                String filePath = realPathtoUploads + orgName;
                File dest = new File(filePath);
                file.transferTo(dest);
                System.out.println("File saved successfully => "+uploadsDir+orgName);
            }catch(Exception e){
            	e.printStackTrace();
            	return false;
            }
            return true;
		}else{
			System.out.println("Sorry, File is empty...");
			return false;
		}
	}
}
