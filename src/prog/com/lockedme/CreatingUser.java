package prog.com.lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CreatingUser {
	static Scanner scn = new Scanner(System.in);
	
	public void registeruser() {
		System.out.println("Register the user with this name");
		String name = scn.next();
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString()+"/"+name;
		File theDir = new File(path);
		if (!theDir.exists()){
		    theDir.mkdirs();
		    System.out.println("User is Created");
		}else {
			System.out.println("Error occurs in creation");
		}
	}
}
