package ejercicio.service;

import java.time.Period; 
import java.time.LocalDate;

public class CalculadoraEdad {

	    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
	        if ((birthDate != null) && (currentDate != null)) {
	            return Period.between(birthDate, currentDate).getYears();
	        } else {
	            return 0;
	        }
	    }
	}

