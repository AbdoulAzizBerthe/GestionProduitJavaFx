package dao.entities;

public class Product {
    private  long id;
    private String name;
    private String reference;
    private float prix;

    private Category category;
    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String name, String reference, float prix, Category category) {
        this.name = name;
        this.reference = reference;
        this.prix = prix;
        this.category=category;
    }
}
