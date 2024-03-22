import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Öğrenci İşlem Menüsü");
        System.out.println("Lütfen işlem yapılacak öğrenci sayısını giriniz:");
        //Öğrenci Bilgilerini Alma İşlemi
        int studentAmount;
        Scanner scanner=new Scanner(System.in);
        studentAmount=scanner.nextInt();
        int[] StudentsNumber=new int[studentAmount];
        String[] StudentsName=new String[studentAmount];
        double[] StudentsVize=new double[studentAmount];
        double[] StudentsFinal=new double[studentAmount];
        for(int i=0;i<studentAmount;i++){
            int vizeStatus=0,finalStatus=0;
            System.out.println((i+1)+". Öğrencinin numarasını giriniz:");
            StudentsNumber[i]=scanner.nextInt();
            scanner.nextLine();
            System.out.println((i+1)+". Öğrencinin ismini giriniz:");
            StudentsName[i]=scanner.nextLine();
            while(vizeStatus==0) {
                System.out.println((i + 1) + ". Öğrencinin vize notunu giriniz:");
                StudentsVize[i] = scanner.nextDouble();
                if ((StudentsVize[i] >= 0 && StudentsVize[i] <= 100)) {
                    vizeStatus=1;
                }
                else if (!(StudentsVize[i] >= 0 && StudentsVize[i] <= 100)) {
                    System.out.println("Lütfen 0-100 arası değer giriniz!");
                }
            }
            while(finalStatus==0) {
                System.out.println((i+1)+". Öğrencinin final notunu giriniz:");
                StudentsFinal[i]=scanner.nextDouble();
                if ((StudentsFinal[i] >= 0 && StudentsFinal[i] <= 100)) {
                    finalStatus=1;
                }
                else if (!(StudentsFinal[i] >= 0 && StudentsFinal[i] <= 100)) {
                    System.out.println("Lütfen 0-100 arası değer giriniz!");
                }
            }
        }
        CleanConsole();
        //Öğrenci Listeleme İşlemleri
        int transactionNo=0;
        while(transactionNo!=-1) {
            ListMenu();
            int result = 0;
            while (result == 0) {
                System.out.println("Lütfen Yapmak İstediğiniz İşlemin Numarasını Giriniz:");
                transactionNo = scanner.nextInt();
                if (transactionNo < 1 && transactionNo > 6) {
                    System.out.println("Lütfen geçerli Bir İşlem Numarası Giriniz");
                } else if (!(transactionNo < 1 && transactionNo > 6)) {
                    result = 1;
                }
            }
            switch (transactionNo) {
                case 0:
                    System.out.println("Geçerli Değer Yok");
                    break;
                case 1:
                    CleanConsole();
                    ListStudents(StudentsNumber, StudentsName, StudentsVize, StudentsFinal, studentAmount);
                    break;
                case 2:
                    CleanConsole();
                    ListMarks(StudentsNumber, StudentsName, StudentsVize, StudentsFinal, studentAmount);
                    break;
                case 3:
                    CleanConsole();
                    ListUnderSixty(StudentsNumber, StudentsName, StudentsVize, StudentsFinal, studentAmount);
                    break;
                case 4:
                    CleanConsole();
                    ListAboveAverageOfClass(StudentsNumber, StudentsName, StudentsVize, StudentsFinal, studentAmount);
                    break;
                case 5:
                    CleanConsole();
                    FindMinVize(StudentsNumber, StudentsName, StudentsVize, StudentsFinal, studentAmount);
                    break;
                case 6:
                    CleanConsole();
                    FindMaxFinal(StudentsNumber, StudentsName, StudentsVize, StudentsFinal, studentAmount);
                    break;
            }
        }
    }

    public static void DesignMenu(){
        System.out.println("------------------------------------------------------------------------");
    }
    public static void  CleanConsole(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void ListMenu(){
        System.out.printf("\n \n");
        DesignMenu();
        System.out.println("Öğrenci Listeleme (1)");
        System.out.println("Öğrencilerin Dönem Sonu Notu Listeleme (2)");
        System.out.println("60 Altında Final Notu Bulunan Öğrencileri Listeleme (3)");
        System.out.println("Dönem Sonu Notu Sınıf Ortalaması Üstünde Olan Öğrencileri Listeleme (4)");
        System.out.println("Minimum Vize Notu Bul (5)");
        System.out.println("Maksimum Final Notu Bul (6)");
        System.out.println("Programı Sonlandır (-1)");
        DesignMenu();
    }

    public static void ListStudents(int[] studentNumber,String[] studentName,double[] studentVize,double[] studentFinal,int studentAmount){
        System.out.println("Öğrenci Listeleme");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s \n","Öğrenci No","Öğrenci İsmi","Öğrenci Vize","Öğrenci Final");
        for(int i=0;i<studentAmount;i++){
            System.out.printf("%-30d %-30s %-30f %-30f",studentNumber[i],studentName[i],studentVize[i],studentFinal[i]);
            System.out.println();
        }
    }

    public static void ListMarks(int[] studentNumber,String[] studentName,double[] studentVize,double[] studentFinal,int studentAmount){
        System.out.println("Öğrencilerin Dönem Sonu Notu Listeleme");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s %-30s \n","Öğrenci No","Öğrenci İsmi","Öğrenci Vize","Öğrenci Final","Öğrenci Dönem Sonu Notu");
        for(int i=0;i<studentAmount;i++){
            double mark=(studentVize[i]*40+studentFinal[i]*60)/100;
            System.out.printf("%-30d %-30s %-30f %-30f %-30f",studentNumber[i],studentName[i],studentVize[i],studentFinal[i],mark);
            System.out.println();
        }
    }

    public static void ListUnderSixty(int[] studentNumber,String[] studentName,double[] studentVize,double[] studentFinal,int studentAmount){
        System.out.println("60 Altında Final Notu Bulunan Öğrencileri Listeleme");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s \n","Öğrenci No","Öğrenci İsmi","Öğrenci Vize","Öğrenci Final");
        for(int i=0;i<studentAmount;i++){
            if(studentFinal[i]<60){
                System.out.printf("%-30d %-30s %-30f %-30f",studentNumber[i],studentName[i],studentVize[i],studentFinal[i]);
                System.out.println();
            }
        }
    }

    public static double CalculateAverageOfClass(double[] studentVize,double[] studentFinal,int studentAmount){
        double sum=0;
        for(int i=0;i<studentAmount;i++) {
            double mark = (studentVize[i] * 40 + studentFinal[i] * 60) / 100;
            sum+=mark;
        }
        return (sum/studentAmount);
    }

    public  static void ListAboveAverageOfClass(int[] studentNumber,String[] studentName,double[] studentVize,double[] studentFinal,int studentAmount){
        System.out.println("Dönem Sonu Notu Sınıf Ortalaması Üstünde Olan Öğrencileri Listeleme");
        System.out.println();
        double AverageOfClass= CalculateAverageOfClass(studentVize,studentFinal,studentAmount);
        System.out.println("Sınıf Ortalaması:"+AverageOfClass);
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s %-30s \n","Öğrenci No","Öğrenci İsmi","Öğrenci Vize","Öğrenci Final","Öğrenci Dönem Sonu Notu");
        for(int i=0;i<studentAmount;i++){
            double mark=(studentVize[i] * 40 + studentFinal[i] * 60) / 100;
            if(mark>AverageOfClass){
                System.out.printf("%-30d %-30s %-30f %-30f %-30f",studentNumber[i],studentName[i],studentVize[i],studentFinal[i],mark);
                System.out.println();
            }
        }
    }

    public static void FindMinVize(int[] studentNumber,String[] studentName,double[] studentVize,double[] studentFinal,int studentAmount){
        System.out.println("Vize Notu Minumum Olan Öğrenci");
        System.out.println();
        double minVize=100;
        int indexOfMin=0;
        for(int i=0;i<studentAmount;i++){
            if(studentVize[i]<minVize){
                minVize=studentVize[i];
                indexOfMin=i;
            }
        }
        System.out.printf("%-30s %-30s %-30s %-30s \n","Öğrenci No","Öğrenci İsmi","Öğrenci Vize","Öğrenci Final");
        System.out.printf("%-30d %-30s %-30f %-30f ",studentNumber[indexOfMin],studentName[indexOfMin],studentVize[indexOfMin],studentFinal[indexOfMin]);
    }

    public static void FindMaxFinal(int[] studentNumber,String[] studentName,double[] studentVize,double[] studentFinal,int studentAmount){
        System.out.println("Final Notu Maksimum Olan Öğrenci");
        System.out.println();
        double maxFinal=0;
        int indexOfMax=0;
        for(int i=0;i<studentAmount;i++){
            if(studentFinal[i]>maxFinal) {
                maxFinal = studentFinal[i];
                indexOfMax = i;
            }
        }
        System.out.printf("%-30s %-30s %-30s %-30s \n","Öğrenci No","Öğrenci İsmi","Öğrenci Vize","Öğrenci Final");
        System.out.printf("%-30d %-30s %-30f %-30f ",studentNumber[indexOfMax],studentName[indexOfMax],studentVize[indexOfMax],studentFinal[indexOfMax]);
    }
}
