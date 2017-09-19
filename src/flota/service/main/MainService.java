package flota.service.main;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import flota.service.beans.Angajat;
import flota.service.beans.BeanDelegatieAprobare;
import flota.service.beans.DelegatieModifAntet;
import flota.service.beans.DelegatieModifDetalii;
import flota.service.beans.TestObject;
import flota.service.beans.Traseu;
import flota.service.model.OperatiiAdresa;
import flota.service.model.OperatiiAngajat;
import flota.service.model.OperatiiDelegatii;
import flota.service.model.OperatiiMasina;
import flota.service.model.OperatiiTraseu;
import flota.service.utils.MailOperations;

@Path("delegatii")
public class MainService {

	private static final Logger logger = LogManager.getLogger(MainService.class);

	@Path("localitati")
	@GET
	public Response localitati(@QueryParam("codJudet") String codJudet) {
		String listLocs = new OperatiiAdresa().getLocalitatiJudet(codJudet).toString();

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").entity(listLocs)
				.build();

	}

	@Path("localitatiPost")
	@POST
	public Response localitatiPost(@FormParam("codJudet") String codJudet) {
		String listLocs = new OperatiiAdresa().getLocalitatiJudet(codJudet).toString();

		MailOperations.sendMail("codJudet: " + codJudet);

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").entity(listLocs)
				.build();

	}

	@Path("adaugaDelegatie")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String adaugaDelegatie(@FormParam("codAngajat") String codAngajat, @FormParam("tipAngajat") String tipAngajat,
			@FormParam("dataP") String dataPlecare, @FormParam("oraP") String oraPlecare, @FormParam("dataS") String dataSosire,
			@FormParam("distcalc") String distCalc, @FormParam("stops") String stops, @FormParam("nrAuto") String nrAuto) {

		synchronized (MainService.class) {

			boolean success = new OperatiiDelegatii().adaugaDelegatie(codAngajat, tipAngajat, dataPlecare, oraPlecare, distCalc, stops, dataSosire, nrAuto);
			return success ? "1" : "0";
		}
	}

	@Path("modificaDelegatie")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String modificaDelegatie(@FormParam("codAngajat") String codAngajat, @FormParam("tipAngajat") String tipAngajat,
			@FormParam("dataP") String dataPlecare, @FormParam("oraP") String oraPlecare, @FormParam("dataS") String dataSosire,
			@FormParam("distcalc") String distCalc, @FormParam("stops") String stops, @FormParam("nrAuto") String nrAuto,
			@FormParam("idDelegatie") String idDelegatie) {

		OperatiiDelegatii opDelegatii = new OperatiiDelegatii();
		opDelegatii.respingeDelegatie(idDelegatie, tipAngajat, codAngajat);

		boolean success = opDelegatii.adaugaDelegatie(codAngajat, tipAngajat, dataPlecare, oraPlecare, distCalc, stops, dataSosire, nrAuto);
		return success ? "1" : "0";
	}

	@Path("afisDelegatiiAprob")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<BeanDelegatieAprobare> afiseazaDelegatiiAprobare(@QueryParam("tipAngajat") String tipAngajat, @QueryParam("unitLog") String unitLog,
			@QueryParam("codDepart") String codDepart) {

		return new OperatiiDelegatii().getDelegatiiAprobari(tipAngajat, unitLog, codDepart);

	}

	@Path("aprobaDelegatie")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String aprobaDelegatie(@FormParam("idDelegatie") String idDelegatie, @FormParam("tipAngajat") String tipAngajat,
			@FormParam("kmRespinsi") String kmRespinsi, @FormParam("codAngajat") String codAngajat, @FormParam("tipAprobare") String tipAprobare) {

		new OperatiiDelegatii().aprobaDelegatie(idDelegatie, tipAngajat, kmRespinsi, codAngajat, tipAprobare);
		return "!";

	}

	@Path("respingeDelegatie")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String respingeDelegatie(@FormParam("idDelegatie") String idDelegatie, @FormParam("tipAngajat") String tipAngajat,
			@FormParam("codAngajat") String codAngajat) {

		new OperatiiDelegatii().respingeDelegatie(idDelegatie, tipAngajat, codAngajat);
		return "!";

	}

