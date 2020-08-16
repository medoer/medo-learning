package medo.pattern.oo.decrotor;

import java.util.UUID;

public class Entity {

    public String getId() {
        return UUID.randomUUID().toString();
    }

}
