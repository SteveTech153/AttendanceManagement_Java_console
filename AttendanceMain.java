package MiniProject1AttendanceSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AttendanceMain extends AttendanceWithExceptionHandling{
    public static void main(String[] args) {

        Scanner S = new Scanner(System.in);
        AttendanceMain A = new AttendanceMain();
        System.out.println("\n\t\t\t\tAttendance Management System");
        boolean loop=true;
        while(loop){
            System.out.println("");
            System.out.println("");
            System.out.println("1. Management");
            System.out.println("2. Faculty");
            System.out.println("3. Student");
            System.out.println("4. Exit");
            System.out.println("Enter choice : ");
            boolean flag=true;
            int choice=0;
            while(flag) {
                try {
                     choice = S.nextInt();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid choice : ");
                    S.nextLine();
                }

            }

            switch (choice) {
                case 1 :
                    System.out.println("Enter password : ");
                    String pass = S.next();
                    if(pass.compareTo(A.ManagementPassword)!=0){
                        System.out.println("Access denied");
                        break;
                    }
                    else {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("1. view Attendance Report");
                        System.out.println("2. Add new class");
                        System.out.println("3. change password");
                        System.out.println("4. Clear all data");
                        System.out.println("5. Back");
                        int choiceManagement=0;
                        flag=true;
                        while(flag) {
                            try {
                                choiceManagement = S.nextInt();
                                flag=false;
                            }catch (InputMismatchException e){
                                System.out.println("Enter valid choice : ");
                                S.nextLine();
                            }

                        }

                        switch (choiceManagement) {
                            case 1 :
                                A.ViewAttendanceReport();
                                break;
                            case 2:
                                A.AddNewClass();
                                break;
                            case 3:
                                A.changeManagementPassword();
                                break;
                            case 4:
                                A.clearData();
                                break;
                            case 5:
                                break;
                        }
                        break;
                    }
                case 2:
                    System.out.println("Enter password : ");
                    if(S.next().compareTo(A.FacultyPassword)!=0){
                        System.out.println("Access denied !");
                        break;
                    }
                    else {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("1. view Attendance Report");
                        System.out.println("2. Add new student");
                        System.out.println("3. change password");
                        System.out.println("4. change attendance");
                        System.out.println("5. Back");
                        int choiceFaculty=0;
                        flag=true;
                        while(flag) {
                            try {
                                choiceFaculty = S.nextInt();
                                flag=false;
                            }catch (InputMismatchException e){
                                System.out.println("Enter valid valid choice : ");
                            }
                            S.nextLine();
                        }
                        switch (choiceFaculty) {
                            case 1 :
                                A.ViewAttendanceReport();
                                break;
                            case 2:
                                A.addNewStudent();
                                break;
                            case 3:
                                A.changeFacultyPassword();
                                break;
                            case 4:
                                A.changeAttendance();
                                break;
                            case 5:
                                break;
                        }
                        break;
                    }


                case 3:
                    System.out.println("");
                    System.out.println("");
                    System.out.println("1. Mark Attendance");
                    System.out.println("2. Back");
                    int choiceStudent=0;
                    flag=true;
                    while(flag) {
                        try {
                            choiceStudent = S.nextInt();
                            flag=false;
                        }catch (InputMismatchException e){
                            System.out.println("Enter valid valid choice : ");
                        }
                        S.nextLine();
                    }
                    switch (choiceStudent) {
                        case 1 :
                            A.markAttendance();
                            break;
                        case 2:
                            break;
                    }
                    break;

                case 4:
                    loop=false;
                    break;
            }
        }
        System.out.println("Have a good day !");

    }
}
