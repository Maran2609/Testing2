package uistore;

import org.openqa.selenium.By;

public class LandingpageUI {

	public static By origin=By.id("BE_flight_origin_city");
	public static By arrival=By.id("BE_flight_arrival_city");
	public static By calender=By.id("BE_flight_origin_date");
	public static By date=By.xpath("//*[@id=\"16/09/2021\"]");
	public static By search_button=By.id("BE_flight_flsearch_btn");
	public static By datetext=By.xpath("//*[@id='BE_flight_form_wrapper']/div[1]/div[2]/ul/li[2]/ul/li[1]/section/label/div/p[1]");	
}
