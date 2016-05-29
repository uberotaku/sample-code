package rbc.test.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import rbc.main.java.Basket;
import rbc.main.java.BasketCalculatorWorkflow;
import rbc.main.java.Fruit;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith( MockitoJUnitRunner.class )
public class BasketCalculatorWorkflowTest
{
	@InjectMocks
    BasketCalculatorWorkflow workflow;

    private Fruit apple;
    private Fruit banana;
    private Fruit orange;

    @Before
    public void setup()
    {
        apple = new Fruit( "Apple", new BigDecimal( "0.30" ));
        banana = new Fruit( "Banana", new BigDecimal( "0.20" ));
        orange = new Fruit( "Orange", new BigDecimal( "0.50" ));
    }

	@Test
	public void testCalculateBasketCost()
	{
        Basket basket = new Basket();
        basket.insertItem( apple, 5 );
        basket.insertItem( banana, 2 );
        basket.insertItem( orange, 3 );

        BigDecimal result = workflow.calculateBasketCost( basket );
        assertNotNull( result );
        assertEquals( new BigDecimal( "3.40" ), result );
	}

    @Test
    public void testInsertIntoBasket_NewFruit()
    {
        Basket basket = new Basket();

        workflow.insertIntoBasket( basket, apple, 2 );
        assertEquals( basket.getItems().size(), 1 );
        assertEquals( basket.getItems().get( apple ), new Integer( 2 ) );
    }

    @Test
    public void testInsertIntoBasket_ExistingFruit()
    {
        Basket basket = new Basket();
        basket.insertItem( apple, 5 );

        workflow.insertIntoBasket( basket, apple, 2 );
        assertEquals( basket.getItems().size(), 1 );
        assertEquals( basket.getItems().get( apple ), new Integer(7) );
    }

    @Test
    public void testDeleteFromBasket()
    {
        Basket basket = new Basket();
        basket.insertItem( apple, 5 );

        workflow.deleteFromBasket( basket, apple, 2 );
        assertEquals( basket.getItems().size(), 1 );
        assertEquals( basket.getItems().get( apple ), new Integer(3) );
    }

    @Test
    public void testDeleteFromBasket_NotFound()
    {
        Basket basket = new Basket();
        basket.insertItem( apple, 5 );

        workflow.deleteFromBasket( basket, orange, 1 );
        assertEquals( basket.getItems().size(), 1 );
        assertEquals( basket.getItems().get( apple ), new Integer( 5 ) );
    }

    @Test
    public void testDeleteFromBasket_TooMany()
    {
        Basket basket = new Basket();
        basket.insertItem( apple, 5 );

        workflow.deleteFromBasket( basket, apple, 10 );
        assertEquals( basket.getItems().size(), 0 );
    }
}
