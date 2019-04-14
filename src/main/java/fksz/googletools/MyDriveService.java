package fksz.googletools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

@Component
public class MyDriveService {
	
	Drive driveService = getDrive();
	
	private Drive getDrive() {
		try {
			return GoogleDriveUtils.getDriveService();
		} catch (IOException e) {
			System.out.println("Cannot get Drive instance.");
			e.printStackTrace();
			return null; 
		}
	}
    
	 // com.google.api.services.drive.model.File
    private List<File> getGoogleFilesByName(String fileNameLike) throws IOException {
 
        String pageToken = null;
        List<File> list = new ArrayList<File>();
 

        
        String query =  " name contains '" + fileNameLike + "'"; //
            //    + " and mimeType != 'application/vnd.google-apps.folder' ";
 
        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime, mimeType
                    .setFields("nextPageToken, files(id, name, createdTime, mimeType)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }
	
	 // com.google.api.services.drive.model.File
    public List<File> getGoogleFilesByParent(String parentName) throws IOException {
 
        String pageToken = null;
        File parent = null;
        List<File> list = new ArrayList<File>();
        
        List<File> parents = getGoogleFilesByName(parentName);
        if (parents!= null && parents.size() > 0) {
			parent = parents.get(0);
		}
        
        if (parent != null) {
	        String query =  "'" + parent.getId() + "' in parents";// +
	                // "mimeType != 'application/vnd.google-apps.folder' ";
	 
	        do {
	            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
	                    // Fields will be assigned values: id, name, createdTime, mimeType
	                    .setFields("nextPageToken, files(id, name, createdTime, mimeType, parents)")//
	                    .setPageToken(pageToken).execute();
	            for (File file : result.getFiles()) {
	                list.add(file);
	            }
	            pageToken = result.getNextPageToken();
	        } while (pageToken != null);
	    }
        //
        return list;
    }
    
    
    public File getFileById(String fileId) {
    	try {
			return driveService.files().get(fileId).execute();
		} catch (IOException e) {
			System.out.println("Nem találom a fájlt");
			e.printStackTrace();
			return null;
		}
    }
    
    public OutputStream downloadFile(String fileId) throws IOException {
    	OutputStream outputStream = new ByteArrayOutputStream();
        
        driveService.files().get(fileId).executeMediaAndDownloadTo(outputStream);
        
        if (outputStream != null) {
        	System.out.println("Download of file, with id " + fileId + " success");
        }
        return outputStream;
    }
    
    
}
