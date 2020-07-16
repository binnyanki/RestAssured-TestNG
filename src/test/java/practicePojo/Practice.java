package practicePojo;

import java.util.List;

public class Practice {

	private String cake;
	private int id;
	private String type;
	private float ppu;
	private batters batters;
	private List<topping> topping;
	
	public String getCake() {
		return cake;
	}
	public void setCake(String cake) {
		this.cake = cake;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPpu() {
		return ppu;
	}
	public void setPpu(float ppu) {
		this.ppu = ppu;
	}
	public batters getBatters() {
		return batters;
	}
	public void setBatters(batters batters) {
		this.batters = batters;
	}
	public List<topping> getTopping() {
		return topping;
	}
	public void setTopping(List<topping> topping) {
		this.topping = topping;
	}
	
}
