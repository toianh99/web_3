package model;

import java.io.Serializable;

public class Province implements Serializable {
    private String NameProvince;
    private String matp;
    private String type;

    public String getNameProvince() {
        return NameProvince;
    }

    public void setNameProvince(String nameProvince) {
        NameProvince = nameProvince;
    }

    public String getMatp() {
        return matp;
    }

    public void setMatp(String matp) {
        this.matp = matp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
