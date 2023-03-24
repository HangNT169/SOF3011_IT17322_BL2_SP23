package com.poly.hangnt169.B9_CRUDHibernate.repository;

import com.poly.hangnt169.B9_CRUDHibernate.entity.Category;
import com.poly.hangnt169.B9_CRUDHibernate.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt169
 */
public class CategoryRepository {

    // CRUD : CREATE <INSERT INTO>, READ <SELECT>, UPDATE, DELETE
    // Get all
    public List<Category> getAll() {
        List<Category> lists = new ArrayList<>();
        // Code
        // try..with resource
        // https://github.com/AnhDT0407/Course-JavaCore/blob/master/Java-Lesson/Java%207/try-with-resources.md
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Tao SQL : HQL
            Query query = session.createQuery("FROM Category", Category.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    // Get one
    public Category getOne(Long id) {
        Category category = null;
        //code
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Tao SQL : HQL
            Query query = session.createQuery("FROM Category c WHERE c.id =:id1", Category.class);
            query.setParameter("id1", id);
            category = (Category) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    // Add
    public Boolean add(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Add
            session.persist(category);
            // commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update
    public Boolean update(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(category);
            // commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete
    public Boolean delete(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Add
            session.delete(category);
            // commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
