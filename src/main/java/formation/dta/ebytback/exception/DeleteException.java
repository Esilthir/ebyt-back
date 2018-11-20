package formation.dta.ebytback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.ACCEPTED )
public class DeleteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4198398001781696349L;

	 public DeleteException() {
	        super("Désolé mains vous ne pouvez pas supprimer ce concert, des places ont déjà été achetées. En revanche, vous avez la possibilité de le désactiver.");

	    }
}
