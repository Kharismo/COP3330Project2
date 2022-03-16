import java.util.*;
import java.io.*;


class Main{
  public static void main(String[] args) {

    String userChoice;
    Scanner mainScan = new Scanner(System.in);

    
    int crn;
    String prefix, title, location, modality, classLevel, classExtra;

    HashMap<Integer,Person> database = new HashMap<Integer,Person>(); // ucf id integer key maps to that person object

    try{
      File file = new File("lec.txt");
      Scanner fileScan = new Scanner(file);
      fileScan.useDelimiter(",");
  
      while(fileScan.hasNextLine()){
     crn = fileScan.nextInt();
     prefix = fileScan.next();
     title = fileScan.next();
     location = fileScan.next();
     modality = fileScan.next();
     classLevel = fileScan.next();
     classExtra = fileScan.next();

     classExtra = classExtra.toUpperCase();

    Lectures newLec = new Lectures(crn, prefix, title, location, modality, classLevel, classExtra);
    //add hashmap

        int comma;
      //Count how many commas there are in a line and if it is more than 1 comma it is not a lab
        if(classExtra.equals("YES")){
          
            while(comma <= 1){
              comma = 0;
              crn = fileScan.nextInt();
              
              location = fileScan.next();
               
            }
          
        }
    }
    }catch(FileNotFoundException e){
      System.out.println("An error occurred in reading the file");
      e.printStackTrace();
    }
      
    
    

  

    
    
    
    do{
         System.out.println("___________Choose one of the options____________________");
         System.out.println();
         System.out.println("1. Add a new faculty to the schedule");
         System.out.println();
         System.out.println("2. Enroll a student to a lecture");
         System.out.println();
         System.out.println("3. Print the schedule of a faculty");
         System.out.println();
         System.out.println("4. Print the schedule of a TA");
         System.out.println();
         System.out.println("5. Print the schedule of a student");
         System.out.println();
         System.out.println("6. Delete a scheduled lecture");
         System.out.println();
         System.out.println("7. Exit Program");
         System.out.println();
         System.out.print("Enter your selection: ");
         userChoice = mainScan.next();
         System.out.println();


        switch(userChoice) {
                                
        case "1":
                                           
          optionOne();
          break;
                                           
        case "2":
                                           
           optionTwo();
           break;

        case "3":

            optionThree();
            break;
            
        case "4":
            optionFour();
            break;
            
        case "5":
            optionFive();
            break;
            
        case "6":
            optionSix();
            break;
            
        case "7":
                                    
          break;
    
      default :
          System.out.println("input unavailable option");
          break;
                                            
                                
       }
    }while(!userChoice.equals("7"));
  
} 
  
}



/*

IMPORTANT READ AND CHECK 


Note that when the user enters an UCF id that either incorrect or when it does not match any existing id, re-print the main menu for the user to choose another option. 

Your code must check the following:
-	A lecture can’t be assigned to two faculty and a Lab can’t assigned be assigned to two TAs
-	A student can’t take two lectures with the same prefix. 
-	UCF ids are unique: When entering the id of any person, do a search to check that the id isn’t already used. An UCF id must be a string of 7 digits.
-	A lab can’t be assigned to two lectures

*/





/*
  Add a new faculty to the schedule
*/
  public static void optionOne(void)
  {
  Scanner sc1 = new Scanner(System.in);
    System.out.println("Enter UCF id:");
    int num = sc1.nextLine();
    System.out.println("Enter name:");
		String name = sc1.nextLine();
    System.out.println("Enter rank:");
	  String rank = sc1.nextLine();
    System.out.println("Enter office location:");
    String location = sc1.nextLine();

    Faculty prof = Faculty(name, num, rank,location);
    database.add(num,prof);
    

    
	  System.out.println("Enter how many lectures:");
    int lecNum = nextLine();
    System.out.println("Enter the crns of the lectures to assign to this faculty");
    for(int i = 0; i < lecNum; i++)
      {
        
        int next = nextInt();
        // make sure class exists 
        // If a lecture has labs, ask to enter the UCF id of the TAs (a TA may do more than one Lab)
        // only enter tas that exist
        prof.lectureTaught.add(next);
      }
    

	  
	

	}

/*
  Enroll a student to a lecture
*/
  public static void optionTwo(void)
  {
    Scanner sc2 = new Scanner(System.in);
    System.out.println("Enter UCF id:");
    int num = sc2.nextLine();
		System.out.println("Enter name:");
    String name = sc2.nextLine();

    System.out.println("How many Lectures:")
    int count = sc2.nextline();

    for(int i = 0; i < count; i++)
      {
        // grab each lecture and add to student and add student to particiapnt 
        // If a lecture requires a lab, randomly pick a lab for the student (no caps on how many students to enroll in a lab) 
        
      }
  



	}

