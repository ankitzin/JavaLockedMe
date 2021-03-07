package prog.com.lockedme;

import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserInteration {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option = 0;
		Scanner scn = new Scanner(System.in);
		
		System.out.println("*****************************************************************");
		System.out.println("********************* Locked Me *********************************");
		System.out.println("*****************************************************************");
		
		System.out.println();
		
		System.out.println(" 1. New User Details");
		System.out.println(" 2. Already User Login");
		
		System.out.println();
		
		System.out.println("Enter your choice");
		option = scn.nextInt();
		
		switch(option) {
		case 1: System.out.println("User Registering");
				break;
		case 2: System.out.println("Please Login");
				loggedInUser();
				break;
		default:
				System.out.println("Wrong Choice, Retry the application");
		
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
			System.out.println("Choose your option to perform task");
			System.out.println("1. Display the File available in ascending order");
			System.out.println("2. Business Level Operation");
			useroption = scn.nextInt();
			switch(useroption) {
			case 1:
				System.out.println("Displaying list of files");
				break;
			case 2:
				System.out.println(" Business operation to be performed");
				int bznoption = 0;
				System.out.println("Please select the option to perfrom operation");
				System.out.println(" 1. Add file \n 2. Delete File \n 3. Search File \n 4. Close the current operation");
				bznoption = scn.nextInt();
				switch( bznoption) {
				case 1:
					System.out.println("Adding the file");
					addfile(path);
					break;
				case 2:
					System.out.println("Deleting the file");
					break;
				case 3:
					System.out.println("Searching the file");
					break;
				case 4:
					System.out.println("Closing the file");
					break;
				default:
					System.out.println("Not the correct option");
					break;
				}
			default:
				System.out.println("Not the correct option");
				break;
			}
		}else {
			System.out.println("User Doesnt exist please register first");
		}
	}
	
	static void addfile(String directorypath) {
		try {
			String name = "";
			System.out.println("Enter the name of file to insert");
			name = scn.next();
			String path = directorypath;
			File f = new File(directorypath+"/"+name+".txt");
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
}
