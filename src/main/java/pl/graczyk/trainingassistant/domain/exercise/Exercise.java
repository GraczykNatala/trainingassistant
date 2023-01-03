package pl.graczyk.trainingassistant.domain.exercise;

import jakarta.persistence.*;
import pl.graczyk.trainingassistant.domain.bodypart.Bodypart;

@Entity
public class Exercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String levelOfAdvancement;
    private String equipment;
    private String describtion;
    private String youtubeId;


    private boolean recommended;

    @ManyToOne @JoinColumn(name ="bodypart_id",
            referencedColumnName ="id")private Bodypart bodypart;


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

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }


}
