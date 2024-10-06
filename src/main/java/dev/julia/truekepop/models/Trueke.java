package dev.julia.truekepop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trueke")
public class Trueke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;
    private String location;
    private String desiredItem;
    private String type;
    private int likes;
    
    private String ownerName; // Agregar campo ownerName

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Trueke() {}

    public Trueke(String name, String description, String image, String location, String desiredItem, String type, int likes, String ownerName, Categoria categoria) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.location = location;
        this.desiredItem = desiredItem;
        this.type = type;
        this.likes = likes;
        this.ownerName = ownerName; // Asignar el ownerName
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesiredItem() {
        return desiredItem;
    }

    public void setDesiredItem(String desiredItem) {
        this.desiredItem = desiredItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getOwnerName() { // Getter para ownerName
        return ownerName;
    }

    public void setOwnerName(String ownerName) { // Setter para ownerName
        this.ownerName = ownerName;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
