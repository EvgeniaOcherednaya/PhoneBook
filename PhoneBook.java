import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    // Добавление номера телефона для заданного имени
    public void addPhoneNumber(String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(phoneNumber);
    }

    // Получение всех номеров телефонов для заданного имени
    public Set<String> getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, Collections.emptySet());
    }

    // Получение отсортированного списка контактов по убыванию числа телефонов
    public List<Map.Entry<String, Set<String>>> getSortedContacts() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        return entries;
    }

    // Вывод телефонной книги
    public void printPhoneBook() {
        List<Map.Entry<String, Set<String>>> sortedContacts = getSortedContacts();
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumber("Alice", "123-456-7890");
        phoneBook.addPhoneNumber("Alice", "234-567-8901");
        phoneBook.addPhoneNumber("Bob", "345-678-9012");
        phoneBook.addPhoneNumber("Bob", "456-789-0123");
        phoneBook.addPhoneNumber("Bob", "567-890-1234");
        phoneBook.addPhoneNumber("Charlie", "678-901-2345");

        phoneBook.printPhoneBook();
    }
}
