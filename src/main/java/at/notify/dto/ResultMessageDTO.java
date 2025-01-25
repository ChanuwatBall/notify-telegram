package at.notify.dto;

import lombok.Data;

@Data
public class ResultMessageDTO {
    // {"message_id":6,"from": MessageFromDTO }
    private Integer message_id;
    private MessageFromDTO from;
    private ChatDTO chat;
    private Long date;
    private String text;
    
}
