package by.test.dto;

/**
 * Created by lespons on 12.12.14.
 */
public class TextFile extends File {

    private static final String TYPE = TextFile.class.getSimpleName().toLowerCase();

    protected String content;

    public TextFile() {
    }

    public TextFile(String id, String name, String parent) {
        super(id, name, parent);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected String getType() {
        return TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TextFile textFile = (TextFile) o;

        if (content != null ? !content.equals(textFile.content) : textFile.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
