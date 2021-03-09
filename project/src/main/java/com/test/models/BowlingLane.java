package com.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BowlingLane {

    private List<Pin> pins;
    private int knockedPins;
    private int totalPins;
}
