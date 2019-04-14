package transport;

import transport.section.Section;

import java.util.ArrayList;

public class Transport {

    private String id;
    private ArrayList<Section> sections = new ArrayList<>();
    private Class<?> sectionClass;

    public Transport(Class<?> sectionClass) {
        this.sectionClass = sectionClass;
    }

    public Class<?> getSectionClass() {
        return sectionClass;
    }

    public void setId(String num) {
        this.id = num;
    }

    public String getId() {
        return id;
    }

    public boolean haveSection(Section section) {
        for (Section s : sections)
            if (s.getStr().equals(section.getStr())) return true;
        return false;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public Transport addSection(Section section) {
        // si l'élément existe déjà on sort
        if (sections.indexOf(section) > 0) return this;
        sections.add(section);
        return this;
    }
}
