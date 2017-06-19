package SpringBootSecurity.dao;

import SpringBootSecurity.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lee on 2017/6/19 0019.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{
    SysUser findByUsername(String username);
}
