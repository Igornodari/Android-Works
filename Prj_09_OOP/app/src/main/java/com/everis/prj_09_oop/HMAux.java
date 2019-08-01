package com.everis.prj_09_oop;

import java.util.HashMap;

public class HMAux extends HashMap<String, String> {

    @Override
    public String toString() {
        return get("id");
    }
}
