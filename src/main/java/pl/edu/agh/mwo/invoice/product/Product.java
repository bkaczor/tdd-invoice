package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) throws IllegalArgumentException{
		if (name == null){
			throw new IllegalArgumentException("Nawza null");
		}
		if (name == ""){
			throw new IllegalArgumentException("Pusta nazwa");
		}
		if (price == null){
			throw new IllegalArgumentException("Cena null");
		}
		if (price == price.negate()){
			throw new IllegalArgumentException("Cena ujemna");
		}
		
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return (price.add(price).multiply(taxPercent));
	}
}