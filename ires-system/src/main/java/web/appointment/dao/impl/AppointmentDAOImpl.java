package web.appointment.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import web.appointment.dao.AppointmentDAO;
import web.appointment.entity.Appointment;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

    @PersistenceContext
    private Session session;

    @Override
    public int insert(Appointment appointment) {
        session.save(appointment);
        return 1;
    }

    @Override
    public int update(Appointment appointment) {
        session.update(appointment);
        return 1;
    }

    @Override
    public Appointment selectById(String id) {
        return session.get(Appointment.class, id);
    }

    @Override
    public List<Appointment> selectAll() {
        return session.createQuery("FROM Appointment", Appointment.class).list();
    }

    @Override
    public int deleteById(String id) {
        Appointment appointment = session.get(Appointment.class, id);
        if (appointment != null) {
            session.delete(appointment);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Appointment> findByDate(Date date) {
        return session.createQuery(
                "FROM Appointment WHERE appointmentDate = :today", Appointment.class)
                .setParameter("today", date)
                .getResultList();
    }

    @Override
    public List<Appointment> findByDateAndPeriod(Date date, int timePeriod) {
        String hql = "SELECT a FROM Appointment a\n"
                   + " JOIN FETCH a.doctor d\n"
                   + " JOIN FETCH a.clinic c\n"
                   + " JOIN FETCH a.patient p\n"
                   + " WHERE a.appointmentDate = :date\n"
                   + "  AND a.timePeriod = :period\n"
                   + " ORDER BY a.reserveNo ASC";
        return session.createQuery(hql, Appointment.class)
                .setParameter("date", date)
                .setParameter("period", timePeriod)
                .getResultList();
    }
}