package UnitTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.controller.HotelController;
import com.model.*;

public class TestClass {

	@Test
	public void isCustomerCorrect(){
		Customer customer = new Customer("Evan", "Laki-laki", "08716294");
		
		assertEquals("Evan", customer.getName());
		assertEquals("08716294", customer.getContact());
		assertEquals("Laki-laki", customer.getGender());
	}
	
	@Test
	public void isRoomCorrect() {
		Customer customer = new Customer("Evan", "Laki-laki", "08716294");
		Customer customer2 = new Customer("Eva", "Perempuan", "08716294");
		Customer customer3 = new Customer("Ivan", "Laki-laki", "08716294");
		
		Singleroom singleroom = new Singleroom(customer3);
		Doubleroom doubleroom = new Doubleroom(customer, customer2);
		
		assertEquals(customer3, singleroom.getCustomer());
		assertTrue(singleroom.getService().isEmpty());
		
		assertEquals(customer, doubleroom.getCustomer());
		assertEquals(customer2, doubleroom.getSecondCustomer());
		assertTrue(doubleroom.getService().isEmpty());
		
	}
	
	@Test
	public void isFoodCorrect() {
		Food food = new Food(1, 2);
		
		//the price should be 100
		assertEquals(100, food.getPrice());
	}
	
	@Test
	public void isFitnessCorrect() {
		Fitness fitness = new Fitness(1, 1);
		
		//the price should be 50
		assertEquals(50, fitness.getPrice());
	}
	
	@Test
	public void isLaundryCorrect() {
		Laundry laundry = new Laundry(1, 20);
		
		//the price should be 140
		assertEquals(140, laundry.getPrice());
	}
	
	@Test
	public void isSpaCorrect() {
		Spa spa = new Spa(4, 1);
		
		//the price should be 2500
		assertEquals(250, spa.getPrice());
	}
	
}
