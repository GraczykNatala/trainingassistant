package pl.graczyk.trainingassistant.domain.exercise.dto;

public class ExerciseDto {
    private Long id;
    private String name;
    private String levelOfAdvancement;
    private String equipment;

    private String description;
    private String youtubeId;

    private String bodypart;

    private boolean recommended;

    public ExerciseDto(){

    }


    public ExerciseDto(Long id, String name,
                       String levelOfAdvancement, String equipment,
                       String description, String youtubeId,
                       String bodypart, boolean recommended) {
        this.id = id;
        this.name = name;
        this.levelOfAdvancement = levelOfAdvancement;
        this.equipment = equipment;
        this.description = description;
        this.youtubeId = youtubeId;
        this.bodypart = bodypart;
        this.recommended = recommended;
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

    public String getBodypart() {
        return bodypart;
    }

    public void setBodypart(String bodypart) {
        this.bodypart = bodypart;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }


}
