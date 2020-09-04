/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import static org.assertj.swing.core.matcher.DialogMatcher.withTitle;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author User
 */
public class ViewProductTest {

	dao.ProductDAO product = new dao.ProductJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
	private DialogFixture fixture;
	private Robot robot;
	private domain.Product p1;
	private domain.Product p2;

	public ViewProductTest() {
	}

	@BeforeEach
	public void setUp() {
		robot = BasicRobot.robotWithNewAwtHierarchy();

		// Slow down the robot a little bit - default is 30 (milliseconds).
		// Do NOT make it less than 10 or you will have thread-race problems.
		robot.settings().delayBetweenEvents(75);

		// create a products collection for stubbing purposes
		Collection<domain.Product> products = new HashSet<>();
		p1 = new domain.Product("12345", "Product1", "Stuff1", "Item1", (new BigDecimal(111)), (new BigDecimal(222)));
		p2 = new domain.Product("67890", "Product2", "Stuff2", "Item2", (new BigDecimal(333)), (new BigDecimal(444)));
		products.add(p1);
		products.add(p2);

		// create a mock for the DAO
		product = mock(dao.ProductDAO.class);

		// stub the getProducts method
		when(product.getProducts()).thenReturn(products);
		// stub the removeProduct method
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// remove the product from the collection that getProducts() uses
				products.remove(p1);
				return null;
			}
		}).when(product).deleteProduct(p1);
	}

	@AfterEach
	public void tearDown() {
		// clean up fixture so that it is ready for the next test
		fixture.cleanUp();
	}

	@Test
	public void testViewAllProduct() {
		// create the dialog passing in the mocked DAO
		gui.ViewProduct dialog = new gui.ViewProduct(null, true, product);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);

		// show the dialog on the screen, and ensure it is visible
		fixture.show().requireVisible();

		// click the dialog to ensure the robot is focused in the correct window
		// (can get confused by multi-monitor and virtual desktop setups)
		fixture.click();

		// get the model
		helpers.SimpleListModel model = (helpers.SimpleListModel) fixture.list().target().getModel();

		// check the contents
		assertTrue("list contains the expected product", model.contains(p1));
		assertTrue("list contains the expected product", model.contains(p2));
		assertEquals("list contains the correct number of products", 2, model.getSize());
	}

	@Test
	public void testDeleteProduct() {
		// create the dialog passing in the mocked DAO
		gui.ViewProduct dialog = new gui.ViewProduct(null, true, product);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);

		// show the dialog on the screen, and ensure it is visible
		fixture.show().requireVisible();

		// click the dialog to ensure the robot is focused in the correct window
		// (can get confused by multi-monitor and virtual desktop setups)
		fixture.click();
		helpers.SimpleListModel model = (helpers.SimpleListModel) fixture.list().target().getModel();
		// check the contents
		assertTrue("list contains the expected product", model.contains(p1));
		assertTrue("list contains the expected product", model.contains(p2));
		assertEquals("list contains the correct number of products", 2, model.getSize());
		//select p1
		fixture.list().selectItem(p1.toString());
		// click the delete button
		fixture.button("deleteButton").click();
		DialogFixture focus = fixture.dialog(withTitle("Delete Confirmation").andShowing()).requireVisible();
		focus.button(withText("Yes")).click();

		// verify that the DAO.save method was called, and capture the passed student
		verify(product).deleteProduct(p1);

		// check the contents
		assertTrue("list does not contains the expected product", !model.contains(p1));
		assertTrue("list contains the expected product", model.contains(p2));
		assertEquals("list contains the correct number of products", 1, model.getSize());

	}
}
