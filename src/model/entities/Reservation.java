

package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Reservation {

    //Não posso utilizar LocalDate porque vou usar um método que calcule os milisegundos e o Instant
    //tem o método .toEpochMilli();

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    
    
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Reservation (Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    

    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }
    
    //não vou colocar set porque eu não quero deixar que o meu programa mude as datas arbitrariamente.
    
    //para fazer o método duração, vai ser usado uma lógica para retornar as diferenças entre datas
    // e essa diferença vai me retornar um valor do tipo long
    
    
    public int duration() {
        // retorna o total de noites
        return checkOut.compareTo(checkIn);

    }

    // o método abaixo funcionaria se tivesse check-in com horas e minutos, e fosse LocalDateTime
    // public long durationTime() {
    //     // retorna o tempo
    //     return ChronoUnit.MINUTES.between(entrada, saida);

    // }
    
      
    
    public void updateDate(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        // ler este checkOut objeto recebe o checkOut argumento
    }
    // vou implementar um toString para ele imprimir a minha reserva
    @Override
    public String toString() {
        return "Room " 
            + roomNumber
            + ", check-in: "
            + fmt.format(checkIn)
            + ", check-out: "
            + fmt.format(checkOut)
            + ", "
            + duration()
            + " nights.";      
            

    }











}
