package br.com.samuelklein.dna.bean;

public class InputAlignGlobalLocal extends InputAlign {

    private static final long serialVersionUID = 4378049592190715271L;

    private Integer gap;
    private Integer match;
    private Integer misMatch;

    public Integer getGap() {
        return gap;
    }

    public void setGap(Integer gap) {
        this.gap = gap;
    }

    public Integer getMatch() {
        return match;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }

    public Integer getMisMatch() {
        return misMatch;
    }

    public void setMisMatch(Integer misMatch) {
        this.misMatch = misMatch;
    }

}