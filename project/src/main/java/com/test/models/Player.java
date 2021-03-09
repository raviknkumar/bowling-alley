package com.test.models;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {

    @Getter
    private Integer id;

    @Getter @Setter
    private String name;
}
