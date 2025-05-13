@Component
public class PermissionCache {

    private Map<String/* path */, List<String> /* roles */> permissions = new ConcurrentHashMap<>();

    public synchronized void insert(String path, String role) {
        List<String> roles = permissions.computeIfAbsent(path, (key) -> new ArrayList<>());
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }

    // similar methods omitted

    public boolean hasPermission(String path, String role) {
        List<String> roles = permission.get(path);
        if (roles == null) {
            return false;
        }
        if (!roles.contains(role)) {
            return false;
        }
        return true;
    }

}
