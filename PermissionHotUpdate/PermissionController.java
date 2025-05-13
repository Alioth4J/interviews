@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionCache permissionCache;

    @PostMapping("/insert")
    public Result insert(@RequestParam String url, @RequestParam String role) {
        // insert to db

        // insert to permissionCache
        permissionCache.insert(url, role);
        return Result.success();
    }

    // other methods omitted

}
