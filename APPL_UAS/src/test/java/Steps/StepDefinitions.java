package Steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.model.Fitness;
import com.model.Food;
import com.model.Laundry;
import com.model.Singleroom;
import com.model.Spa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	@Then("Food is ordered and added to room's bill")
	public void food_is_ordered_and_added_to_room_s_bill() {
		Singleroom room = new Singleroom();
		room.getService().add(new Food(1, 2));
		assertFalse(room.getService().isEmpty());
	}
	
	@Then("Spa is added to the bill")
	public void spa_is_added_to_the_bill() {
		Singleroom room = new Singleroom();
		room.getService().add(new Spa(1, 2));
		assertFalse(room.getService().isEmpty());
	}
	
	@Then("package price is added to rooms bill")
	public void package_price_is_added_to_rooms_bill() {
		Singleroom room = new Singleroom();
		room.getService().add(new Fitness(1, 2));
		assertFalse(room.getService().isEmpty());
	}
	
	@Then("Laundry price is added to rooms bill")
	public void laundry_price_is_added_to_rooms_bill() {
		Singleroom room = new Singleroom();
		room.getService().add(new Laundry(1, 10));
		assertFalse(room.getService().isEmpty());
	}
	
	@Then("Old room is empty and new room is occupied by Customer")
	public void old_room_is_empty_and_new_room_is_occupied_by_customer() {
		Singleroom oldRoom = new Singleroom();
		Singleroom newRoom;
		
		newRoom = oldRoom;
		oldRoom = null;
		
		assertNotNull(newRoom);
		assertNull(oldRoom);
	}
	
	@Given("List of menu from the hotels")
	public void list_of_menu_from_the_hotels() {
	    System.out.println("Inside Step - List of Menu is Shown");
	}
	
	@When("customer choose show room details")
	public void customer_choose_show_room_details() {
		System.out.println("Inside Step - User choose show room details");
	}

	@Then("Room details is printed")
	public void room_details_is_printed() {
		System.out.println("Inside Step - Room availability is printed");
	}
	
	@When("customer choose show room availability")
	public void customer_choose_show_room_availability() {
		System.out.println("Inside Step - User choose show room availability");
	}

	@Then("Room availability is printed")
	public void room_availability_is_printed() {
		System.out.println("Inside Step - Room availability is printed");
	}
	
	@Given("List of rooms")
	public void list_of_rooms() {
		System.out.println("Inside Step - List of Rooms Printed");
	}

	@When("customer choose a room type")
	public void customer_choose_a_room_type() {
		System.out.println("Inside Step - Customer choose a room type");
	}

	@When("empty room si available")
	public void empty_room_si_available() {
		System.out.print("Room Empty : True");
	}

	@Then("Room is booked by customer")
	public void room_is_booked_with() {
		System.out.println("Inside Step - Room is Booked with Customer Information");
	}
	
	@Given("Room booked by some customer")
	public void room_booked_by_some_customer() {
		System.out.println("Room is Booked by customer");
	}

	@When("customer choose checkout")
	public void customer_choose_checkout() {
		System.out.println("Customer choose checkout");
	}

	@Then("Room is empty and bill is printed")
	public void room_is_empty_and_bill_is_printed() {
		System.out.println("Room empty and bill printed");
	}
	
	@Given("List of foods")
	public void list_of_foods() {
		System.out.println("Inside Step - Customer showed foods list");
	}

	@When("Customer choose a food")
	public void customer_choose_a_food() {
		System.out.println("Inside Step - Customer choose a food");
	}
	
	@Given("List of spa packages")
	public void list_of_spa_packages() {
		System.out.println("Inside Step - Customer showed spa packages list");
	}

	@When("Customer choose spa package")
	public void customer_choose_spa_package() {
		System.out.println("Customer choose spa package");
	}

	@When("customer choose fitness package")
	public void customer_choose_fitness_package() {
		System.out.println("Customer choose fitness package");
	}

	@When("customer choose laundry package")
	public void customer_choose_laundry_package() {
		System.out.println("Customer choose laundry package");
	}

	@When("customer input the number of clothes")
	public void customer_input_the_number_of_clothes() {
		System.out.println("Customer input the number of clothes");
	}

	@When("customer choose new room number")
	public void customer_choose_new_room_number() {
		System.out.println("Customer choose new room number");
	}


	
	@Then("Cant upgrade room")
	public void cant_upgrade_room() {
	    System.out.println("Cant Upgrade Room");
	}
}
