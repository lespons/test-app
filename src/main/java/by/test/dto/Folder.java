package by.test.dto;

/**
 * Created by lespons on 11.12.14.
 */
public class Folder extends File {
    private static final String TYPE = Folder.class.getSimpleName().toLowerCase();

    public Folder() {
    }

    public Folder(String name, String parent) {
        super(name, parent);
    }

    public Folder(String id, String name, String parent) {
        super(id, name, parent);
    }

    @Override
    protected String getType() {
        return TYPE;
    }

}
