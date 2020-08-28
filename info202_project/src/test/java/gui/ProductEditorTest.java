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
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author User
 */
public class ProductEditorTest {

    dao.ProductDAO products = new dao.ProductJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    private DialogFixture fixture;
    private Robot robot;

    public ProductEditorTest() {
    }

    @BeforeEach
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();

        // Slow down the robot a little bit - default is 30 (milliseconds).
        // Do NOT make it less than 10 or you will have thread-race problems.
        robot.settings().delayBetweenEvents(75);

        // add some products for testing with
        Collection<String> categories = new HashSet<>();
        categories.add("Knitting");
        categories.add("Ninjitsu");

        // create a mock for the DAO
        products = mock(dao.ProductDAO.class);

        // stub the getMajors method to return the test majors
        when(products.getCategories()).thenReturn(categories);

    }

    @AfterEach
    public void tearDown() {
        // clean up fixture so that it is ready for the next test
        fixture.cleanUp();
    }

    @Test
    public void testSave() {
        // create the dialog passing in the mocked DAO
		gui.ProductEditor dialog = new gui.ProductEditor(null, true, products);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);

		// show the dialog on the screen, and ensure it is visible
		fixture.show().requireVisible();

		// click the dialog to ensure the robot is focused in the correct window
		// (can get confused by multi-monitor and virtual desktop setups)
		fixture.click();		
		
		// enter some details into the UI components
		fixture.textBox("txtId").enterText("1234");
		fixture.textBox("txtName").enterText("Stuff");
                fixture.textBox("txtDescription").enterText("Item");
                fixture.comboBox("categorycombobox").selectItem("Knitting");
                fixture.textBox("txtPrice").enterText("111");
                fixture.textBox("txtQuantity").enterText("222");
		

		// click the save button
		fixture.button("saveButton").click();

		// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
		ArgumentCaptor<domain.Product> argument = ArgumentCaptor.forClass(domain.Product.class);

		// verify that the DAO.save method was called, and capture the passed student
		verify(products).saveProduct(argument.capture());

		// retrieve the passed student from the captor
		domain.Product savedProduct = argument.getValue();

		// test that the student's details were properly saved
		assertThat("Ensure the ID was saved", savedProduct.getProductID(), is("1234"));
		assertThat("Ensure the name was saved", savedProduct.getProductName(), is("Stuff"));
		assertThat("Ensure the description was saved", savedProduct.getDescription(), is("Item"));
                assertThat("Ensure the category was saved", savedProduct.getCategory(), is("Knitting"));
                assertThat("Ensure the price was saved", savedProduct.getListPrice(), is(new BigDecimal(111)));
                assertThat("Ensure the quantity in stock was saved", savedProduct.getQuantityInStock(), is(new BigDecimal(222)));
    }

}
