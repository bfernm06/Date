import java.util.*;


public class Date {
		private int day;
		private int month;
		private int year;
		
		
		//constructor
		public Date (int day, int month) throws DateException{
			StringBuffer mensaje = new StringBuffer ();
			if(day<32 && day >0 && month>0 && month<13){
				this.day=day;
				this.month=month;
			}
			else{
				mensaje.append ("Fecha incorrecta");
			}
			if(mensaje.length()!=0){
				throw new DateException(mensaje.toString());
			}
		}
		
		//constructor
		public Date (int day, int month, int year) throws DateException{
			StringBuffer mensaje = new StringBuffer();
			if( correctDate(day,month,year)){
				this.day=day;
				this.month=month;
				this.year=year;
			}
			else{
				mensaje.append("Fecha incorrecta");
				System.out.println(mensaje);
				System.exit(0);
			}
			if(mensaje.length()!=0){
				throw new DateException(mensaje.toString());
			}
		}
		





public boolean isSameDay(int unDia){
	if(day==unDia){
		return true;
	}
	return false;
}


public boolean isSameMonth(int unMes){
	if(month==unMes){
		return true;
	}
	return false;
}



public boolean isSameYear(int unYear){
	if(year==unYear){
		return true;
	}
	return false;
}



public boolean isSame(Date unaFecha){
	if(day==unaFecha.day && month==unaFecha.month && year==unaFecha.year){
		return true;
	}
	return false;	
}


public boolean correctDate(int day, int month, int year){
	if(day<=0 || day >31 || year<0 || month <=0 || month>12){
		return false;
	}
	if((day<=31) && (month==1 || month==3 || month==5 || month ==7 || month ==8 || month==10 || month==12)){
		return true;
	}
	else if((day<=30) && (month==4 || month==6 || month==9 || month==11)){
		return true;
	}
	else if(day<29 && month==2){
		return true;
	}
	else{
		return false;
		}
	}

public String pasarMesString (int unMes){
	String mesString;
	switch (unMes){
		case 1: mesString= "Enero";break;
		case 2: mesString= "Febrero";break;
		case 3: mesString= "Marzo";break;
		case 4: mesString= "Abril";break;
		case 5: mesString= "Mayo";break;
		case 6: mesString= "Junio";break;
		case 7: mesString= "Julio";break;
		case 8: mesString= "Agosto";break;
		case 9: mesString= "Septiembre";break;
		case 10: mesString= "Octubre";break;
		case 11: mesString= "Noviembre";break;
		case 12: mesString= "Diciembre";break;
		
		default: mesString="";break;
	}
	return mesString;
}



public void printDate(Date fecha){
	String mesString=pasarMesString(fecha.month);
	
	System.out.println(fecha.day+" de "+ mesString+" de "+fecha.year);
}



public int tryDate() throws DateException{
	
	int intentos=0;
	
	//semilla para generar aleatorios
	Random randomNumber=new Random();
	randomNumber.setSeed(System.currentTimeMillis());
	
	Date fechaAleatoria = null;
	do{
		int diaAleatorio=randomNumber.nextInt(31)+1;
		int mesAleatorio=randomNumber.nextInt(12)+1;
		if(correctDate(diaAleatorio,mesAleatorio,year)){
			fechaAleatoria=new Date(diaAleatorio, mesAleatorio, year);
			intentos++;
		}
	}while(!isSame(fechaAleatoria));
	
	System.out.println("Numero de intentos: "+intentos);
	return intentos;
}


public int tryDate_2() throws DateException{
	
	int intentos=0;
	
	//semilla para generar aleatorios
	Random randomNumber=new Random();
	randomNumber.setSeed(System.currentTimeMillis());
	
	Date fechaAleatoria = new Date(1,1,5000);
	while(!isSame(fechaAleatoria)){
		int diaAleatorio=randomNumber.nextInt(31)+1;
		int mesAleatorio=randomNumber.nextInt(12)+1;
		if(correctDate(diaAleatorio,mesAleatorio,year)){
			fechaAleatoria=new Date(diaAleatorio, mesAleatorio, year);
			intentos++;
		}
	}
	System.out.println("Numero de intentos segunda version: "+intentos);
	return intentos;
	}



public void weekDay(Date fecha, int diaSemana){
	String[] dias={"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
	int diasTranscurridos=diasTranscurridosYear(fecha);
	int resto=diasTranscurridos%7;
	
	int diaBuscado=(diaSemana+resto)%7;
	
	System.out.println("El dia de las fecha introducida es: "+diaBuscado);
}


public int diasTranscurridosYear(Date fecha){
	int diasTotales=0;
	switch(fecha.month){
		case 1:diasTotales=0;break;
		case 2:diasTotales=31;break;
		case 3:diasTotales=59;break;
		case 4:diasTotales=90;break;
		case 5:diasTotales=120;break;
		case 6:diasTotales=151;break;
		case 7:diasTotales=181;break;
		case 8:diasTotales=212;break;
		case 9:diasTotales=243;break;
		case 10:diasTotales=273;break;
		case 11:diasTotales=304;break;
		case 12:diasTotales=334;break;
	}
	diasTotales+=fecha.day;
	System.out.println("Han pasado "+diasTotales+ " desde principio de año");
	return diasTotales;
}


public int mesesRestantes(Date fecha){
	int i;
	int transcurridos=1;
	int restantes=0;

		transcurridos+=fecha.month-1;
		restantes=12-transcurridos;
		
		System.out.println("Quedan "+restantes+" meses");
		return restantes;
}



public void diasFinMes(Date fecha){
	
	if(month==1 || month==3 || month==5 || month ==7 || month ==8 || month==10 || month==12)
		System.out.println("Los dias restantes son: "+ (31-fecha.day));
	else if(month==4 || month==6 || month==9 || month==11)
		System.out.println("Los dias restantes son: "+(30-fecha.day));
	else
		System.out.println("Los dias restantes son: "+(28-fecha.day));
	
}


public void season(int unMes){
	String mesString;
	if(unMes==11 || unMes==12 || unMes==1 || unMes==2)
		System.out.println("Invierno");
	else if(unMes==3||unMes==4|| unMes==5)
		System.out.println("Primavera");
	else if(unMes==6||unMes==7||unMes==8)
		System.out.println("Verano");
	else
		System.out.println("Otoño");
}


public void mismosDias(int unMes){
	if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
		System.out.println("Tienen los mismos dias los siguientes meses: Enero,Marzo,Mayo,Julio,Agosto,Octumbre y Diciembre");
	}
	else if(month==4||month==6||month==9||month==11){
		System.out.println("Tienen los mismos dias los siguientes meses: Abril,Junio,Septiembre y Noviembre");
	}
	else{
		System.out.println("Febrero es el unico mes con 29 dias");
	}
}





}