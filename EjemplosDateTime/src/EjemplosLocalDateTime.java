import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class EjemplosLocalDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate d1 = LocalDate.now();
		
		LocalDate d2 = LocalDate.of(2015, 9, 23);
		
		LocalDate d3 = (d1.isBefore(d2)) ? d1 : d2;
		
		System.out.println("La fecha más antigua es: " + d3);
		
		LocalDate d4 = d1.plusWeeks(2).minusYears(4);
		
		System.out.println(d4);
		
		LocalTime t1 = LocalTime.now();
		
		System.out.println(t1);
		
		LocalDateTime dt1 = LocalDateTime.of(d2, t1);
		
		System.out.println(dt1);
				
	}

}
