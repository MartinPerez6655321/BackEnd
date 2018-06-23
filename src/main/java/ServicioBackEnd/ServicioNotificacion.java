package ServicioBackEnd;

import DAO.NotificacionDAOJPA;
import DomainModels.Notificacion;
import DomainModels.Usuario;


public class ServicioNotificacion {


	NotificacionDAOJPA DAONotificacion;
	
	public ServicioNotificacion() {
		DAONotificacion = new NotificacionDAOJPA();
	}
	
	public void crearNotificacion(Usuario Receptor, Usuario Sugerido, String instrumento, boolean receptorMusico) {
		String mensaje;
		if(receptorMusico) {
			mensaje = "Sr. "+Receptor.getName()+": Una banda busca un profesional que sepa tocar "+instrumento+". En caso de interes contactarse con: "+Sugerido.getEmail();
		}else {
			mensaje = "Sr. "+Receptor.getName()+": Un musico quiere incorporar "+instrumento+" a una banda. En caso de interes contactarse con: "+Sugerido.getEmail();
		}
		Notificacion newNotificacion = new Notificacion(Receptor.getEmail(), mensaje);
		DAONotificacion.crear(newNotificacion);
	}

}
