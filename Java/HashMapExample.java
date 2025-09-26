import java.util.*;
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String,Integer> employeeID = new HashMap<>();
        employeeID.put("Steven", 300414292);
        employeeID.put("Jordan", 300414232);
        employeeID.put("Zack", 30024292);
        System.out.println(employeeID);
        System.out.println(employeeID.get("Steven"));
        System.out.println(employeeID.containsKey("Josh"));
        System.out.println(employeeID.containsValue(300414292));
        // employeeID.replace(key, value) **this only work if the key already inside the hashmap, if no key detected it won't add the value
    }
}
