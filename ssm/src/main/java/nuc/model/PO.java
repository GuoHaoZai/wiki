package nuc.model;

public class PO {
    private int status;
    private Object object;
    private String message;

    public PO() {
    }

    @Override
    public String toString() {
        return "PO{" +
                "status=" + status +
                ", object=" + object +
                ", message='" + message + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
