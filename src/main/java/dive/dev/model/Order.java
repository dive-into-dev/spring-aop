package dive.dev.model;

import java.util.List;

public class Order {
	
	private Long id;
	
	private List<String> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

}
