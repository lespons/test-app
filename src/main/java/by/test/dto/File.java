package by.test.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by lespons on 11.12.14.
 */
public abstract class File extends AbstractDto {

    protected String name;
    protected String parent;

    protected File() {
    }

    protected File(String name, String parent) {
        this.name = name;
        this.parent = parent;
    }

    protected File(String id, String name, String parent) {
        super(id);
        this.name = name;
        this.parent = parent;
    }

    @JsonSerialize
    protected abstract String getType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

}
