package hibernateejemplobasico;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Crear un usuario
        Usuario usuario = new Usuario("Juan Pérez", "juan@example.com");
        saveUsuario(usuario);

        // Leer el usuario
        Usuario usuarioLeido = getUsuario(usuario.getId());
        System.out.println("Usuario leído: " + usuarioLeido.getNombre());

        // Actualizar el usuario
        usuarioLeido.setNombre("Juan Pérez Actualizado");
        updateUsuario(usuarioLeido);

        // Eliminar el usuario
        //deleteUsuario(usuarioLeido.getId());

        // Cerrar la sesión de Hibernate
        HibernateUtil.shutdown();
    }

    public static void saveUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
            System.out.println("Usuario guardado: " + usuario.getNombre());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static Usuario getUsuario(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        }
    }

    public static void updateUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
            System.out.println("Usuario actualizado: " + usuario.getNombre());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteUsuario(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
                System.out.println("Usuario eliminado: " + usuario.getNombre());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
