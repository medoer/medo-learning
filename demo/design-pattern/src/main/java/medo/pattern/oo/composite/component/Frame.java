package medo.pattern.oo.composite.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import medo.pattern.oo.composite.BaseCompoment;
import medo.pattern.oo.composite.Component;

public class Frame extends BaseCompoment implements Component {

    public Frame(String label) {
        setLabel(label);
    }

    private List<Component> components = new ArrayList<>();

    public void addComponent(List<Component> components) {
        this.components.addAll(components);
    }

    @Override
    public void rend() {
        System.out.println(this.getClass().getName() + " - " + this.getLabel());
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            component.rend();
        }
    }
}
