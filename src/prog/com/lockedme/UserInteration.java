package prog.com.lockedme;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;
//import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserInteration {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option = 0;
		Scanner scn = new Scanner(System.in);
		CreatingUser user = new CreatingUser();
		
		System.out.println("*****************************************************************");
		System.out.println("********************* Locked Me *********************************");
		System.out.println("*****************************************************************");
		
		System.out.println();
		
		System.out.println(" 1. New User Details");
		System.out.println(" 2. Already User Login");
		
		System.out.println();
		
		System.out.println("Enter your choice");
		
		boolean repeat = true;
		while(repeat) {
			option = scn.nextInt();
			switch(option) {
			case 1: System.out.println("*****************************************************************");
					System.out.println("User Registering");
					System.out.println("*****************************************************************");
					user.registeruser();
					repeat = true;
					System.out.println("Try Login again");
					break;
			case 2: System.out.println("Please Login");
					loggedInUser();
					repeat = true;
					break;
			default:
					System.out.println("Wrong Choice, Retry the application");
					repeat = false;
					break;
			}
		}
	}
	
	static void loggedInUser() {
		String name = "";
		System.out.println("Enter the User name");
		
		name = scn.next();
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString()+"/"+name;
		File file = new File(path);
		
		if(file.isDirectory()) {
			int useroption = 0;
			System.out.println("User exists");
			boolean repeat = true;
			while(repeat) {
				System.out.println("Choose your option to perform task");
				System.out.println("1. Display the File available in ascending order");
				System.out.println("2. Business Level Operation");
				useroption = scn.nextInt();
				switch(useroption) {
				case 1:
					System.out.println("Displaying list of files");
					listoffiles(path);
					repeat = true;
					break;
				case 2:
					System.out.println(" Business operation to be performed");
					int bznoption = 0;
					boolean repeatunder = true;
					while(repeatunder) {
						System.out.println("Please select the option to perfrom operation");
						System.out.println(" 1. Add file \n 2. Delete File \n 3. Search File \n 4. Close the current operation");
						bznoption = scn.nextInt();
						switch( bznoption) {
						case 1:
							System.out.println("Adding the file");
							addfile(path);
							repeatunder = true;
							break;
						case 2:
							System.out.println("Deleting the file");
							deletefile(path);
							repeatunder = true;
							break;
						case 3:
							System.out.println("Searching the file");
							boolean found = searchingfile(path);
							if(found) {
								System.out.println("Available in" + path);
							}else {
								System.out.println("Not Available ");
							}
							repeatunder = false;
							break;
						case 4:
							System.out.println("Closing the file");
							repeatunder = false;
							break;
						default:
							System.out.println("Not the correct option");
							repeatunder = true;
							break;
						}
					}
					repeat = true;
					break;
					
				default:
					System.out.println("Not the correct option");
					repeat = true;
					break;
				}
			}
			
		} else {
			System.out.println("User Doesnt exist please register first");
		}
	}
	
	static void addfile(String directorypath) {
		try {
			String name = "";
			System.out.println("Enter the name of file to insert");
			name = scn.next();
			String path = directorypath;
			File f = new File(path+"/"+name+".txt");
			if(f.createNewFile()) {
				System.out.println("File Created");
			}else {
				if(f.exists()) {
					System.out.println("File Already Exists");
				}else {
					System.out.println("File Doesnt exist");
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void deletefile(String directorypath) {
			String name = "";
			System.out.println("Enter the name of file to insert");
			name = scn.next();
			String path = directorypath;
			File f = new File(path+"/"+name+".txt");
			if(f.exists()) {
				boolean bool = f.delete();
				if(bool) {
					System.out.println("File Deleted");
				}else {
					System.out.println("File Doesnt exist");
				}
			}else {
				System.out.println("File is not available");
			}
	}
	
	static boolean searchingfile(String directorypath) {
		System.out.println("Enter the file to get searched in this directory");
		String name = "";
		name = scn.next();
		File f = new File(directorypath+"/"+name+".txt");
		if(f.exists()) {
			return true;
		}else {
			return false;
		}
	}
	
	static void listoffiles(String directorypath) {
		File fileDir = new File(directorypath);
		if(fileDir.isDirectory()) {
			List<String> listFile = Arrays.asList(fileDir.list());
			Collections.sort(listFile);
			System.out.println("---------------------------------------");
			System.out.println("Sorting by filename in ascending order");
			for(String s:listFile){
				System.out.println(s);
			}
		}
	}
}
