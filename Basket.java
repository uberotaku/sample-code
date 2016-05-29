package rbc.main.java;

import java.util.HashMap;
import java.util.Map;

public class Basket
{
    private Map<Fruit, Integer> items = new HashMap();

    public void insertItem( Fruit fruit, int itemCount )
    {
        if ( getItems().containsKey( fruit ) )
            getItems().put( fruit, getItems().get( fruit ) + itemCount );
        else
            getItems().put( fruit, itemCount );
    }

    public void deleteItem( Fruit fruit, int itemCount )
    {
        if ( getItems().containsKey( fruit ) )
            getItems().put( fruit, getItems().get( fruit ) - itemCount );
    }

    public Map<Fruit, Integer> getItems()
    {
        return items;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder( "Basket:/n" );
        for ( Map.Entry<Fruit, Integer> item : getItems().entrySet() )
        {
            sb.append( item.getValue() );
            sb.append( item.getKey().getName() ).append( item.getValue() > 1 ? "s" : "" );
            sb.append( " @ " ).append( item.getKey().getUnitPrice() ).append( "\n" );
        }

        return sb.toString();
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( !( o instanceof Basket ) ) return false;

        Basket basket = (Basket) o;

        if ( items != null ? !items.equals( basket.items ) : basket.items != null ) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return items != null ? items.hashCode() : 0;
    }
}
