package pl.graczyk.trainingassistant.domain.bodypart.dto;

public class BodypartDto {
    private Long id;
    private String name;
    private String describtion;


    public BodypartDto(){

    }
    public BodypartDto(Long id, String name, String describtion) {
        this.id = id;
        this.name = name;
        this.describtion = describtion;
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

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }
}
