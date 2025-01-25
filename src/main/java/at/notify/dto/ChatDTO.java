package at.notify.dto;

import lombok.Data;

@Data
public class ChatDTO {
// "chat":{"id":-1002260381583,"title":"UHaa!","type":"supergroup"}
    private Long id;
    private String title;
    private String type;
}
