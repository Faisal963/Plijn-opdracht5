package hu.nl.hibernate;

import hu.nl.hibernate.dao.OV_ChipkaartService;
import hu.nl.hibernate.dao.ReizigerService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ReizigerService.getInstance().getReizigerDao().openCurrentSession();
		Reiziger reiziger = ReizigerService.getInstance().getReizigerDao().findById(1);

		reiziger.setAchternaam("Kort");
		ReizigerService.getInstance().getReizigerDao().update(reiziger);
		ReizigerService.getInstance().getReizigerDao().closeCurrentSession();

		reiziger = ReizigerService.getInstance().findById(1);
		reiziger.setAchternaam("Rijn");
		ReizigerService.getInstance().update(reiziger);

		reiziger = new Reiziger(7, "Klaas", "", "Kort", new Date(1990 - 06 - 16));

		OV_Chipkaart kaart = OV_ChipkaartService.getInstance().findById(57401);

		kaart = new OV_Chipkaart(66666, new Date(2021 - 02 - 14), 1, 25, reiziger);
		reiziger.setOVChipkaarten(new ArrayList<>(Collections.singletonList(kaart)));

		ReizigerService.getInstance().save(reiziger);
		reiziger = ReizigerService.getInstance().findById(7);

		ReizigerService.getInstance().delete(reiziger);
		reiziger = ReizigerService.getInstance().findById(7);
		
		System.out.print("\n");
		HibernateUtil.shutdown();
	}
}
