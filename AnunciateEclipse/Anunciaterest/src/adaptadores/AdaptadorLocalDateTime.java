package adaptadores;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

												//tipo que queres y lo qe le pasaremos
public class AdaptadorLocalDateTime extends XmlAdapter<String, LocalDateTime>{
	DateTimeFormatter dtf1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	public AdaptadorLocalDateTime() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String marshal(LocalDateTime ld) throws Exception {
		// TODO Auto-generated method stub       //formato de fecha mas usado el tipico /d/m/y
		//return "Mi fecha es "+ld.format(DateTimeFormatter.ISO_DATE);
		//ld.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return ld.format(dtf1);
		
	}

	@Override
	public LocalDateTime unmarshal(String valor) throws Exception {
		// TODO Auto-generated method stub
		LocalDateTime ld = LocalDateTime.parse(valor,dtf1); 
		 return ld;
		
	}
}
