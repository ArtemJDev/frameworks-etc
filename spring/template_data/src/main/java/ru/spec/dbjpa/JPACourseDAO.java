package template_data.src.main.java.ru.spec.dbjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaCourseService")
@Transactional
@Repository
public class JPACourseDAO implements CourseDAO {

    private static final Log LOG = LogFactory.getLog(JPACourseDAO.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        LOG.info("Course find with id: + " + id);
        TypedQuery<Course> query = em.createQuery
            ("select c from Course c WHERE c.id=:id", Course.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        LOG.info("Get all courses");
//        return em.createQuery
//            ("select c from Course c", Course.class).getResultList(); //JPQL
            //NamedQuery
        return em.createNamedQuery(Course.FIND_ALL, Course.class).getResultList();
    }

    @Override
    public List<Course> findByTitle(String title) {
    TypedQuery<Course> query = em.createQuery
        ("select c from Course c WHERE c.title LIKE :title", Course.class);
    query.setParameter("title",  "%" + title + "%");
        return query.getResultList();
    }

    @Override
    public void insert(Course course) {
        em.persist(course);
    }

    @Override
    public void update(Course course) {
    if(course.getId() != 0 && em.find(Course.class, course.getId()) != null) {
            em.merge(course);
        }
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Course.class, id));
    }
}
