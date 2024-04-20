package com.codecool.generalizedfizzbuzz.service.game;

import com.codecool.generalizedfizzbuzz.model.GameSpecification;

public interface GameService {
    String play(int number, GameSpecification spec);
}
