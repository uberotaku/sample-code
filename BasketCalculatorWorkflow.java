package rbc.main.java;

import java.math.BigDecimal;
import java.util.Map;

public class BasketCalculatorWorkflow
{
    public BigDecimal calculateBasketCost( Basket basket )
    {
        BigDecimal totalCost = BigDecimal.ZERO;
        for ( Map.Entry<Fruit, Integer> entry : basket.getItems().entrySet() )
        {
            BigDecimal costPerFruit = ( entry.getKey() ).getUnitPrice().multiply( new BigDecimal( entry.getValue() ) );
            totalCost = totalCost.add( costPerFruit );
        }
        return totalCost;
    }

    public void insertIntoBasket( Basket basket, Fruit fruit, int qty )
    {
        basket.insertItem( fruit, qty );
    }

    public void deleteFromBasket( Basket basket, Fruit fruit, int qty )
    {
        if ( basket.getItems().containsKey( fruit ))
        {
            if ( basket.getItems().get( fruit ) - qty <= 0 )
                basket.getItems().remove( fruit );
            else
                basket.deleteItem( fruit, qty );
        }
    }
}
