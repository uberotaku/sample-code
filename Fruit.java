package rbc.main.java;

import java.math.BigDecimal;

public class Fruit
{
    private String name;
    private BigDecimal unitPrice;

    public Fruit( String name, BigDecimal unitPrice )
    {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice( BigDecimal unitPrice )
    {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( !( o instanceof Fruit ) ) return false;

        Fruit fruit = (Fruit) o;

        if ( !name.equals( fruit.name ) ) return false;
        if ( !unitPrice.equals( fruit.unitPrice ) ) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + unitPrice.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "Fruit{" +
            "name='" + name + '\'' +
            ", unitPrice=" + unitPrice +
            '}';
    }
}
