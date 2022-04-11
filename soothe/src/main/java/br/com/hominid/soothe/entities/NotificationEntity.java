package br.com.hominid.soothe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "NotificationEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(name = "person_id", nullable = false)
    @JsonIgnore
    private UUID personId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime moment;

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "id='" + id + '\'' +
                ", personId=" + personId +
                ", message='" + message + '\'' +
                ", moment=" + moment +
                '}';
    }
}
