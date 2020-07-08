package medo.pattern.oo.composite.component;

import medo.pattern.oo.composite.BaseCompoment;
import medo.pattern.oo.composite.Component;

public class Label extends BaseCompoment implements Component {

    public Label(String label) {
        setLabel(label);
    }

    @Override
    public void rend() {
        System.out.println(this.getClass().getName() + " - " + this.getLabel());
    }

}
