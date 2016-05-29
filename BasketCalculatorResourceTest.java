package rbc.test.java;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rbc.main.java.Basket;
import rbc.main.java.BasketCalculatorResource;
import rbc.main.java.BasketCalculatorWorkflow;

import static org.mockito.Mockito.*;

@RunWith( MockitoJUnitRunner.class )
public class BasketCalculatorResourceTest
{
	@Mock
    BasketCalculatorWorkflow workflow;

    @InjectMocks
    private BasketCalculatorResource resource;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCalculateBasketCost() throws Exception
    {
        Basket basket = new Basket();
        resource.calculateBasketCost( basket );
        verify( workflow ).calculateBasketCost( basket );
	}

    @Test
    public void testCalculateBasketCost_e() throws Exception
    {
        Basket basket = new Basket();

        when( workflow.calculateBasketCost( any( Basket.class ) ) ).thenThrow( new RuntimeException() );
        thrown.expect( Exception.class );
        thrown.expectMessage( "Internal Server Error - Contact Support" );

        resource.calculateBasketCost( basket );
    }
}
