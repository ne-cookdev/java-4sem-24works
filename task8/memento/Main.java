package mirea4sem.task8.memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // Редактируем текст
        editor.write("Строка 1");
        history.addMemento(editor.save());
        System.out.println("Текущий текст: " + editor.getText());

        // Редактируем текст ещё раз
        editor.write("Строка 2");
        history.addMemento(editor.save());
        System.out.println("Текущий текст: " + editor.getText());

        // Восстанавливаем предыдущее состояние
        editor.restore(history.getMemento(0));
        System.out.println("Текущий текст после восстановления: " + editor.getText());
    }
}
