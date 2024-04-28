package Fruit;


public class apple extends fruit {

	private fruitNames fruitName;
	private String fruitColour;
	private boolean fresh;
	
	public apple(fruitNames fruitName, String fruitColour, boolean fresh) {
		super();
		this.fruitName = fruitName;
		this.fruitColour = fruitColour;
		this.fresh = fresh;
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
	
	@Override
	public String toString() {
		return "apple [fruitName=" + fruitName + ", fruitColour=" + fruitColour + ", fresh="+ fresh + "]";
	}

	@Override
	public void taste() {
		System.out.println("-----INside Apple----- ");
		
	}
	
	public void jam() {
		System.out.println("Apple jam is sweet and sour ");
	}

}
