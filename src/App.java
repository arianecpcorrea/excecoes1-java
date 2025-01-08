



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;


public class App {
    public static void main(String[] args) { //throws ParseException { no do professor deu exceção
        // no parse, ou vc trata a exceção ou vc propaga a exceção no método onde vc está
        //quando declaro essa throws eu digo que o meu método main pode lançar uma exceção, então
        //quando eu tenho um método que pode lançar uma exceção, eu trato o método ou eu propago a 
        //exceção.

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

    

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
       

        System.out.print("Room Number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in Date (dd/MM/yyyy): ");
        //recebe String e transform for data;
        sc.nextLine();                
        LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);
        //ou 
        //LocalDateTime checkIn = LocalDateTime.parse(chei, fmt);
        System.out.print("Check-out Date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);
                
        //Preciso testar se o checkIn não é depois do checkOut
        if(checkIn.isAfter(checkOut)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");  
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), fmt);
            
            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");                
            }
            else if (checkIn.isAfter(checkOut)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");  
            }
            else {
                reservation.updateDate(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
                
        }
        //ESSA LÓGICA ACIMA É MUITO RUIM, PORQUE ELA ESTÁ SENDO FEITA NO PROGRAMA PRINCICPAL
        // ELA DEVERIA SER FEITAS NA PRÓPRIA CLASSE RESERVATION

        sc.close();  
            
    }

     
}
