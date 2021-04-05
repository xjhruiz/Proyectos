package adaptadores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

												//tipo que queres y lo qe le pasaremos
public class AdaptadorLocalDate extends XmlAdapter<String, LocalDate>{

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy",Locale.ENGLISH);
	public AdaptadorLocalDate() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String marshal(LocalDate ld) throws Exception {
		// TODO Auto-generated method stub       //formato de fecha mas usado el tipico /d/m/y
		//return "Mi fecha es "+ld.format(DateTimeFormatter.ISO_DATE);
		return ld.format(dtf);
		
	}

	@Override
	public LocalDate unmarshal(String valor) throws Exception {
		// TODO Auto-generated method stub
		 LocalDate ld =LocalDate.parse(valor,dtf);
		 return ld;
		
	}
}
