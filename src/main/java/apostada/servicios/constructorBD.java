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

	   	 //Jornada 29 ligaBBVA (Futura)
	   	 Date fecha291= new Date(117,3,2,22,30,00);
	   	 Date fecha292= new Date(117,3,3,20,00,00);	 
	   	 partidoService.save(new Partido(madrid,alaves,2.45,3.25,2.75,fecha291));
	   	 partidoService.save(new Partido(celta,palmas,1.83,3.4,4,fecha291));
	   	 partidoService.save(new Partido(villa,eibar,2.25,3,3.20,fecha291));
	   	 partidoService.save(new Partido(espa,betis,2.15,3.4,3.6,fecha291));
	   	 partidoService.save(new Partido(osa,athletic,5.5,4.2,1.6,fecha291));
	   	 partidoService.save(new Partido(real,lega,2.8,3.2,2.7,fecha292));
	   	 partidoService.save(new Partido(malaga,atleti,1.3,5.5,8,fecha292));
	   	 partidoService.save(new Partido(sev,spo,1.1,6,15,fecha292));
	   	 partidoService.save(new Partido(valencia,depor,5,3.8,1.6,fecha292));
	   	 partidoService.save(new Partido(grana,barsa,5.5,4.2,1.6,fecha292));
	   	 
		 //Premier League
		 Liga premier = new Liga("Premier League");
		 ligaService.save(premier);
		 //Equipo premier
		 Equipo chelsea = new Equipo("Chelsea",premier);
		 Equipo totte= new Equipo("Tottenham",premier);
		 Equipo city= new Equipo("Manchester City",premier);
		 Equipo ars= new Equipo("Arsenal",premier);
		 Equipo liv= new Equipo("Liverpool",premier);
		 Equipo man= new Equipo("Manchester United",premier);
		 Equipo ever= new Equipo("Everton",premier);
		 Equipo brom= new Equipo("West Bromwich",premier);
		 Equipo ham= new Equipo("West Ham",premier);
		 Equipo wat= new Equipo("Watford",premier);
		 Equipo stoke= new Equipo("Stoke City",premier);
		 Equipo bur= new Equipo("Burnley",premier);
		 Equipo sou= new Equipo("Southampton",premier);
		 Equipo afc = new Equipo("Bournemouth",premier);
		 Equipo mid= new Equipo("Middlesbrough",premier);
		 Equipo lei= new Equipo("Leicester",premier);
		 Equipo swa= new Equipo("Swansea City",premier);
		 Equipo hull= new Equipo("Hull City",premier);
		 Equipo cry= new Equipo("Crystal Palace",premier);
		 Equipo sun= new Equipo("Sunderland",premier);
		 
		 equipoService.save(chelsea);
		 equipoService.save(totte);
		 equipoService.save(city);
		 equipoService.save(ars);
		 equipoService.save(liv);
		 equipoService.save(man);
		 equipoService.save(ever);
		 equipoService.save(brom);
		 equipoService.save(ham);
		 equipoService.save(wat);
		 equipoService.save(stoke);
		 equipoService.save(bur);
		 equipoService.save(sou);
		 equipoService.save(afc);
		 equipoService.save(mid);
		 equipoService.save(lei);
		 equipoService.save(swa);
		 equipoService.save(hull);
		 equipoService.save(cry);
		 equipoService.save(sun);
		 
		 
		 //jornada 4 Premier League
		 Date fecha43 = new Date(116,8,10,14,30,00);
		 Date fecha44 = new Date(116,8,12,19,00,00);
		 partidoService.save(new Partido(afc,brom,1.5,2,3,fecha43,1,0));
		 partidoService.save(new Partido(ars,sou,1.2,3,1.7,fecha43,2,1));
		 partidoService.save(new Partido(bur,hull,1.6,1.9,2,fecha43,1,1));
		 partidoService.save(new Partido(liv,lei,1.6,2,2.6,fecha43,4,1));
		 partidoService.save(new Partido(man,city,1.9,2,1.3,fecha43,1,2));
		 partidoService.save(new Partido(mid,cry,1.1,1.6,3,fecha44,1,2));
		 partidoService.save(new Partido(stoke,totte,2,3,1.6,fecha44,0,4));
		 partidoService.save(new Partido(sun,ever,8,1.3,1.25,fecha44,0,3));
		 partidoService.save(new Partido(swa,chelsea,9,5,1.1,fecha44,2,2));
		 partidoService.save(new Partido(ham,wat,1.2,3,10,fecha44,2,4));
		 
		 //jornada 5 Premier League
		 
		 Date fecha53 = new Date(116,8,16,18,30,00);
		 Date fecha54 = new Date(116,8,17,22,00,00);
		 
		 partidoService.save(new Partido(chelsea,liv,1.5,2,3,fecha53,1,2));
		 partidoService.save(new Partido(cry,stoke,1.7,1.9,2.5,fecha53,4,1));
		 partidoService.save(new Partido(ever,mid,1.9,1.5,2,fecha53,3,1));
		 partidoService.save(new Partido(hull,ars,1.6,1.9,3,fecha53,1,4));
		 partidoService.save(new Partido(lei,bur,1.5,2,3,fecha53,3,0));
		 partidoService.save(new Partido(city,afc,2.2,2.6,1.1,fecha54,4,0));
		 partidoService.save(new Partido(sou,swa,3,2,1.1,fecha54,1,0));
		 partidoService.save(new Partido(totte,sun,6,5,1.1,fecha54,1,0));
		 partidoService.save(new Partido(wat,man,2.3,2.5,2.6,fecha54,3,1));
		 partidoService.save(new Partido(brom,ham,2.6,2.8,1.6,fecha54,4,2));
		 
		 //jornada 7 Premier League
		 Date fecha73 = new Date(116,9,2,15,30,00);
		 Date fecha74 = new Date(116,9,1,21,00,00);
		 
		 partidoService.save(new Partido(bur,ars,1.5,1.75,2,fecha74,0,1));
		 partidoService.save(new Partido(ever,cry,3,2,1.5,fecha74,1,1));
		 partidoService.save(new Partido(hull,chelsea,1.25,2,6,fecha74,0,2));
		 partidoService.save(new Partido(lei,sou,1.1,8,11,fecha74,0,0));
		 partidoService.save(new Partido(man,stoke,1.6,3,4,fecha74,1,1));
		 partidoService.save(new Partido(sun,brom,1.1,1.5,3,fecha73,1,1));
		 partidoService.save(new Partido(swa,liv,5,2,1.5,fecha73,1,2));
		 partidoService.save(new Partido(totte,city,2,3,1.9,fecha73,2,0));
		 partidoService.save(new Partido(wat,afc,1.6,1.7,1.9,fecha73,2,2));
		 partidoService.save(new Partido(ham,mid,2,3,4.5,fecha73,1,1));

		 //jornada 28 Premier League (Futura)
		 
		 Date fecha284 = new Date(117,2,11,17,00,00);	 
		 Date fecha283 = new Date(117,2,13,21,00,00);

		 partidoService.save(new Partido(afc,ham,9,4.75,1.35,fecha283));
		 partidoService.save(new Partido(ars,lei,2.05,3.2,3.75,fecha283));
		 partidoService.save(new Partido(liv,bur,3.75,3.4,2,fecha283));
		 partidoService.save(new Partido(chelsea,wat,1.25,5.75,13,fecha283));
		 partidoService.save(new Partido(ever,brom,3.6,3.2,2.1,fecha283));
		 partidoService.save(new Partido(hull,swa,2,3.25,3.8,fecha284));
		 partidoService.save(new Partido(city,stoke,2.15,3.2,3.5,fecha284));
		 partidoService.save(new Partido(mid,sun,1.4,4.33,8,fecha284));
		 partidoService.save(new Partido(sou,man,2.3,3.2,3.1,fecha284));
		 partidoService.save(new Partido(cry,totte,11,5.75,1.25,fecha284));
	   	 
	   	 
	  	 
		 //Serie A
		 Liga serie = new Liga("Serie A");
		 ligaService.save(serie);
		 //Equipo italiano
		 Equipo  juv= new Equipo("Juventus",serie);
		 Equipo  roma= new Equipo("Roma",serie);
		 Equipo  nap= new Equipo("Napoli",serie);
		 Equipo  laz= new Equipo("Lazio",serie);
		 Equipo  inter= new Equipo("Inter",serie);
		 Equipo  ata= new Equipo("Atalanta",serie);
		 Equipo  mil= new Equipo("Milan",serie);
		 Equipo  fio= new Equipo("Fiorentina",serie);
		 Equipo  tor= new Equipo("Torino",serie);
		 Equipo  sam= new Equipo("Sampdoria",serie);
		 Equipo  chi= new Equipo("Chievo",serie);
		 Equipo  udi= new Equipo("Udinese",serie);
		 Equipo  sass= new Equipo("Sassuolo Calcio",serie);
		 Equipo  bolo= new Equipo("Bologna",serie);
		 Equipo  cag= new Equipo("Cagliari",serie);
		 Equipo  gen= new Equipo("Genoa",serie);
		 Equipo  emp= new Equipo("Empoli",serie);
		 Equipo  pal= new Equipo("Palermo",serie);
		 Equipo  crot= new Equipo("Crotone",serie);
		 Equipo  pes= new Equipo("Pescara",serie);
	   	 
		 equipoService.save(juv);
		 equipoService.save(roma);
		 equipoService.save(nap);
		 equipoService.save(laz);
		 equipoService.save(inter);
		 equipoService.save(ata);
		 equipoService.save(mil);
		 equipoService.save(fio);
		 equipoService.save(tor);
		 equipoService.save(sam);
		 equipoService.save(chi);
		 equipoService.save(udi);
		 equipoService.save(sass);
		 equipoService.save(bolo);
		 equipoService.save(cag);
		 equipoService.save(gen);
		 equipoService.save(emp);
		 equipoService.save(pal);
		 equipoService.save(crot);
		 equipoService.save(pes);
	   	 
		 //jornada 3 Serie A
		 Date fecha35 = new Date(116,8,11,15,30,00);
		 Date fecha36 = new Date(116,8,12,20,00,00);
		 
		 partidoService.save(new Partido(ata,tor,1.5,2.5,1.9,fecha35,2,1));
		 partidoService.save(new Partido(bolo,cag,1.7,2,3,fecha35,2,1));
		 partidoService.save(new Partido(chi,laz,1.6,5,2,fecha35,1,1));
		 partidoService.save(new Partido(emp,crot,2,1.5,1.6,fecha35,2,1));
		 partidoService.save(new Partido(gen,fio,1.6,2,2.5,fecha35,1,0));
		 partidoService.save(new Partido(juv,sass,2.25,1.5,1.7,fecha36,3,1));
		 partidoService.save(new Partido(mil,udi,1.5,2.5,2,fecha36,0,1));
		 partidoService.save(new Partido(pal,nap,2.6,1.75,1.25,fecha36,0,3));
		 partidoService.save(new Partido(pes,inter,2.8,2.1,1.6,fecha36,1,2));
		 partidoService.save(new Partido(roma,sam,1.8,1.9,2,fecha36,3,2));
		 
		 //Jornada 5 Serie A
		 partidoService.save(new Partido(ata,pal,1.25,3,10,fecha53,0,1));
		 partidoService.save(new Partido(bolo,sam,1.7,2,3,fecha53,2,0));
		 partidoService.save(new Partido(chi,sass,1.2,1.7,5,fecha53,2,1));
		 partidoService.save(new Partido(emp,inter,3,1.9,1.25,fecha53,0,2));
		 partidoService.save(new Partido(gen,nap,3,2.5,1.9,fecha53,0,0));
		 partidoService.save(new Partido(juv,cag,1.7,1.5,1.6,fecha54,4,0));
		 partidoService.save(new Partido(mil,laz,1.9,1.5,1.1,fecha54,2,0));
		 partidoService.save(new Partido(pes,tor,1.9,2,3,fecha54,0,0));
		 partidoService.save(new Partido(roma,crot,5,1.5,1.2,fecha54,4,0));
		 partidoService.save(new Partido(udi,fio,5,1.9,1.8,fecha54,2,2));

		 
		 
		 
		 //Jornada 7 Serie A
		 partidoService.save(new Partido(ata,nap,1.5,3,2.5,fecha73,1,0));
		 partidoService.save(new Partido(bolo,gen,1.7,2,3,fecha73,0,1));
		 partidoService.save(new Partido(cag,crot,3,2,1.5,fecha73,2,1));
		 partidoService.save(new Partido(emp,juv,2,2,1.9,fecha73,0,3));
		 partidoService.save(new Partido(mil,sass,2.5,2.25,3,fecha73,4,3));
		 partidoService.save(new Partido(pes,chi,11,1.2,1.1,fecha74,0,2));
		 partidoService.save(new Partido(roma,inter,3,2,1.6,fecha74,2,1));
		 partidoService.save(new Partido(sam,pal,2,1.6,1.2,fecha74,1,1));
		 partidoService.save(new Partido(tor,fio,2.5,1.5,4,fecha74,2,1));
		 partidoService.save(new Partido(udi,laz,1.6,1.8,1.7,fecha74,0,3));

		 //Jornada 28 Serie A(Futura)
		 partidoService.save(new Partido(inter,ata,1.60,4,4.5,fecha283));
		 partidoService.save(new Partido(sass,bolo,1.75,3.8,4,fecha283));
		 partidoService.save(new Partido(fio,cag,2.6,3.4,2.5,fecha283));
		 partidoService.save(new Partido(nap,crot,3.1,3.3,2.25,fecha283));
		 partidoService.save(new Partido(chi,emp,2.3,3.5,2.80,fecha283));
		 partidoService.save(new Partido(juv,mil,1.8,3.3,4.75,fecha284));
		 partidoService.save(new Partido(pal,roma,3.2,3.5,2.15,fecha284));
		 partidoService.save(new Partido(gen,sam,1.5,4,5.75,fecha284));
		 partidoService.save(new Partido(laz,tor,1.75,3.6,4.5,fecha284));
		 partidoService.save(new Partido(pes,udi,12,6.5,1.22,fecha284));

		 
	       // LOG.info("...Bootstrapping completed");
	    }

 }

