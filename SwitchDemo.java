package Project;

import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class SwitchDemo {


    public void fileCreate() {


        try {
            Scanner f = new Scanner(System.in);
            System.out.println("Please create a file: \n");
            String b = f.next();
            File file = new File("C:\\Users\\rahul\\Desktop\\PG_FSD\\" + b);
            if (file.exists()) {
                System.out.println("File already exists in the directory\n");
            } else {
                file.createNewFile();
                System.out.println("File has been created\n");
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("a problem occurred\n");
        }

    }


    public void FindFile() {

        File folder = new File("C:\\Users\\rahul\\Desktop\\PG_FSD\\");
        File[] files = folder.listFiles();
        Scanner scan = new Scanner(System.in);
        System.out.println("If you want to see all the Files and folder in Directory press:  'Y' ");
        System.out.println("--------OR-------");
        System.out.println("If you want to search a file press :  'N' \n");
        String answer = scan.next();
        String name = answer.toLowerCase();



        if (name.contains("y"))
        {
            for (File file : files) {

                if (file.isFile()) {

                    System.out.println("File Name is: " + file.getName());
                }


                else if (file.isDirectory())
                {
                   
                    System.out.println("This is a Directory: " + file.getName());
                }
                else
                {
                    System.out.println("This is not a file nor a Directory\n");
                }
            }
        }
    }


        
    

    public void deleteFile()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the of the File, You want to delete: \n");
        String deleteFileName = scan.next();
        File folder = new File("C:\\Users\\rahul\\Desktop\\PG_FSD\\" + deleteFileName);

        if(folder.delete()){
            System.out.println( deleteFileName +" :File is deleted\n");
        }
        else
        {
            System.out.println( deleteFileName +" :File is not found\n");
        }

    }

    public static void main(String[] args) {

    	   Scanner s1 = new Scanner(System.in);
    	   String opt = null;
    	   do{
            try {
            	Scanner s = new Scanner(System.in);
                System.out.println("Enter the operation: " + "\n"
                        + "1: Create File" + "\n" + "2: Search a File" + "\n" + "3: Delete File");
                int a = s.nextInt();

                switch (a) {


                    case 1: {
                    	SwitchDemo sd = new SwitchDemo();
                        sd.fileCreate();
                        break;
                    }
                    case 2: {
                    	SwitchDemo sd = new SwitchDemo();
                        sd.FindFile();
                        break;
                    }
                    case 3: {
                    	SwitchDemo sd = new SwitchDemo();
                        sd.deleteFile();
                        break;
                    }                 
                }
            }
                
             catch (InputMismatchException e) {
                System.out.println("The Input is not valid");
                System.out.println("Please enter a Integer Number between 1 , 2 and 3");
       
            }
             System.out.println("\nIf you want to continue file operations, type : Y or else N");
             opt = s1.next();
             }while(opt.equalsIgnoreCase("Y"));
    	   System.out.println("\nExit. Thank you for using the tool.");
            s1.close(); 
        }
    }
