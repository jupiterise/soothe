package br.com.hominid.soothe.entities.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    public UUID id;
    public UUID personId;
    public String message;
    public LocalDateTime moment;

}
