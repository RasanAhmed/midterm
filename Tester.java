
import java.util.ArrayList;
import java.util.Scanner;

class BloodPressure{
    private int id,yob,systolic,diastolic;
    private String name;
    
    public BloodPressure(int ID,String Name,int Yob,int Systolic,int Diastolic){
   
        this.id = ID;
        this.yob = Yob;
        this.diastolic = Diastolic;
        this.systolic = Systolic;
        this.name = Name;
    }
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public int getyob(){
        return yob;
    }
    
    public int getsystolic(){
        return systolic;
    }
    
    public int getDiastolic(){
        return diastolic;
    }
    
    public void setId(int i){
        id = i;
    }
    
    public void setName(String N){
        name = N;
    }
    
    public void setyob(int Y){
        yob = Y;
    }
    
    public void setsystolic(int S){
        systolic = S;
    }
    
    public void setDiastolic(int D){
        diastolic = D;
    }
    public double calculate(int age){
        age = 2024-yob;
        return age;
    } 
       
    public void display(){
        System.out.println("Id : "+id);
        System.out.println("Name : "+name);
        System.out.println("Year of Birth : "+yob);
        System.out.println("Systolic : "+systolic);
        System.out.println("Diastolic : "+diastolic);
    }    
        
    
} 
/**
 *
 * @author Rasan
 */
public class Tester {
    private static BloodPressure record(){
        Scanner R = new Scanner(System.in);
        System.out.print("Enter Your ID: ");
        int id = R.nextInt();
        System.out.print("Enter Your Name: ");
        String name = R.next();
        System.out.print("Enter Your Year of Birth: ");
        int yob = R.nextInt();
        System.out.print("Enter The Systolic : ");
        int systolic = R.nextInt();
        System.out.print("Enter The Diastolic : ");
        int diastolic = R.nextInt();
        return new BloodPressure(id,name,yob,systolic, diastolic);

    }
    private static int getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        return scanner.nextInt();
    }

    private static BloodPressure getbpBYId(ArrayList<BloodPressure> bloodpressureRecords, int id) {
        for (BloodPressure bloodpressure : bloodpressureRecords) {
            if (bloodpressure.getId() == id) {
                return bloodpressure;
            }
        }
        return null;
    }
   
    
    public static void displayMenu(){
        System.out.println(" Blood pressure monitor");
        System.out.println("*-----------------------*");
        System.out.println("1. Create a record."); 
        System.out.println("2. Show blood pressure data for all users.");
        System.out.println("3. Show blood pressure data for a selected user.");  
        System.out.println("4. Delete all.");
        System.out.println("5. Exit application.");
        
        System.out.print("Enter Your Choise : ");
    }
    
    public static void index(){
        System.out.println("to show all records");
    }
    public static void view(int Id){
        System.out.println(" to show one record for the given id.");
    } 
    
    public static void create(){
        System.out.println("create a new record"); 
    }
    
    public static void delete(){
        System.out.println("All Blood pressure deleted successfully");
        
    }
    public static void exit(){
        System.out.println("Thank you for using The Blood pressure monitor");
        System.exit(0);
    } 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList <BloodPressure> bloodpressure = new ArrayList<>();
        int choise;
        Scanner in = new Scanner(System.in);
        do{
            displayMenu();
            choise = in.nextInt();
            switch(choise){
                case 1:
                    create();
                    for(int j=0 ; j < 5 ; j++){
                        bloodpressure.add(record());
                        System.out.println("--------------------");
                    }
                    break;
                    
                case 2:
                    index();
                    for(BloodPressure BP : bloodpressure){
                        BP.display();
                        System.out.println("--------------------");
                    }
                    
                    break;
                
                case 3:
                    int id = getId();
                    view(id);
                    BloodPressure bloodpressureToDisplay = getbpBYId(bloodpressure, id);
                    if (bloodpressureToDisplay != null) {
                        bloodpressureToDisplay.display();
                        System.out.println("-----------------------");
                    }
                    
                    else {
                        System.out.println("No bloodpressure record found for the given ID.");
                    }
                    break;
                    
                case 4:
                    delete();
                    bloodpressure.clear();
                    break;
                    
                case 5:
                    exit();
                    break;
                    
                default:
                    System.out.println("Invalid Choise");
                 
            }
                    
        }
        while(true);
        
        
    }
    
    
}
