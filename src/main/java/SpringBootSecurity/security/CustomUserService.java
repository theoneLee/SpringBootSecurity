package SpringBootSecurity.security;

import SpringBootSecurity.dao.SysUserRepository;
import SpringBootSecurity.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Lee on 2017/6/19 0019.
 */
public class CustomUserService implements UserDetailsService{

    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser user=userRepository.findByUsername(s);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }


}
