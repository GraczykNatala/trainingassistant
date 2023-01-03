package pl.graczyk.trainingassistant.domain.recordTracking;

import jakarta.persistence.*;
import pl.graczyk.trainingassistant.domain.exercise.Exercise;
import pl.graczyk.trainingassistant.domain.user.User;

@Entity
@Table(name = "record_tracking")
public class RecordTracking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name="user_id") private User user;
    @ManyToOne @JoinColumn(name="exercise_id") private Exercise exercise;
    private Integer personalRecord;

    public RecordTracking() {

    }

    public RecordTracking(User user, Exercise exercise, Integer personalRecord) {
        this.user = user;
        this.exercise = exercise;
        this.personalRecord = personalRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Integer getPersonalRecord() {
        return personalRecord;
    }

    public void setPersonalRecord(Integer personalRecord) {
        this.personalRecord = personalRecord;
    }
}
