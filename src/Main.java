import java.util.*;

public class Main {

	public static void main(String[] args)  throws DateException{
		// TODO Auto-generated method stub
		Scanner lee=new Scanner (System.in);
		System.out.println("Dime un dia");
		int dia=lee.nextInt();
		System.out.println("Dime un mes");
		int mes=lee.nextInt();
		System.out.println("Dime un año");
		int year=lee.nextInt();
		Date fecha=new Date(dia,mes,year);
		
		fecha.printDate(fecha);
		fecha.tryDate();
		fecha.tryDate_2();
		fecha.weekDay(fecha,5);
		fecha.season(mes);
		fecha.mismosDias(mes);
		fecha.mesesRestantes(fecha);
		fecha.diasFinMes(fecha);
		
	}
	
	//NO HAY QUE HACER LOS QUE NO SON RELACIONADOS CON DATE.
	/*public static void tablaMult(int num){
		for(int i=1; i<=10;i++){
			System.out.println(i*num);
		}
	}*/

}
