package cl.muruna.registerUsers.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MessageResponse {

    private String messageError;
    
}
