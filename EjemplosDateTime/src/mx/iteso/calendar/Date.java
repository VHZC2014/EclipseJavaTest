package mx.iteso.calendar;
public class Date {
	//Datos y casos default
	private int day=1, month=1, year=2017;
	private String monthName="Enero";
	protected int format=0;
	//Constructores
	public Date(){
		// TO DO : Asignar la fecha del Sistema
	}
	public Date(int dd, int mm, int yy) {
		this.setDay(dd);
		this.setYear(yy);
		this.setMonth(mm);
	}
	public Date(int dd, int mm, int yy, int format) {
		this.setDay(dd);
		this.setMonth(mm);
		this.setYear(yy);
		this.setFormat(format);	
	}
	//Setters y getters (validando datos ingresados o aplicando default)
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if((getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11) && (day >=1 && day <= 30))this.day = day;
		if(getMonth() == 2 && (day >= 1 && day <= 28));
		if((getMonth() == 1 || getMonth() == 3 || getMonth() == 5 || getMonth() == 7 || getMonth() == 8 || getMonth() == 10 || getMonth() == 12)
				&& (day >= 1 && day <= 31))this.day = day;
	}
	public int getMonth		() {
		return month;
	}
	public void setMonth(int month) {
		String meses[] = {"","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
			if(month >= 1 && month <= 12) this.month = month;monthName = meses[month];
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year >= 1900 && year <= 3000) this.year = year;
	}
	public int getFormat() {
		return format;
	}
	public void setFormat(int format) {
		if(format >= 0 && format <= 2) this.format = format;
		this.format = format;
	}
	public String getMonthName() {
		return monthName;
	}
	//metodo toString
	public String toString() {
		String dateConFormato="";
		if(this.format == 0) {
			if(this.day < 10)dateConFormato = "0"+this.day+"/"+this.month+"/"+this.year%100;
			if(this.month < 10)dateConFormato = this.day+"/"+"0"+this.month+this.year%100;
			if(this.day<10 && this.month<10)dateConFormato = "0"+this.day+"/0"+this.month+"/"+this.year%100;
			else dateConFormato = this.day+"/"+this.month+"/"+this.year%100;
			return dateConFormato;
		}
		if(this.format == 1) {
			dateConFormato = this.day+"-"+this.monthName.substring(0,3)+"-"+this.year;
			return dateConFormato;
		}
		if(this.format == 2) {
			dateConFormato = this.day+" de "+this.monthName.toLowerCase()+" de "+this.year;
			return dateConFormato;
		}
		return dateConFormato;
		
	}
	//metodo equals
	public boolean equals(Object obj){
		if(!(obj instanceof Date)) {
			return false;
		}
		Date x = (Date) obj;
		boolean flag1=false,flag2=false,flag3=false;
		if(x.getDay() == this.day) flag1 = true;
		if(x.getMonth() == this.month) flag2 = true;
		if(x.getYear() == this.year) flag3 = true;
		if(flag1 && flag2 && flag3) {
			return true;
		}else {
			return false;
		}
	}
	//metodo clone
	public Date clone(){
		Date x = new Date(this.day,this.month,this.year);
		return x;		
	}
	//metodo next
	public void next() {
		if((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && this.day>30) setMonth(this.month+1);setDay(1);
		if(this.month == 2 && this.day > 28)setMonth(3);setDay(1);
		if((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) && this.day>31) 
			setMonth(this.month+1);setDay(1);
		if(this.month == 12 && this.day > 31) setDay(1);setMonth(1);setYear(this.year+1);
		setDay(1);
	}
	public static boolean isLeap(int year) {
		if ((year % 4) == 0) {
			if((year % 100) == 0)
				if ((year % 400) == 0)
					return true;
				else
					return false;
			return true;
		}else 
			return false;
		}
}