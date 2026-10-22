package mx.iteso.calendar;
import java.util.Calendar;

public class DateTime extends Date{
	//Definimos los atributos privados de la clase
	private int seconds = 0;
	private int minutes = 0;
	private int hours = 0;
	
	//Constructores
	public DateTime(int hh, int mi, int ss, int dd, int mm, int yy) {
		super(dd,mm,yy);
		setHours(hh);
		setMinutes(mi);
		setSeconds(ss);
		
	}
	public DateTime(int hh, int mi, int ss) {
		this(hh,mi,ss,
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				Calendar.getInstance().get(Calendar.MONTH),
				Calendar.getInstance().get(Calendar.YEAR));
	}
	public DateTime(Date d) {
		this(Calendar.getInstance().get(Calendar.HOUR),
				Calendar.getInstance().get(Calendar.MINUTE),
				Calendar.getInstance().get(Calendar.SECOND),
				d.getDay(),d.getMonth(),d.getYear());
	}
	public DateTime() {
		this(Calendar.getInstance().get(Calendar.HOUR),
				Calendar.getInstance().get(Calendar.MINUTE),
				Calendar.getInstance().get(Calendar.SECOND),
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				Calendar.getInstance().get(Calendar.MONTH),
				Calendar.getInstance().get(Calendar.YEAR));
	}
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if((seconds >= 0) && (seconds <= 59))this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if((minutes > 0) && (minutes <= 59))this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if ((hours >0) && (seconds <= 23)) 	this.hours = hours;
	}
	public String toString() {
		String mensaje = super.toString();
		String hora = "";
		String amPm = "AM";
		if(this.hours == 0) {
			hora = "12";
		}else if(this.hours == 12){
				hora = "12";
				amPm = "PM";
		}else if(this.hours > 12) {
			hora = "" + (this.hours-12);
			amPm = "PM";
		}else {
			hora = "" + this.hours;
		} 
		switch (this.format) {
		case 0:
			mensaje = "["+ 	this.hours + ":"+this.minutes+":"+this.seconds+"] "+ mensaje;
			break;
		case 1:
			mensaje = "["+ hora +":"+this.minutes+":"+this.seconds+" " + amPm+ "] "+ mensaje;
			break;
		case 2:
			mensaje = "["+ 	this.hours + ":"+this.minutes+":"+this.seconds+"] "+ mensaje;
			break;
		}
		
		return mensaje;
	}		
	
	public Date toDate() {
		return new Date(this.getDay(), this.getMonth(), this.getYear());
	}
	
	public boolean equals(Object obj) {
			if (!(obj instanceof DateTime)) {
				return false;
			}
			DateTime dt = (DateTime) obj;
			Boolean flag = super.equals(this.toDate());	
			return (flag && (this.hours == dt.getHours() ) && (this.minutes == dt.getMinutes() )	
					&& (this.seconds == dt.getSeconds() ) );
	}
	public DateTime clone() {
		return new DateTime(this.getHours(),this.getMinutes(),this.getSeconds(),
				this.getDay(),this.getMonth(),this.getYear());
	}
	public void next() {
		
		if(this.seconds == 59) {
			this.seconds = 0;
			if (this.minutes == 59) {
				this.minutes = 0;
				if (this.hours == 23) {
					this.hours = 0;
					super.next();
				}else {
					this.hours ++;
				}
			} else {
				this.minutes ++;
			}
		} else {
			this.seconds ++;
		}
	}

}
