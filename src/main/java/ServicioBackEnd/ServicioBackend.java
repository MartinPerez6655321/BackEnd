package ServicioBackEnd;

import java.util.List;

import DomainModels.*;
import DAO.*;

public class ServicioBackend {

	Postulacion_MusicoDAOJPA DAO_Musico;
	Postulacion_BandaDAOJPA DAO_Banda;
	HistoryMergeDAOJPA DAOMerge;
	ServicioNotificacion ServiceNoti;
	
	public ServicioBackend() {
		DAO_Musico = new Postulacion_MusicoDAOJPA();
		DAO_Banda = new Postulacion_BandaDAOJPA();
		DAOMerge = new HistoryMergeDAOJPA();
		ServiceNoti = new ServicioNotificacion();		
	}
	
	public void generarNotificaciones() {
		
		// Trae todas las potulaciones, tanto de musico como de banda
		//-------------------------------------------------------------------------------------------
		List<Postulacion_Musico> PostsMusico = DAO_Musico.todos();
		List<Postulacion_Banda> PostsBanda = DAO_Banda.todos();
		//-------------------------------------------------------------------------------------------
		
		//Recorre las postulaciones y evalua si hay merge, que no exista previamente. Luego nitifica
		//-------------------------------------------------------------------------------------------		
		for ( Postulacion_Musico postM : PostsMusico ) {
			for ( Postulacion_Banda postB : PostsBanda ) {
				if(huboMerge(postM.getInstrumento().getName(),postB.getInstrumento().getName())&&noEstaEnHistoryMerge(postM.getId(),postB.getId())) {
					//guarda en el historial de merge
					HistoryMerge merge = new HistoryMerge(postM.getId(), postB.getId());
					DAOMerge.crear(merge);
					//realiza la noficacion a quien corresponda (tanto a musico como a banda).
					ServiceNoti.crearNotificacion(postM.getUsuario(), postB.getUsuario(), postB.getInstrumento().getName(), true);
					ServiceNoti.crearNotificacion(postB.getUsuario(), postM.getUsuario(), postM.getInstrumento().getName(), false);
				}
			}
		}

	}

	//-------------------------------------------------------------------------------------------
			
	private boolean huboMerge(String instrumentoMusico,String instrumentoBanda) {
		if(instrumentoMusico.equals(instrumentoBanda)) {
			return true;
		}
		return false;
	}

	//-------------------------------------------------------------------------------------------
			
	private boolean noEstaEnHistoryMerge(Long idPostMusico, Long idPostBanda) {
		List<HistoryMerge> Historys = DAOMerge.todos();
		for (HistoryMerge story : Historys){
			if(story.getIdPostMusico()==idPostMusico&&story.getIdPostBanda()==idPostBanda) {
				return false;
			}
		}
		return true;
	}

	//-------------------------------------------------------------------------------------------
	
}














