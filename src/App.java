

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;


public class App {
    //PERSONALIZE AS EXCEÇÕES
    
    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);   

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        try {
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
            // Essa validação que é para instanciar o objeto eu preciso deixar no meu programa 
            // principal, porque ela teria que ir na Reservation dentro do Construtor, porém não tem
            //como o meu Construtor retornar uma String e esse objeto retorna uma String
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), fmt);
            
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date format");            
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());            
        }                                 
        
        //ESSA LÓGICA ACIMA É BOA, POIS O MEU PROGRAMA NÃO PROPAGA EXCEÇÕES, ELE AS TRATA.
        // O MEU TRECHO DE CÓDIGO ACIMA NÃO TEM UMA VALIDAÇÃO, ELE É LINEAR.
        
        sc.close();              
    }     
}
