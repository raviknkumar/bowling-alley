package com.test.models;

import com.test.enums.PinStatus;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pin {

    @Getter
    private int position;

    @Getter @Setter
    private PinStatus status;
}
