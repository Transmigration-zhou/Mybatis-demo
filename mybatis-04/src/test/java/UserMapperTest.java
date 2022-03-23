import com.yi.dao.UserMapper;
import com.yi.pojo.User;
import com.yi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        userDao.addUser(new User(5, "Hello","123123"));
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        userDao.updateUser(new User(5, "to","21312"));
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        userDao.deleteUser(5);
        sqlSession.close();
    }
}