/*
  Print the schedule of a faculty
*/
  public static void optionThree(void)
  {
    Scanner sc3 = new Scanner(System.in);
    System.out.println("Enter UCF id of the Faculty:");
    int check = sc3.nextLine();
    Faculty user = database.get(check.ucfId);
    //check notes on nonexistant person

    System.out.println("UCF ID: " + user.ucfId);
    System.out.println("Name: " + user.name);
    //crns of the lectures taught by the faculty

	}

/*
  Print the schedule of a TA
*/
  public static void optionFour(void)
  {
    
    Scanner sc4 = new Scanner(System.in);
    System.out.println("Enter UCF id of the TA:");
    int check = sc4.nextLine();
    TA user = database.get(check.ucfId);
    //check notes on nonexistant person

    System.out.println("UCF ID: " + user.ucfId);
    System.out.println("Name: " + user.name);
    //crns of the labs taught by the TA  


	}

/*
  Print the schedule of a student
*/
  public static void optionFive(void)
  {
    
    Scanner sc5 = new Scanner(System.in);
    System.out.println("Enter UCF id of the Student:");
    int check = sc5.nextLine();
    Faculty user = database.get(check.ucfId);
    //check notes on nonexistant person

    System.out.println("UCF ID: " + user.ucfId);
    System.out.println("Name: " + user.name);
    //the crns of the Lectures and labs taken by the Student (No need to display anything else).  
    // Nothing is expected to be done when the student happens to be an TA.
		


	}

/*
  Delete a scheduled lecture
*/
  public static void optionSix(void)
  {
		//(Deleting a lecture requires deleting its labs as well)
    // use lab array list 
//Enter crn of the lecture to delete:-------
// check deleting of lab from indivual people 
	}

    
 abstract class Person{
	public String name;
	public int ucfId;
}

/*

*/
class Student extends Person
  {
    String level; // grad or undergrad 
    // hard code???? 
    ArrayList<Lab> possibleLab = new ArrayList<Lab>();// possible list of lecters and labs taken
    ArrayList<Lecture> possibleLecture = new ArrayList<Lecture>();// possible list of lecters and labs taken
  public Student(String name, int ucfId, String level)
  {
    this.name = name;
    this.ucfId = ucfId;
    this.level = level;
	
	}
          
  }

/*

*/
  class TA extends Person
  {
    ArrayList<Lab> labSupervised = new ArrayList<Lab>(); // need to code!!!!!!!!!!!!!!!!
    Faculty advisor;
    String expectedDegree; // ms or phd
    ArrayList<Lab> possibleLab = new ArrayList<Lab>();// possible list of lecters and labs taken
    ArrayList<Lecture> possibleLecture = new ArrayList<Lecture>();// possible list of lecters and labs taken
  public TA(String name, int ucfId, Faculty advisor, String expectedDegree)
  {
    this.name = name;
    this.ucfId = ucfId;
    this.advisor = advisor;
    this.expectedDegree = expectedDegree;
	
	}
  }

/*

*/
class Faculty extends Person
  {
    String rank; // professor, associate professor, assistant professor or adjunct
    String officeLocation;
    ArrayList<Lecture> lectureTaught = new ArrayList<Lecture>(); 
  public Faculty(String name, int ucfId, String rank, String officeLocation)
  {
    this.name = name;
    this.ucfId = ucfId;
    this.rank = rank;
    this.officeLocation = officeLocation;
	
	}
  }

/*

*/
class Lectures{
  int crn;
  String prefix;
  String title;
  String location;
  String modality;
  String classLevel; // graduate or undergraduate.
  String classExtra; // lab yes no or online
  ArrayList<Lab> labsWith = new ArrayList<Lab>();
  ArrayList<Integer> participants = new ArrayList<Intger>(); // ucfid of participants involved which allows easy deleting 
  public Lectures(int crn, String prefix, String title, String location, String modality, String classLevel, String classExtra)
  {
    this.crn = crn;
    this.prefix = prefix;
    this.title = title;
    this.location = location;
    this.modality = modality;
    this.classLevel = classLevel;
    this.classExtra = classExtra;
	
	}
  
  
  
   
	
	}
Class Lab 
  {
    int crn;
    String location;
    public Lab(int crn, String location)
  {
    this.crn = crn;
    this.location = location;
	}
  }
  
}