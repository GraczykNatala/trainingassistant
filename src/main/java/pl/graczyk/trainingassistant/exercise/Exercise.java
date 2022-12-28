package pl.graczyk.trainingassistant.exercise;


import jakarta.persistence.*;
import pl.graczyk.trainingassistant.bodypart.Bodypart;

@Entity public class Exercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String levelOfAdvancement;
    private String equipment;

    @ManyToOne @JoinColumn(name = "bodypart_id",
    referencedColumnName = "id")
    private Bodypart bodypart;


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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Bodypart getBodypart() {
        return bodypart;
    }

    public void setBodypart(Bodypart bodypart) {
        this.bodypart = bodypart;
    }

}
