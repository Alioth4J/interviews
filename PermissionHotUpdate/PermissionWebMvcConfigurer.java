@Configuration
public class PermissionWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private PermissionInterceptor permissionInterceptor;

    @Override
    public void addInterceptor(InterceptorRegistry registry) {
        reigistry.addInterceptor(permissionInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/public/**");
    }

}
