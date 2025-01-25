package at.notify.dto;

import lombok.Data;

@Data
public class SendMessageResDTO {
    // {"ok":true,"result":{"message_id":6,"from":{"id":7870237355,"is_bot":true,"first_name":"bigbond","username":"BondTHBot"},"chat":{"id":-1002260381583,"title":"UHaa!","type":"supergroup"},"date":1737531169,"text":"test"}}
    private Boolean ok;
    private ResultMessageDTO result;
}
