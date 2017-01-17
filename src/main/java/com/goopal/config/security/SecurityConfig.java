package com.goopal.config.security;

/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2016/12/17
 * @company: (C) Copyright 阳光互信 2016
 * @since: JDK 1.8
 * @description: Spring Security 必须配置在一个实现了WebSecurityConfigurer的bean中，或者（简单起见）扩展WebSecurityConfigurerAdapter。
 *               @EnableWebSecurity 可以启用任意Web应用的安全性应用
 *
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig{
//        extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER","ADMIN");
//
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//                return null;
//            }
//        });
//
//    }

    /*
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.jdbcAuthentication().dataSource(dataSource);

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password true from user where username = ?"
                ).authoritiesByUsernameQuery(
                        "select username, 'ROLE_USER' from user where username = ?"
                ).passwordEncoder(new StandardPasswordEncoder("123456"));

    }*/
}
