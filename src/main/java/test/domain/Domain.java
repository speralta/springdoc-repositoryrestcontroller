package test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Domain {

    @Id
    private Integer id;

    private String field;

    public Integer getId() {
        return id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
