package assignment5;

public class Category {
	
	String parent_category;
	Integer child_category;
	
	
	
	public Category(String parent_category, Integer child_category) {
		super();
		this.parent_category = parent_category;
		this.child_category = child_category;
	}
	
	public String getParent_category() {
		return parent_category;
	}
	public void setParent_category(String parent_category) {
		this.parent_category = parent_category;
	}
	public Integer getChild_category() {
		return child_category;
	}
	public void setChild_category(Integer child_category) {
		this.child_category = child_category;
	}
	
	

}
