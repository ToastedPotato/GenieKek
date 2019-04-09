package transport;

import transport.section.Section;

import java.util.ArrayList;
import java.util.Arrays;

public class Transport {

    private String id;
    private ArrayList<Section> sections = new ArrayList<>();

    public Transport() {

    }

    public void setId(String num) {
        this.id = num;
    }

    public String getId() {
        return id;
    }

    public void setSections(Section[] sections) {
        this.sections.addAll(Arrays.asList(sections));
    }

    public Transport addSection(Section section) {
        // si l'élément existe déjà on sort
        if (sections.indexOf(section) > 0) return this;
        sections.add(section);
        return this;
    }
}
