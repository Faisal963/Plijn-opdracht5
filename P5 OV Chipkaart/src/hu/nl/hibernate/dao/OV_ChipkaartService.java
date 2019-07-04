package hu.nl.hibernate.dao;

import java.util.List;
import hu.nl.hibernate.OV_Chipkaart;

public class OV_ChipkaartService {
	private static OV_ChipkaartService ov_ChipkaartService;
	private OV_ChipkaartDao kaartDao;

	public static OV_ChipkaartService getInstance() {
		if (ov_ChipkaartService == null)
			ov_ChipkaartService = new OV_ChipkaartService();
		return ov_ChipkaartService;
	}

	public OV_ChipkaartService() {
		kaartDao = new OV_ChipkaartDao();
	}

	public OV_Chipkaart findById(int id) {
		kaartDao.openCurrentSession();
		OV_Chipkaart kaart = kaartDao.findById(id);
		if (kaart == null) {
        	System.out.print("\nKaart nummer " + id + " is niet gevonden.");
        } else {
        	System.out.print("\nKaart nummer " + id + " is gevonden.");
        }
		kaartDao.closeCurrentSession();
		return kaart;
	}

	public List<OV_Chipkaart> findAll() {
		kaartDao.openCurrentSession();
		List<OV_Chipkaart> kaarten = kaartDao.findAll();
		kaartDao.closeCurrentSession();
		return kaarten;
	}

	public void save(OV_Chipkaart kaartTabel) {
		kaartDao.openCurrentSessionwithTransaction();
		kaartDao.save(kaartTabel);
		kaartDao.closeCurrentSessionwithTransaction();
		System.out.print("\nKaart is opgeslagen.");
	}

	public void update(OV_Chipkaart kaartTabel) {
		kaartDao.openCurrentSessionwithTransaction();
		kaartDao.update(kaartTabel);
		kaartDao.closeCurrentSessionwithTransaction();
		System.out.print("\nKaart is gewijzigd.");
	}

	public void delete(int id) {
		kaartDao.openCurrentSessionwithTransaction();
		OV_Chipkaart kaart = kaartDao.findById(id);
		kaartDao.delete(kaart);
		kaartDao.closeCurrentSessionwithTransaction();
		System.out.print("\nKaart is verwijderd.");
	}

	public void delete(OV_Chipkaart kaart) {
		kaartDao.openCurrentSessionwithTransaction();
		kaartDao.delete(kaart);
		kaartDao.closeCurrentSessionwithTransaction();
		System.out.print("\nKaart is verwijderd.");
	}

	public void deleteAll() {
		kaartDao.openCurrentSessionwithTransaction();
		kaartDao.deleteAll();
		kaartDao.closeCurrentSessionwithTransaction();
	}

	public OV_ChipkaartDao getOvChipkaartDao() {
		return kaartDao;
	}
}
