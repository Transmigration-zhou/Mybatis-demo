import com.yi.dao.BlogMapper;
import com.yi.pojo.Blog;
import com.yi.utils.IdUtils;
import com.yi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Java如此简单");
        map.put("author", "狂神说");

        List<Blog> list = blogMapper.queryBlogIF(map);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Java如此简单");
        map.put("views", "9999");

        List<Blog> list = blogMapper.queryBlogChoose(map);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title", "Java如此简单2");
        map.put("author", "狂神说2");
        map.put("id", "2");

        blogMapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);

        List<Blog> list = blogMapper.queryBlogForeach(map);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
