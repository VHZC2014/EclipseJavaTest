package tests;
import mx.iteso.calendar.*;

public class TestDateTime {

	public static void main(String[] args) {
		
		// 1. Sea time1 la fecha/hora actual
		DateTime time1 = new DateTime();
		
		//2. Sea time 2 la hora 0:26:03 y la fecha actual
		DateTime time2 = new DateTime(0, 26, 3);
		
		// 3. Sea time3 la hora 23:59:59 con fecha 31 de diciembre 2017
		DateTime time3 = new DateTime(23, 59, 59, 31,12, 2017);
		
		// 4. Sea time4 el segundo siguiente de time3
		DateTime time4 = time3.clone();
		time4.next(); // OJO: lo hacemos así para no modificar time3.
		
		// 5. Sea date5 la fecha 31-12-2017
		Date date5 = new Date(31,12,2017);
		
		// 6. Sea time6 la fecha siguiente de time3 pero la misma hora
		DateTime time6 = new DateTime(23, 59, 59, 1, 1, 2018);
		
		// 7. imprimir el resultado de comparar time2 con un clon de time2
		DateTime time7 = time2.clone();
		System.out.println("time2.equals(time7) --> "+ time2.equals(time7));
		
		// 8. Imprimir el resultado de comparar time3 y date5 en ambos sentidos
		System.out.println("time3.equals(date5) --> " + time3.equals(date5));
		System.out.println("date5.equals(time3) --> " + date5.equals(time3));
		
		// 9. Imprimir el resultado de comparar la fecha de time3 con date5
		Date date6 = time3.toDate();
		System.out.println("date5.equals(date6) --> " + date5.equals(date6));
		
		//10. Añadir todos los objetos en un arreglo e imprimirlos en los tres formatos
		
		Date[] dates = { time1, time2, time3, time4, date5, time6, time7, date6};
		
		for (Date date: dates) {
			for (int i = 0 ; i <= 2 ; i++) {
				date.setFormat(i);
				System.out.println(date);
			}
		}
		

	}

}
