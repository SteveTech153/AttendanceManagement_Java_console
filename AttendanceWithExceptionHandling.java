package MiniProject1AttendanceSystem;

import java.util.*;

public class AttendanceWithExceptionHandling {

    LinkedHashMap <String,LinkedHashMap<String, LinkedHashMap<String,String>>> Attendance= new LinkedHashMap<>();
        String ManagementPassword = "MANAGEMENT",FacultyPassword="FACULTY";
        Scanner S =new Scanner(System.in);


        public void AddNewClass(){
            String dpt = null;
            System.out.println("Enter dept : ");
            boolean flag = true;
            while(flag) {
                try {
                    dpt = S.next();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid dept : ");
                }
                S.nextLine();
            }
            System.out.println("Enter Sec : ");
            flag=true;
            String sec=null;
            while(flag) {
                try {
                    sec = S.next();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid sec : ");
                }
                S.nextLine();
            }

            Attendance.put(dpt,new LinkedHashMap<>(){});
            Attendance.get(dpt).put(sec,new LinkedHashMap<>());
            System.out.println("Enter total number of students : ");
            int total=0;
            flag=true;
            while(flag) {
                try {
                    total = S.nextInt();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid total number of students : ");
                }
                S.nextLine();
            }

            System.out.println("Enter number of lateral entry students");
            int lateral=0;
            flag=true;
            while(flag) {
                try {
                    lateral = S.nextInt();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid total number of laterals : ");
                }
                S.nextLine();
            }
            System.out.println("Enter rollNo format : ");
            String rollNoFormat = S.next();
            String wordTmp = rollNoFormat.substring(0,3);
            int tmp,no=0;
            for(int i1=0;i1<total;i1++){
                if(sec.compareToIgnoreCase("A")==0)
                    no=101;
                else if(sec.compareToIgnoreCase("B")==0)
                    no=201;
                tmp=i1+no;
                Attendance.get(dpt).get(sec).put(wordTmp+tmp,"absent");
            }
            for(int i1=0;i1<lateral;i1++){
                if(sec.compareToIgnoreCase("A")==0)
                    no=501;
                else if(sec.compareToIgnoreCase("B")==0)
                    no=601;
                tmp=i1+no;
                Attendance.get(dpt).get(sec).put(wordTmp+tmp,"absent");
            }
            System.out.println("New class added !");
        }
        public void ViewAttendanceReport(){
            System.out.println("Enter dept : ");
            boolean flag = true;
            String dpt=null;
            while(flag) {
                try {
                    dpt = S.next();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid dept : ");
                }
                S.nextLine();
            }
            System.out.println("Enter Sec : ");
            String sec =S.next();
            if(Attendance.containsKey(dpt)) {
                System.out.println(Attendance.get(dpt).get(sec));

            }
            else {
                System.out.println("No such department exists");
            }
        }
        public void changeManagementPassword(){
            ManagementPassword= S.next();
            System.out.println("password changed !");
        }
        public void changeFacultyPassword(){
            FacultyPassword= S.next();
            System.out.println("password changed !");
        }
        public void addNewStudent(){
            System.out.println("Enter dept : ");
            String dpt = S.next();
            System.out.println("Enter Sec : ");
            String sec =S.next();
            System.out.println("Enter the number of students you want to add : ");
            int lngth = S.nextInt();
            for(int i=0;i<lngth;i++){
                System.out.print("Enter RollNo : ");
                Attendance.get(dpt).get(sec).put(S.next(),"absent");
            }
            System.out.println("New student added successfully !");
        }
        public void changeAttendance(){
            System.out.println("Enter dept : ");
            String dpt = S.next();
            System.out.println("Enter Sec : ");
            String sec =S.next();
            System.out.println("Enter RollNo : ");
            String rollNo = S.next();
            System.out.println("Enter status : ");
            String status =S.next();
            Attendance.get(dpt).get(sec).replace(rollNo,status);
            System.out.println("change is made !");
        }
        public void markAttendance(){
            System.out.println("Enter dept : ");
            String dpt = S.next();
            System.out.println("Enter Sec : ");
            String sec =S.next();
            System.out.println("Enter RollNo : ");
            boolean flag=true;
            String rollNo=null;
            while(flag) {
                try {
                    rollNo = S.next();
                    flag=false;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid RollNo : ");
                }
                S.nextLine();
            }
            if(Attendance.get(dpt).get(sec).containsKey(rollNo)) {
                Attendance.get(dpt).get(sec).replace(rollNo, "present");
                System.out.println("Attendance Marked !");
            }
            else
                System.out.println("Sorry ! No such RollNo exists");

        }
        public void clearData(){
            Attendance.clear();
            System.out.println("All data cleared");

        }
}
