package module_7.finalround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Mail<T>> {
    private Map<String, List<T>> mailBox = new HashMap<>() {
        @Override
        public List<T> get(Object key) {
            return containsKey(key) ? super.get(key) : new ArrayList<>();
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Mail<T> mail) {
        String to = mail.getTo();
        List<T> list = mailBox.get(to);

        list.add(mail.getContent());
        mailBox.put(to, list);
    }
}
