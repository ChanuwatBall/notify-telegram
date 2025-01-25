package at.notify.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResultPhotoDTO {
    // {"message_id":6,"from": MessageFromDTO }
    private Integer message_id;
    private MessageFromDTO from;
    private ChatDTO chat;
    private Long date; 
    private PhotoDTO[] photo;
    
}
