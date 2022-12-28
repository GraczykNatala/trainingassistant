package pl.graczyk.trainingassistant.exercise;


import jakarta.persistence.*;
import pl.graczyk.trainingassistant.equipment.Equipment;

@Entity public class Exercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String levelOfAdvancement;

    @ManyToOne @JoinColumn(name = "equipment_id",
    referencedColumnName = "id")
    private Equipment equipment;
    private boolean recommended;

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

    public String getLevelOfAdvancement() {
        return levelOfAdvancement;
    }

    public void setLevelOfAdvancement(String levelOfAdvancement) {
        this.levelOfAdvancement = levelOfAdvancement;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
