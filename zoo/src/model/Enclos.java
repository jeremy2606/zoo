package model;

public class Enclos {

	private int id;
	private String name;
	private int typeEnclosId;
	private int zooId;

	public Enclos() {

	}

	public Enclos(int id, String name, int typeEnclosId, int zooId) {
		this.id = id;
		this.name = name;
		this.typeEnclosId = typeEnclosId;
		this.zooId = zooId;
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

	public int getTypeEnclosId() {
		return typeEnclosId;
	}

	public void setTypeEnclosId(int typeEnclosId) {
		this.typeEnclosId = typeEnclosId;
	}

	public int getZooId() {
		return zooId;
	}

	public void setZooId(int zooId) {
		this.zooId = zooId;
	}

	@Override
	public String toString() {
		return "Enclos [id=" + id + ", name=" + name + ", typeEnclosId=" + typeEnclosId + ", zooId=" + zooId + "]";
	}

}
