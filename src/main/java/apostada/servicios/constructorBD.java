package apostada.servicios;

import java.util.Date;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.entidades.Partido;

@Service
public class constructorBD implements InitializingBean {


	   

	    @Autowired
	    UsuarioService usuarioService;
	    @Autowired
	    PartidoService partidoService;
	    @Autowired
	    LigaService ligaService;
	    @Autowired
	    EquipoService equipoService;


	    @Override
	    @Transactional()
	    public void afterPropertiesSet() throws Exception {
	      //  LOG.info("Bootstrapping data...");

	      //Liga BBVA
	   	 Liga ligaBBVA = new Liga("liga BBVA");
	   	 ligaService.save(ligaBBVA);
	   	 //Equipo ligaBBVA
	   	 Equipo malaga = new Equipo("Malaga",ligaBBVA);
	   	 Equipo real= new Equipo("Real Sociedad",ligaBBVA);
	   	 Equipo depor= new Equipo("Deportivo",ligaBBVA);
	   	 Equipo villa= new Equipo("Villareal",ligaBBVA);
	   	 Equipo atleti= new Equipo("Atletico",ligaBBVA);
	   	 Equipo betis= new Equipo("Betis",ligaBBVA);
	   	 Equipo barsa= new Equipo("Barcelona",ligaBBVA);
	   	 Equipo palmas= new Equipo("Las Palmas",ligaBBVA);
	   	 Equipo lega= new Equipo("Leganes",ligaBBVA);
	   	 Equipo athletic= new Equipo("Athletic",ligaBBVA);
	   	 Equipo valencia= new Equipo("Valencia",ligaBBVA);
	   	 Equipo espa= new Equipo("Espanyol",ligaBBVA);
	   	 Equipo celta= new Equipo("Celta",ligaBBVA);
	   	 Equipo alaves = new Equipo("Alaves",ligaBBVA);
	   	 Equipo grana= new Equipo("Granada",ligaBBVA);
	   	 Equipo osa= new Equipo("Osasuna",ligaBBVA);
	   	 Equipo spo= new Equipo("Sporting",ligaBBVA);
	   	 Equipo eibar= new Equipo("Eibar",ligaBBVA);
	   	 Equipo sev= new Equipo("Sevilla",ligaBBVA);
	   	 Equipo madrid= new Equipo("Real Madrid",ligaBBVA);
	   	 
	   	 equipoService.save(malaga);
	   	 equipoService.save(real);
	   	 equipoService.save(depor);
	   	 equipoService.save(villa);
	   	 equipoService.save(atleti);
	   	 equipoService.save(betis);
	   	 equipoService.save(barsa);
	   	 equipoService.save(palmas);
	   	 equipoService.save(lega);
	   	 equipoService.save(athletic);
	   	 equipoService.save(valencia);
	   	 equipoService.save(espa);
	   	 equipoService.save(celta);
	   	 equipoService.save(alaves);
	   	 equipoService.save(grana);
	   	 equipoService.save(osa);
	   	 equipoService.save(spo);
	   	 equipoService.save(eibar);
	   	 equipoService.save(sev);
	   	 equipoService.save(madrid);
	   	 
	   	 
	   	 //jornada 18 ligaBBVA
	   	 Date fecha181 = new Date(117,0,14,20,30,00);
	   	 Date fecha182 = new Date(117,0,15,20,30,00);
	   	 partidoService.save(new Partido(malaga,real,1.2,1.8,2,fecha181,0,2));
	   	 partidoService.save(new Partido(depor,villa,2,1.9,1.5,fecha181,0,0));
	   	 partidoService.save(new Partido(atleti,betis,1.1,2,3,fecha181,1,0));
	   	 partidoService.save(new Partido(barsa,palmas,1.1,3,3.4,fecha181,5,0));
	   	 partidoService.save(new Partido(lega,athletic,2,3,1.5,fecha181,0,0));
	   	 partidoService.save(new Partido(valencia,espa,3,4,1.01,fecha182,2,1));
	   	 partidoService.save(new Partido(celta,alaves,2,1.8,1.7,fecha182,1,0));
	   	 partidoService.save(new Partido(grana,osa,3,2,1.6,fecha182,1,1));
	   	 partidoService.save(new Partido(spo,eibar,2,1.5,2.5,fecha182,2,3));
	   	 partidoService.save(new Partido(sev,madrid,2.4,2.3,1.1,fecha182,2,1));
	   	 
	   	 //jornada 19 ligaBBVA
	   	 Date fecha191= new Date(117,0,21,17,30,00);
	   	 Date fecha192= new Date(117,0,22,16,00,00);
	   	 partidoService.save(new Partido(osa,sev,1.5,1.6,3,fecha191,3,4));
	   	 partidoService.save(new Partido(athletic,atleti,2.6,2,3.4,fecha191,2,2));
	   	 partidoService.save(new Partido(real,celta,2.7,2,3,fecha191,1,0));
	   	 partidoService.save(new Partido(betis,spo,1.9,1.6,1.5,fecha191,0,0));
	   	 partidoService.save(new Partido(eibar,barsa,1.5,2.6,1.3,fecha191,0,4));
	   	 partidoService.save(new Partido(villa,valencia,1.2,2.1,2.6,fecha192,0,2));
	   	 partidoService.save(new Partido(alaves,lega,1.3,2,3.6,fecha192,2,2));
	   	 partidoService.save(new Partido(madrid,malaga,1.1,5,6,fecha192,2,1));
	   	 partidoService.save(new Partido(espa,grana,1.6,6,2,fecha192,3,1));
	   	 partidoService.save(new Partido(palmas,depor,1.5,2,2.1,fecha192,1,1));
	   	 
	   	 //jornada 20 ligaBBVA
	   	 
	   	 Date fecha201= new Date(117,0,28,22,30,00);
	   	 Date fecha202= new Date(117,0,29,12,30,00);
	   	 partidoService.save(new Partido(osa,malaga,1.5,2,3,fecha201,1,1));
	   	 partidoService.save(new Partido(villa,grana,1.3,1.5,2,fecha201,2,0));
	   	 partidoService.save(new Partido(alaves,atleti,1.4,5,6,fecha201,0,0));
	   	 partidoService.save(new Partido(eibar,depor,1.3,1.7,1.8,fecha201,3,1));
	   	 partidoService.save(new Partido(lega,celta,2,2.3,1.7,fecha201,0,2));
	   	 partidoService.save(new Partido(betis,barsa,2.1,3.1,1.2,fecha202,1,1));
	   	 partidoService.save(new Partido(espa,sev,2,3,1.5,fecha202,3,1));
	   	 partidoService.save(new Partido(athletic,spo,1.6,1.8,1.9,fecha202,2,1));
	   	 partidoService.save(new Partido(madrid,real,2,3,1.5,fecha202,3,0));
	   	 partidoService.save(new Partido(palmas,valencia,3,2,1.7,fecha202,3,1));

	       // LOG.info("...Bootstrapping completed");
	    }

 }

