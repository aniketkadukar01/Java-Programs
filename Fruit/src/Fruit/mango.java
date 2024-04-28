package Fruit;

public class mango extends fruit {

	private fruitNames fruitName;
	private String fruitColour;
	private boolean fresh;
	
	

	public mango(fruitNames fruitName, String fruitColour, boolean fresh) {
		super();
		this.fruitName = fruitName;
		this.fruitColour = fruitColour;
		this.fresh = fresh;
	}

	@Override
	public void taste() {
		
		System.out.println("-----INside Mango----- ");
		
	}
	
	public void pulp() {
		System.out.println("sweet ");
	}

	@Override
	public String toString() {
		return "mango [fruitName=" + fruitName + ", fruitColour=" + fruitColour + ", fresh=" + fresh + "]";
	}

	public fruitNames getFruitName() {
		return fruitName;
	}

	public void setFruitName(fruitNames fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitColour() {
		return fruitColour;
	}

	public void setFruitColour(String fruitColour) {
		this.fruitColour = fruitColour;
	}

	public boolean isFresh() {
		return fresh;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}

	
	
}
