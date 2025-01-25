package at.notify.dto;

import lombok.Data;

@Data
public class MessageFromDTO {
// {"id":7870237355,"is_bot":true,"first_name":"bigbond","username":"BondTHBot"}
   private Long id;
   private Boolean is_bot;
   private String first_name;
   private String username;
}