	@Path("afiseazaDelegatii")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<BeanDelegatieAprobare> afiseazaDelegatii(@QueryParam("codAngajat") String codAngajat, @QueryParam("dataStart") String dataStart,
			@QueryParam("dataStop") String dataStop, @QueryParam("tipAngajat") String tipAngajat, @QueryParam("unitLog") String unitLog,
			@QueryParam("codDepart") String codDepart, @QueryParam("tipAfis") String tipAfis) {

		if (tipAfis != null && tipAfis.equalsIgnoreCase("P"))
			return new OperatiiDelegatii().afiseazaDelegatiiProprii(codAngajat, dataStart, dataStop);
		else if (tipAfis != null && tipAfis.equalsIgnoreCase("S"))
			return new OperatiiDelegatii().afiseazaDelegatiiSubord(dataStart, dataStop, tipAngajat, unitLog, codDepart);

		return new ArrayList<>();

	}

	@Path("getCoordsTraseu")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getCoordonateTraseu(@QueryParam("idDelegatie") String idDelegatie) {

		return new OperatiiTraseu().getCoordonateTraseu(idDelegatie).toString();
	}

	@Path("cautaLocalitati")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getListLocalitati(@QueryParam("numeLoc") String numeLoc) {
		return new OperatiiAdresa().getListLocalitati(numeLoc);
	}

	@Path("afisListDelModif")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DelegatieModifAntet> getListDelegatiiModif(@QueryParam("codAngajat") String codAngajat) {
		return new OperatiiDelegatii().getDelegatiiModificare(codAngajat);
	}

	@Path("afisDelegatieModif")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public DelegatieModifDetalii getDelegatieModif(@QueryParam("idDelegatie") String idDelegatie) {
		return new OperatiiDelegatii().getDelegatieModif(idDelegatie);
	}

	@Path("getAngajati")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Angajat> getAngajati(@QueryParam("tipAngajat") String tipAngajat, @QueryParam("unitLog") String unitLog,
			@QueryParam("codDepart") String codDepart) {
		return new OperatiiAngajat().getAngajati(tipAngajat, unitLog, codDepart);
	}

	@Path("getTraseu")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Traseu getTraseu(@QueryParam("codAngajat") String codAngajat, @QueryParam("dataStart") String dataStart, @QueryParam("dataStop") String dataStop,
			@QueryParam("nrMasina") String nrMasina) {
		return new OperatiiTraseu().getTraseu(codAngajat, dataStart, dataStop, nrMasina);
	}

	@Path("getMasiniAngajat")
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getMasiniAngajat(@QueryParam("codAngajat") String codAngajat, @QueryParam("dataStart") String dataStart) {
		return new OperatiiMasina().getMasiniAngajat(codAngajat, dataStart);
	}

	@Path("calculeazaDelegatii")
	@GET
	public String calculeazaDelegatii() {
		new OperatiiDelegatii().verificaDelegatiiTerminateCompanie();
		return "Done!";

	}

	@Path("testMail")
	@GET

	public void testMail(@QueryParam("body") String body) {
		try {
			MailOperations.sendMail(body);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
	}

	@Path("getObject")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String getMasiniAngajat1(TestObject testObject) {

		System.out.println("prop1: " + testObject);

		return testObject.toString();

	}

	@Path("getObjectRemote")
	@POST
	public Response localitati123(@FormParam("codJudet") String codJudet) {

		Gson gson = new GsonBuilder().create();
		TestObject testObject = gson.fromJson(codJudet, TestObject.class);

		MailOperations.sendMailName("Deserialized: " + testObject.toString());

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").entity(codJudet)
				.build();

	}

	@Path("customers/{id:.+}")
	@GET
	public String testParam(@PathParam("id") int id) {
		return "id=" + id;

	}

	@GET
	@Path("{id : .+}/address")
	public String getCustomer(@PathParam("id") String id) {
		return "id=" + id;
	}

	@GET
	@Path("{first}-{last}")
	public String testPath(@PathParam("first") String firstName, @PathParam("last") PathSegment lastName) {
		return firstName + " - " + lastName;
	}

}
