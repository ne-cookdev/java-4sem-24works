package mirea4sem.task8.memento;

// Originator
class TextEditor {
    private String text;

    public void write(String text) {
        this.text = text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        text = memento.getText();
    }

    public String getText() {
        return text;
    }
}