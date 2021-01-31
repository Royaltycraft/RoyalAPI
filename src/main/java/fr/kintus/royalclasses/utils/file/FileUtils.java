package fr.kintus.royalclasses.utils.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * A Class providing static functions to manage a json data file for a player without the need of parsing its content.
 * Currently handling CustomNPCs.
 * 
 * In the future, it would be interesting to check if parsing costs will be better than a complete file erase/write.
 * @author K1ntus
 *
 */
public final class FileUtils {
	private static final String pathCustomNPCFolder = "customnpcs/playerdata/";
	

	public static String readCustomNPCDataFile(UUID uuid) {
		try {
			return readFile(pathCustomNPCFolder + uuid + ".json", Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public static void writeCustomNPCDataFile(UUID uuid, String fileContent) {
		writeToFile(pathCustomNPCFolder + uuid + ".json", fileContent);
	}




	private static void writeToFile(String path, String content) {
	    BufferedWriter bw = null;
	    try {
	        bw = new BufferedWriter(new FileWriter(path));
	        bw.write(content);
	    } catch(IOException e) {
	       // Handle the exception
	    }
	    finally {   
	        if(bw != null) {
	            try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	}


	private static String readFile(String path, Charset encoding)
			throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
