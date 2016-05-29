package rbc.main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.math.BigDecimal;

public class BasketCalculatorResource
{
    private static final Logger log = LoggerFactory.getLogger( BasketCalculatorResource.class );

    @Autowired
    BasketCalculatorWorkflow basketCalculatorWorkflow;

    @GET
    @Path( "/calculate/" )
    public BigDecimal calculateBasketCost( @QueryParam( "basket" ) Basket basket ) throws Exception
    {
        try
        {
            return basketCalculatorWorkflow.calculateBasketCost( basket );
        }
        catch ( RuntimeException re )
        {
            log.error( "An exception occurred calculateBasketCost", re );
            throw new Exception( "Internal Server Error - Contact Support" );
        }
    }

    @GET
    @Path( "/insert/" )
    public void insertIntoBasket( @QueryParam( "basket" ) Basket basket,
                                  @QueryParam( "fruit" ) Fruit fruit,
                                  @QueryParam( "qty" ) int qty ) throws Exception
    {
        try
        {
            basketCalculatorWorkflow.insertIntoBasket( basket, fruit, qty );
        }
        catch ( RuntimeException re )
        {
            log.error( "An exception occurred insertIntoBasket", re );
            throw new Exception( "Internal Server Error - Contact Support" );
        }
    }

    @GET
    @Path( "/delete/" )
    public void deleteFromBasket( @QueryParam( "basket" ) Basket basket,
                                  @QueryParam( "fruit" ) Fruit fruit,
                                  @QueryParam( "qty" ) int qty ) throws Exception
    {
        try
        {
            basketCalculatorWorkflow.deleteFromBasket( basket, fruit, qty );
        }
        catch ( RuntimeException re )
        {
            log.error( "An exception occurred deleteFromBasket", re );
            throw new Exception( "Internal Server Error - Contact Support" );
        }
    }
}
