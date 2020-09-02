package view;

import controller.RedesController;
public class Main {

	public static void main(String[] args) {
		RedesController RedeController = new RedesController();
		System.out.println(RedeController.ip(System.getProperty("os.name")));
		System.out.println(RedeController.ping(System.getProperty("os.name")));
	}

}
