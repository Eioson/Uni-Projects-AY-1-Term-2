import java.util.*;

class intro {
    String name,course;
    int age;
    public void info(Scanner sc){
            System.out.print("\nName: ");
            this.name = sc.nextLine();
            System.out.print("Age: ");
            this.age = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline
            System.out.print("Course: ");
            this.course = sc.nextLine();
    }
    public void introduce(){
        System.out.println("\nMy name is " + this.name + ", I am " + this.age + 
        " years old and I am taking " + this.course + " course.\n");
    }
}

public class Pates_Group1Act extends intro {

    public static void main(String[] sigma){

        Pates_Group1Act obj = new Pates_Group1Act();
        obj.info(new Scanner(System.in));
        obj.introduce();
        
    }
}
