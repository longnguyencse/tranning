package search.tranning.tranning.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class People {
    private String name;
    private String email;
    private String address;
    private String phone;
    private String note;
}
