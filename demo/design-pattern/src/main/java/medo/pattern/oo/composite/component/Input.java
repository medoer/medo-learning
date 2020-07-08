package medo.pattern.oo.composite.component;

import medo.pattern.oo.composite.BaseCompoment;
import medo.pattern.oo.composite.Component;

public class Input extends BaseCompoment implements Component {

    
    public Input(String label) {
        setLabel(label);
    }

    @Override
    public void rend() {
        System.out.println(this.getClass().getName() + " - " + this.getLabel());
    }

}
