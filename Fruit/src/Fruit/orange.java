package Fruit;

public class orange extends fruit {

	private fruitNames fruitName;
	private String fruitColour;
	private boolean fresh;
	
	
	
	public orange(fruitNames fruitName, String fruitColour, boolean fresh) {
		super();
		this.fruitName = fruitName;
		this.fruitColour = fruitColour;
		this.fresh = fresh;
	}
	
	
	
	@Override
	public String toString() {
		return "orange [fruitName=" + fruitName + ", fruitColour=" + fruitColour + ", fresh=" + fresh + "]";
	}



	@Override
	public void taste() {
		System.out.println("-----INside orange----- ");
		
	}
	
	public void juice() {
		System.out.println("sour");
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
