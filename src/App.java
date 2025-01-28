



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
        // Essa validação que é para instanciar o objeto eu preciso deixar no meu programa 
        // principal, porque ela teria que ir na Reservation dentro do Construtor, porém não tem
        //como o meu Construtor retornar uma String e esse objeto retorna uma String
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
            
            String error = reservation.updateDates(checkIn, checkOut); // preciso guardar o 
            //updateDates em uma variável String porque é ela que vai me avisar se deu erro ou não
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {
            System.out.println("Reservation: " + reservation);
            }                            
        }
        //ESSA LÓGICA ACIMA É RUIM, JÁ TEM ALGUNS MÉTODOS DENTRO DA CLASSE RESERVATION, PORÉM 
        // PORQUE ELA ESTÁ SENDO FEITA NO PROGRAMA PRINCICPAL
        // ELA DEVERIA SER FEITAS NA PRÓPRIA CLASSE RESERVATION

        sc.close();              
    }     
}
