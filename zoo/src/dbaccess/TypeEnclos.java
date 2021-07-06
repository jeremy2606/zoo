package dbaccess;

public class TypeEnclos {

	private int id;
	private String name;
	private int typeEnvironnementId;

	public TypeEnclos() {

	}

	public TypeEnclos(int id, String name, int typeEnvironnementId) {
		this.id = id;
		this.name = name;
		this.typeEnvironnementId = typeEnvironnementId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeEnvironnementId() {
		return typeEnvironnementId;
	}

	public void setTypeEnvironnementId(int typeEnvironnementId) {
		this.typeEnvironnementId = typeEnvironnementId;
	}

	@Override
	public String toString() {
		return "TypeEnclos [id=" + id + ", name=" + name + ", typeEnvironnementId=" + typeEnvironnementId + "]";
	}

}
