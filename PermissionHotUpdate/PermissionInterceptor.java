@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private PermissionCache permissionCache;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
        String path = req.getRequestURI();
        String role = getRole(); // provide this method by yourself
        if (!permissionCache.hasPermission(path, role)) {
            return false;
        }
        return true;
    }

}
