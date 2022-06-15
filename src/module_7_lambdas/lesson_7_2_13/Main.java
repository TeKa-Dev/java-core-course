package module_7_lambdas.lesson_7_2_13;

import java.util.*;
import java.util.function.Consumer;

public class Main {

public abstract static class Mail<T> {
    private String from;
    private String to;
    private T content;
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public T getContent() {
        return content;
    }
}

public static class MailMessage extends Mail<String> {
    public MailMessage(String from, String to, String content) {
        super.from = from;
        super.to = to;
        super.content = content;
    }
}

public static class Salary extends Mail<Integer> {
    public Salary(String from, String to, Integer content) {
        super.from = from;
        super.to = to;
        super.content = content;
    }
}

public static class MailService<T> implements Consumer<Mail<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>() {
        @Override
        public List<T> get(Object key) {
            if (containsKey(key)) {
                return super.get(key);
            }
            return new ArrayList<>();
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Mail<T> mail) {
        List<T> temp = mailBox.get(mail.getTo());
        if (temp == null) {
            temp = new ArrayList<>();
        }
        temp.add(mail.getContent());
        mailBox.put(mail.getTo(), temp);
    }

}


}
