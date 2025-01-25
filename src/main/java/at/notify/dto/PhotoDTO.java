package at.notify.dto;

import lombok.Data;

@Data
public class PhotoDTO {
    // {
    //     "file_id":"AgACAgQAAyEGAASGuq-PAAMJZ5Co7V9TFZdeuDRs6Ycm6SdKEw4AAmi2MRsUcI1QX_41ZYMnjtEBAAMCAANzAAM2BA",
    //     "file_unique_id":"AQADaLYxGxRwjVB4",
    //     "file_size":2710,
    //     "width":90,
    //     "height":90
    //  }
    private String file_id;
    private String file_unique_id;
    private Integer file_size;
    private Integer width;
    private Integer height;
}
